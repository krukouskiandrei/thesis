package by.krukouski.thesisApp.frame.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainMenuBar extends JMenuBar {
	
	private static final String MENU_FILE = "File";
	private static final String MENU_EDIT = "Edit";
	private static final String MENU_HELP = "Help";
	
	private static final String MENU_FILE_ITEM_NEW = "New";
	private static final String MENU_FILE_ITEM_IMPORT = "Import";
	private static final String MENU_FILE_ITEM_EXIT = "Exit";
	private static final String MENU_EDIT_ITEM_CUT = "Cut";
	private static final String MENU_EDIT_ITEM_COPY = "Copy";
	private static final String MENU_EDIT_ITEM_PASTE = "Paste";
	private static final String MENU_EDIT_ITEM_CLEAN = "Clean";
	private static final String MENU_HELP_ITEM_HELP = "Help";
	private static final String MENU_HELP_ITEM_ABOUT = "About";
	
	private final JMenuBar menuBar;
	
	public  MainMenuBar() {
		menuBar = new JMenuBar();
		prepareMenuBar();
	}
	
	private void prepareMenuBar() {
		JMenu fileMenu = new JMenu(MENU_FILE);
		JMenu editMenu = new JMenu(MENU_EDIT);
		JMenu helpMenu = new JMenu(MENU_HELP);
		
		JMenuItem newMenuItem = createItemWithAction(MENU_FILE_ITEM_NEW);
		JMenuItem importMenuItem = createItemWithAction(MENU_FILE_ITEM_IMPORT);
		JMenuItem exitMenuItem = createItemWithAction(MENU_FILE_ITEM_EXIT);
		JMenuItem cutMenuItem = createItemWithAction(MENU_EDIT_ITEM_CUT);
		JMenuItem copyMenuItem = createItemWithAction(MENU_EDIT_ITEM_COPY);
		JMenuItem pasteMenuItem = createItemWithAction(MENU_EDIT_ITEM_PASTE);
		JMenuItem cleanMenuItem = createItemWithAction(MENU_EDIT_ITEM_CLEAN);
		JMenuItem helpMenuItem = createItemWithAction(MENU_HELP_ITEM_HELP);
		JMenuItem aboutMenuItem = createItemWithAction(MENU_HELP_ITEM_ABOUT);
		
		exitMenuItem.addActionListener(new ExitListener());
		
		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(importMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		editMenu.addSeparator();
		editMenu.add(cleanMenuItem);
		helpMenu.add(helpMenuItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutMenuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);					
	}
	
	public JMenuBar getMenuBar(){
		return menuBar;
	}
	
	private JMenuItem createItemWithAction(String itemName){
		JMenuItem menuItem = new JMenuItem(itemName);
		menuItem.setActionCommand(itemName);
		return menuItem;
	}
	
	private class ExitListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
           
        }
    }
	

}
