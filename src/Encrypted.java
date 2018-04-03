import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Encrypted implements ActionListener {
	JFrame frame= new JFrame();
	JTextArea text = new JTextArea();
	JButton button1 = new JButton("Encrypt");
	JButton button2 = new JButton("Decrypt");
		
	public static void main(String[] args) {
		Encrypted encrypted = new Encrypted();
		encrypted.initiate();
	}
	void initiate() {
		frame.setLayout(null);
		frame.add(button1);
		frame.add(button2);
		frame.add(text);
		frame.setVisible(true);
		frame.setSize(500, 500);
		text.setBounds(100, 100, 300, 300);
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		button1.setBounds(100, 50, 100, 30);
		button2.setBounds(300, 50, 100, 30);
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
String encrypt(String toEncrypt) {
	String encryptedForm="";
	for (int i = 0; i < toEncrypt.length(); i++) {
		encryptedForm=encryptedForm+(char)(158-(toEncrypt.charAt(i)));
	}
	System.out.println(encryptedForm);
	try {
		FileWriter fw = new FileWriter("encrypted_text.txt");
		
		fw.write(encryptedForm);
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return encryptedForm;
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==button1) {	
		encrypt(text.getText());
	}
	if(e.getSource()==button2) {	
		JFileChooser fileExplorer = new JFileChooser();
		fileExplorer.showOpenDialog(null);
		File file = fileExplorer.getSelectedFile();
		try {
			FileReader fr = new FileReader(file);
			int c = fr.read();
			String decrypted="";
			while(c != -1){
				System.out.print((char)c);
				decrypted=decrypted+(char)(158-(c));
				c = fr.read();			
			}
			text.setText(decrypted);
			fr.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
}
