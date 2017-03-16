package by.krukouski.thesisapp.frame.panel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import by.krukouski.thesisapp.frame.panel.text.TextEditorPanel;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.TextArea;
import javax.swing.JInternalFrame;

public class MainAlgorithmPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public MainAlgorithmPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JRadioButton rdbtnMethod = new JRadioButton("Method 1");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMethod, 86, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMethod, 51, SpringLayout.WEST, this);
		buttonGroup.add(rdbtnMethod);
		add(rdbtnMethod);
		
		JRadioButton rdbtnMethod_1 = new JRadioButton("Method 2");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMethod_1, 51, SpringLayout.WEST, this);
		buttonGroup.add(rdbtnMethod_1);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMethod_1, 0, SpringLayout.SOUTH, rdbtnMethod);
		add(rdbtnMethod_1);
		
		JRadioButton rdbtnMethod_2 = new JRadioButton("Method 3");
		springLayout.putConstraint(SpringLayout.WEST, rdbtnMethod_2, 51, SpringLayout.WEST, this);
		buttonGroup.add(rdbtnMethod_2);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnMethod_2, 0, SpringLayout.SOUTH, rdbtnMethod_1);
		add(rdbtnMethod_2);
		
		JTextPane textPane = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPane, 86, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textPane, -129, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, textPane, -51, SpringLayout.EAST, this);
		add(textPane);
		
		JLabel lblProbability = new JLabel("Probability");
		springLayout.putConstraint(SpringLayout.NORTH, lblProbability, 4, SpringLayout.NORTH, rdbtnMethod);
		springLayout.putConstraint(SpringLayout.EAST, lblProbability, -10, SpringLayout.WEST, textPane);
		add(lblProbability);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 19));
		springLayout.putConstraint(SpringLayout.NORTH, lblResult, 23, SpringLayout.SOUTH, rdbtnMethod_2);
		springLayout.putConstraint(SpringLayout.WEST, lblResult, 91, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblResult, 54, SpringLayout.SOUTH, rdbtnMethod_2);
		springLayout.putConstraint(SpringLayout.EAST, lblResult, 358, SpringLayout.WEST, this);
		add(lblResult);
		
		JButton btnCheck = new JButton("Check");
		springLayout.putConstraint(SpringLayout.WEST, btnCheck, 188, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCheck, -26, SpringLayout.SOUTH, this);
		btnCheck.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(btnCheck);
		
		//JPanel panel = new JPanel();
		TextEditorPanel panel = new TextEditorPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 101, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -12, SpringLayout.NORTH, rdbtnMethod);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, lblResult);
		add(panel);
		
	}
}
