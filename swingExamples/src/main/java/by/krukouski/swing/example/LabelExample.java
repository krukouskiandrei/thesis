package by.krukouski.swing.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LabelExample extends JFrame implements ActionListener {
	
	private JTextField textField;
	private JLabel label;
	private JButton button;
	
	public LabelExample(){
		
		textField = new JTextField();
		textField.setBounds(50, 50, 150, 20);
		label = new JLabel();
		label.setBounds(50, 100, 250, 20);
		button = new JButton("Find IP");
		button.setBounds(50, 150, 95, 30);
		button.addActionListener(this);
		add(button);
		add(label);
		add(textField);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);		
	}
	
	public void actionPerformed(ActionEvent event){
		try{
			String host = textField.getText();
			String ip = InetAddress.getByName(host).getHostAddress();
			label.setText("IP of " + host + " is: " + ip);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	

}
