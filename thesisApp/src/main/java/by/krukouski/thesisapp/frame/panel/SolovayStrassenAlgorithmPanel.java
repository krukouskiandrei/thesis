package by.krukouski.thesisapp.frame.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

import by.krukouski.prime.algorithms.facades.SolovayStrassenFacades;
import by.krukouski.thesisapp.frame.panel.text.TextEditorPanel;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.Enumeration;

import javax.swing.Action;

public class SolovayStrassenAlgorithmPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();
	private final TextEditorPanel textEditorPanel = new TextEditorPanel();
	private final JLabel lblResult;
	private final JLabel lblProbability;
	private final JTextPane textPane;
	public SolovayStrassenAlgorithmPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JRadioButton rdbtnMethod = new JRadioButton("Usualy algorithm");
		rdbtnMethod.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMethod, 86, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMethod, 51, SpringLayout.WEST, this);
		buttonGroup.add(rdbtnMethod);
		add(rdbtnMethod);
		
		JRadioButton rdbtnMethod_1 = new JRadioButton("Binary algorithm");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMethod_1, 51, SpringLayout.WEST, this);
		buttonGroup.add(rdbtnMethod_1);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMethod_1, 0, SpringLayout.SOUTH, rdbtnMethod);
		add(rdbtnMethod_1);
		
		JRadioButton rdbtnMethod_2 = new JRadioButton("O(M(n)log(n)) algotithm");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMethod_2, 51, SpringLayout.WEST, this);
		buttonGroup.add(rdbtnMethod_2);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMethod_2, 0, SpringLayout.SOUTH, rdbtnMethod_1);
		rdbtnMethod_2.setEnabled(false);
		add(rdbtnMethod_2);
		
		textPane = new JTextPane(new DefaultStyledDocument() {
		    @Override
		    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		        if ((getLength() + str.length()) <= 5) {
		            super.insertString(offs, str, a);
		        }
		        else {
		            Toolkit.getDefaultToolkit().beep();
		        }
		    }
		});
		springLayout.putConstraint(SpringLayout.NORTH, textPane, 86, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textPane, -129, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, textPane, -51, SpringLayout.EAST, this);
		add(textPane);
		
		lblProbability = new JLabel("Probability");
		springLayout.putConstraint(SpringLayout.NORTH, lblProbability, 4, SpringLayout.NORTH, rdbtnMethod);
		springLayout.putConstraint(SpringLayout.EAST, lblProbability, -10, SpringLayout.WEST, textPane);
		add(lblProbability);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 19));
		springLayout.putConstraint(SpringLayout.NORTH, lblResult, 23, SpringLayout.SOUTH, rdbtnMethod_2);
		springLayout.putConstraint(SpringLayout.WEST, lblResult, 91, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblResult, 54, SpringLayout.SOUTH, rdbtnMethod_2);
		springLayout.putConstraint(SpringLayout.EAST, lblResult, 358, SpringLayout.WEST, this);
		add(lblResult);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setAction(action);
		springLayout.putConstraint(SpringLayout.WEST, btnCheck, 188, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCheck, -26, SpringLayout.SOUTH, this);
		btnCheck.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(btnCheck);
		
		//JPanel panel = new JPanel();
		
		springLayout.putConstraint(SpringLayout.NORTH, textEditorPanel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textEditorPanel, 101, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textEditorPanel, -12, SpringLayout.NORTH, rdbtnMethod);
		springLayout.putConstraint(SpringLayout.EAST, textEditorPanel, 0, SpringLayout.EAST, lblResult);
		add(textEditorPanel);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Check");
			putValue(SHORT_DESCRIPTION, "Check number");
		}
		public void actionPerformed(ActionEvent e) {
		
			if(getValue(NAME).equals("Check")){
				
				try{
					String jacobiMethod = defineJacobiAlgorithm();
					BigInteger number = getNumber();
					Integer probability = getProbability();
					checkNumber(jacobiMethod, number, probability);
					
				}catch(Exception exc){
					//throw Exception!!!!
					System.out.println("93");
				}
				
				putValue(NAME, "Clean");
				putValue(SHORT_DESCRIPTION, "Clean text editor");
			}else{
				lblResult.setText("");
				textEditorPanel.cleanTextArea();
				textPane.setText("");
				putValue(NAME, "Check");
				putValue(SHORT_DESCRIPTION, "Check number");
			}
			
		}
	}
	
	private String defineJacobiAlgorithm() throws Exception {
		Enumeration<AbstractButton> radioButtons = buttonGroup.getElements();
		while(radioButtons.hasMoreElements()){
			AbstractButton radioButton = radioButtons.nextElement();
			if(radioButton.isSelected()){
				return radioButton.getText();
			}
		}
		throw new Exception();
	}
	
	private BigInteger getNumber() throws NumberFormatException {
		BigInteger number = new BigInteger(textEditorPanel.getText());
		return number;
	}
	
	private Integer getProbability() throws NumberFormatException {
		Integer number = new Integer(textPane.getText());
		return number;
	}
	
	private void checkNumber(String jacobiMethod, BigInteger number, Integer probability) {
		boolean result = SolovayStrassenFacades.checkNumber(jacobiMethod, number, probability);
		if(result){
			lblResult.setText("IS PRIME");
		}else{
			lblResult.setText("NOT PRIME");
		}
	}
}
