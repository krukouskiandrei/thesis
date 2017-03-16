package by.krukouski.thesisapp.frame.panel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainTabbedPanel {
	
	private final JTabbedPane tabbedPanel;
	
	public MainTabbedPanel() {
		tabbedPanel = new JTabbedPane();
		prepareTabbedPanel();		
	}
	
	private void prepareTabbedPanel() {
		tabbedPanel.setSize(200, 200);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		tabbedPanel.add("Solovay", p1);
		tabbedPanel.add("Muler", p2);
		tabbedPanel.add("Compare", p3);
	}
	
	public JTabbedPane getTabbedPanel() { 
		return tabbedPanel;
	}

}
