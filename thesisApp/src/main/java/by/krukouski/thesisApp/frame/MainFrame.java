package by.krukouski.thesisapp.frame;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import by.krukouski.thesisapp.frame.panel.ComparePanel;
import by.krukouski.thesisapp.frame.panel.MillerRabinAlgorithmPanel;
import by.krukouski.thesisapp.frame.panel.SolovayStrassenAlgorithmPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class MainFrame extends JFrame {
	public MainFrame() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmImport = new JMenuItem("Import");
		mnFile.add(mntmImport);
		
		JMenuItem mntmClean = new JMenuItem("Clean");
		mnFile.add(mntmClean);
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
		
		JSeparator separator_2 = new JSeparator();
		mnHelp.add(separator_2);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		/*JPanel panel = new JPanel();
		tabbedPane.addTab("Solovay-Strassen", null, panel, null);
		panel.setLayout(new SpringLayout());
		*/
		SolovayStrassenAlgorithmPanel panel = new SolovayStrassenAlgorithmPanel();
		tabbedPane.addTab("Solovay-Strassen", null, panel, null);
				
		JPanel panel_1 = new MillerRabinAlgorithmPanel();
		tabbedPane.addTab("Miller-Rabin", null, panel_1, null);
		
		JPanel panel_2 = new ComparePanel();
		tabbedPane.addTab("Compare", null, panel_2, null);
		panel_2.setLayout(new SpringLayout());
		
		this.setSize(500, 500);
		this.setVisible(true);
	}

}
