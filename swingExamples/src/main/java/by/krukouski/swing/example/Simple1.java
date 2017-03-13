package by.krukouski.swing.example;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Simple1 extends JFrame {
	
	//private JFrame frame;
	
	public Simple1(){
		JButton button = new JButton("click");
		button.setBounds(130, 100, 100, 40);
		add(button);
		setSize(400, 500);
		setLayout(null);
		setVisible(true);
	}
	
	

}
