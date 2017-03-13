package by.krukouski.swing.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextFieldExample implements ActionListener {
	
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	
	private JButton button1;
	private JButton button2;
	
	public TextFieldExample(){
		JFrame frame = new JFrame();
		textField1 = new JTextField();
		textField1.setBounds(50, 50, 150, 50);
		textField2 = new JTextField();
		textField2.setBounds(50, 100, 150, 50);
		textField3 = new JTextField();
		textField3.setBounds(50, 150, 150, 50);
		textField3.setEditable(false);
		button1 = new JButton("+");
		button1.setBounds(50, 200, 50, 50);
		button2 = new JButton("-");
		button2.setBounds(120, 200, 50, 50);
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.add(textField1);
		frame.add(textField2);
		frame.add(textField3);
		frame.add(button1);
		frame.add(button2);
		frame.setSize(300, 300);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
		String s1 = textField1.getText();
		String s2 =  textField2.getText();
		int a = Integer.parseInt(s1);
		int b = Integer.parseInt(s2);
		int c = 0;
		if(event.getSource()==button1){
			c = a+b;
		}else if(event.getSource() == button2){
			c = a-b;
		}
		String result = String.valueOf(c);
		textField3.setText(result);
	}

}
