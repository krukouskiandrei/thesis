package by.krukouski.thesisApp.frame;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import by.krukouski.thesisApp.frame.menu.MainMenuBar;

public class MainFrame {

	private static final int HEIGHT_WINDOW = 700;
	private static final int WIDTH_WINDOW = 500;
	
	private JFrame mainFrame;
	private JPanel mainPanel;
	
	public MainFrame() {
		prepareGUI();
	}
	
	private void prepareGUI() {
		mainFrame = new JFrame("Prime Numbers Recognizer");
		mainFrame.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		mainFrame.setLayout(new GridLayout(1, 1));
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 1));
		
		mainFrame.add(mainPanel);
		MainMenuBar menuBar = new MainMenuBar();
		mainFrame.setJMenuBar(menuBar.getMenuBar());
		mainFrame.setVisible(true);		
	}
	
	private void buildMainPanel() {
		
	}
	
}
