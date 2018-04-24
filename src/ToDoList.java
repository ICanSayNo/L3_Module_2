import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ToDoList implements ActionListener {
	JFrame frame= new JFrame();
	JButton button1 = new JButton("Add Item");
	JButton button2 = new JButton("Remove Item");
	JButton button3 = new JButton("Save List");
	JButton button4 = new JButton("Load List");
	ArrayList<String> items = new ArrayList<String>();
	String output="";
	
	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();
		toDoList.initiate();
	}
	void initiate() {
		frame.setLayout(null);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.setVisible(true);
		frame.setSize(500, 500);
		button1.setBounds(100, 50, 150, 30);
		button2.setBounds(300, 50, 150, 30);
		button3.setBounds(100, 150, 150, 30);
		button4.setBounds(300, 150, 150, 30);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	List<String> getLines(File f){
		List<String> l = new ArrayList<String>();
		return l;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {	
			String newItem = JOptionPane.showInputDialog("Add item");
			items.add(newItem);
			output="";
			for(String name:items) {
				output+=(items.indexOf(name)+1);
				output+=(". "+name);
				output+="\n";
			}
			JOptionPane.showMessageDialog(null, output, "TO DO", 3);
		}
		if(e.getSource()==button2) {	
			String item = JOptionPane.showInputDialog(null, (output + "\n \n \n Which item you like to remove? \n Type the number"), "TO DO", 3);
			int i = Integer.parseInt(item);
			if(i>=items.size()||i<=0) {
			}
			else {
				items.remove(i-1);
			}
		}
		if(e.getSource()==button3) {	
			FileWriter fw;
			try {
				fw = new FileWriter(JOptionPane.showInputDialog("Name your file")+".txt");
				output="";
			for(String name:items) {
				output+=(name);
				output+="\n";
					
			}
			fw.write(output);
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==button4) {
			JFileChooser fileExplorer = new JFileChooser();
			fileExplorer.showOpenDialog(null);
			File file = fileExplorer.getSelectedFile();
		}
	}
}

