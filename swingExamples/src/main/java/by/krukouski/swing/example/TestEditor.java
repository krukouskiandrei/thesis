package by.krukouski.swing.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;

public class TestEditor extends JFrame implements DocumentListener {

	private static final long serialVersionUID = 7840185264770309196L;
	private JTextArea textArea;	
	private JTextField txt_number_off_characters;
	
	public TestEditor() {
		super("Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		textArea = new JTextArea();
		Font f = new Font("Courier", Font.PLAIN, 18);
		textArea.setFont(f);
		//LimitedRowLengthDocument myDoc = new LimitedRowLengthDocument(textArea);		
		DefaultStyledDocument myDoc = new DefaultStyledDocument();
		textArea.setDocument(myDoc);
		myDoc.addDocumentListener(this);		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		txt_number_off_characters = new JTextField();
				
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		
		this.setMinimumSize(new Dimension(400, 250));
		this.setPreferredSize(new Dimension(400, 250));
		
		add(txt_number_off_characters, BorderLayout.SOUTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
		
		pack();
		setVisible(true);

	}
	
	public void changedUpdate(DocumentEvent e) {
	}


	public void insertUpdate(DocumentEvent e) {		
		final Document doc = e.getDocument();
		txt_number_off_characters.setText("Textlength: " + String.valueOf(doc.getLength()));		
	}


	public void removeUpdate(DocumentEvent e) {
		Document doc = e.getDocument();
		txt_number_off_characters.setText("Textlength: " + String.valueOf(doc.getLength()));
	}

}
