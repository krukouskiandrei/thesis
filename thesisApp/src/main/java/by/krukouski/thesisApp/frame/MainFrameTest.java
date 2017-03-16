package by.krukouski.thesisapp.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import by.krukouski.thesisapp.algorithms.probability.SolovayStrassen;

public class MainFrameTest extends JFrame implements ActionListener {
	
	private JTextField primeNumberField;
	private JTextField resultField;
	private JButton mainButton;
	private JLabel errorLabel;
	
	public MainFrameTest(){
		primeNumberField = new JTextField();
		primeNumberField.setBounds(100, 100, 800, 50);
		resultField = new JTextField();
		resultField.setBounds(100, 200, 800, 50);
		errorLabel = new JLabel();
		errorLabel.setBounds(300, 25, 400, 25);
		resultField.setEditable(false);
		mainButton = new JButton("Determine");
		mainButton.setBounds(300, 300, 400, 100);
		mainButton.addActionListener(this);
		add(primeNumberField);
		add(resultField);
		add(mainButton);
		add(errorLabel);
		setSize(1000, 500);
		setLayout(null);
		setVisible(true);
	}	
		
	public void actionPerformed(ActionEvent event){
		try{
		errorLabel.setText("");	
		String number = primeNumberField.getText();
		String result = SolovayStrassen.check(number);
		resultField.setText(result);
		primeNumberField.setText("");
		}catch(NumberFormatException e){
			errorLabel.setText("Please, enter the corect number");
		}
		
		
	}

}
