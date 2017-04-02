package by.krukouski.thesisapp.frame.panel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import by.krukouski.thesisapp.frame.panel.text.TextEditorPanel;

public class MillerRabinAlgorithmPanel extends JPanel {
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public MillerRabinAlgorithmPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JTextPane textPane = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, textPane, 86, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textPane, -129, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, textPane, -51, SpringLayout.EAST, this);
		add(textPane);
		
		JLabel lblProbability = new JLabel("Probability");
		springLayout.putConstraint(SpringLayout.EAST, lblProbability, -10, SpringLayout.WEST, textPane);
		add(lblProbability);
		
		JLabel lblResult = new JLabel("Result");
		springLayout.putConstraint(SpringLayout.NORTH, lblResult, 72, SpringLayout.SOUTH, textPane);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 19));
		springLayout.putConstraint(SpringLayout.WEST, lblResult, 91, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblResult, 358, SpringLayout.WEST, this);
		add(lblResult);
		
		JButton btnCheck = new JButton("Check");
		springLayout.putConstraint(SpringLayout.SOUTH, lblResult, -40, SpringLayout.NORTH, btnCheck);
		springLayout.putConstraint(SpringLayout.WEST, btnCheck, 188, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCheck, -26, SpringLayout.SOUTH, this);
		btnCheck.setFont(new Font("Times New Roman", Font.BOLD, 14));
		add(btnCheck);
		
		//JPanel panel = new JPanel();
		TextEditorPanel panel = new TextEditorPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -12, SpringLayout.NORTH, textPane);
		springLayout.putConstraint(SpringLayout.NORTH, lblProbability, 16, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel, 101, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, lblResult);
		add(panel);
		
	}

}
