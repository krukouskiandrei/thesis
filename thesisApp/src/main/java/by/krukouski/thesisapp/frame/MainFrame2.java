package by.krukouski.thesisapp.frame;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import by.krukouski.thesisapp.frame.menu.MainMenuBar;
import by.krukouski.thesisapp.frame.panel.MainTabbedPanel;

public class MainFrame2 {

	private static final int HEIGHT_WINDOW = 700;
	private static final int WIDTH_WINDOW = 500;
	
	private JFrame mainFrame;
	private JPanel mainPanel;
	
	public MainFrame2() {
		prepareGUI();
		buildMainPanel();
	}
	
	private void prepareGUI() {
		mainFrame = new JFrame("Prime Numbers Recognizer");
		mainFrame.setSize(WIDTH_WINDOW, HEIGHT_WINDOW);
		mainFrame.setLayout(new GridLayout(1, 1));
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		mainFrame.add(mainPanel);
		MainMenuBar menuBar = new MainMenuBar();
		mainFrame.setJMenuBar(menuBar.getMenuBar());
		mainFrame.setVisible(true);		
	}
	
	private void buildMainPanel() {
		MainTabbedPanel tabbedPanel = new MainTabbedPanel();
		mainPanel.add(tabbedPanel.getTabbedPanel());
	}
	
}
