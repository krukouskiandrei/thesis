package by.krukouski.thesisapp.frame.panel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigInteger;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

import org.jfree.ui.RefineryUtilities;

import by.krukouski.prime.algorithms.facades.CommonAlgorithmsFacades;
import by.krukouski.prime.algorithms.facades.MillerRabinFacades;
import by.krukouski.prime.utils.symbols.TimeTracker;
import by.krukouski.thesisapp.frame.panel.chart.EstimateAlgorithmsBarChartFrame;
import by.krukouski.thesisapp.frame.panel.text.TextEditorPanel;

public class ComparePanel extends JPanel {
	
	private final Action action = new SwingAction();
	private final TextEditorPanel textEditorPanel = new TextEditorPanel();
	private final JLabel lblResult;
	private final JLabel lblProbability;
	private final JTextPane textPane;
	
	public ComparePanel() {
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
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
		springLayout.putConstraint(SpringLayout.EAST, lblProbability, -10, SpringLayout.WEST, textPane);
		add(lblProbability);
		
		lblResult = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblResult, 72, SpringLayout.SOUTH, textPane);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 19));
		springLayout.putConstraint(SpringLayout.WEST, lblResult, 91, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblResult, 358, SpringLayout.WEST, this);
		add(lblResult);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setAction(action);
		springLayout.putConstraint(SpringLayout.SOUTH, lblResult, -40, SpringLayout.NORTH, btnCheck);
		springLayout.putConstraint(SpringLayout.WEST, btnCheck, 188, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCheck, -26, SpringLayout.SOUTH, this);
		btnCheck.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(btnCheck);
		
		//JPanel panel = new JPanel();
		
		springLayout.putConstraint(SpringLayout.NORTH, textEditorPanel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textEditorPanel, -12, SpringLayout.NORTH, textPane);
		springLayout.putConstraint(SpringLayout.NORTH, lblProbability, 16, SpringLayout.SOUTH, textEditorPanel);
		springLayout.putConstraint(SpringLayout.WEST, textEditorPanel, 101, SpringLayout.WEST, this);
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
					BigInteger number = getNumber();
					Integer probability = getProbability();
					checkNumber(number, probability);
					
				}catch(Exception exc){
					//throw Exception!!!!
					System.out.println("93");
				}
				
				final EstimateAlgorithmsBarChartFrame demo = new EstimateAlgorithmsBarChartFrame("Algorithms time");
				demo.pack();
		        RefineryUtilities.centerFrameOnScreen(demo);
		        demo.setVisible(true);
		        
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
	
	
	
	private BigInteger getNumber() throws NumberFormatException {
		BigInteger number = new BigInteger(textEditorPanel.getText());
		return number;
	}
	
	private Integer getProbability() throws NumberFormatException {
		Integer number = new Integer(textPane.getText());
		return number;
	}
	
	private void checkNumber(BigInteger number, Integer probability) {
		boolean result = CommonAlgorithmsFacades.checkNumber(number, probability);
		if(result){
			lblResult.setText("IS PRIME");
			System.out.println(TimeTracker.getInstance().getTracker());
		}else{
			lblResult.setText("NOT PRIME");
		}
	}
	
	

}
