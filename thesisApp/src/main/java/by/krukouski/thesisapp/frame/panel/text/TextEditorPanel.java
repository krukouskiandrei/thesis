package by.krukouski.thesisapp.frame.panel.text;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.SwingConstants;

public class TextEditorPanel extends JPanel implements DocumentListener {

	private static final long serialVersionUID = 7840185264770309196L;
	private JTextArea textArea;	
	private JTextField txt_number_off_characters;
	
	public TextEditorPanel() {
		//super("Test");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);		
		textArea = new JTextArea();
		Font f = new Font("Courier", Font.PLAIN, 14);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		//LimitedRowLengthDocument myDoc = new LimitedRowLengthDocument(textArea);		
		DefaultStyledDocument myDoc = new DefaultStyledDocument();
		textArea.setDocument(myDoc);
		myDoc.addDocumentListener(this);		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		txt_number_off_characters = new JTextField();
		txt_number_off_characters.setHorizontalAlignment(SwingConstants.CENTER);
		txt_number_off_characters.setFont(new Font("Times New Roman", Font.PLAIN, 12));
				
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		this.setMinimumSize(new Dimension(400, 250));
		this.setPreferredSize(new Dimension(400, 250));
		
		add(txt_number_off_characters, BorderLayout.SOUTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		//pack();
		setVisible(true);

	}
	
	public void changedUpdate(DocumentEvent e) {
	}
	
	public String getText() {
		return textArea.getText();
	}
	
	public void cleanTextArea() {
		textArea.setText("");
	}
	public void insertUpdate(DocumentEvent e) {		
		final Document doc = e.getDocument();
		txt_number_off_characters.setText("Numberlength: " + String.valueOf(doc.getLength()));		
	}


	public void removeUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		txt_number_off_characters.setText("Numberlength: " + String.valueOf(doc.getLength()));
	}
}
