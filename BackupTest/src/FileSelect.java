//CS 4850: Senior Project, Section 2
//Fall 2015
//Group 3: FileDeposit
//Members: Patrick Warren, Edward Calderon, Michael Bias, William Bennett, Constantino Spanoudakis
//File: FileSelect.java

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*import java.lang.Object;
import java.nio.file.Files;
import java.util.ArrayList;*/
public class FileSelect extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton open, backup;
	JTextArea log;
	JFileChooser fc;
	public FileSelect(){
		super(new BorderLayout());
		log = new JTextArea(5,20);
		log.setMargin(new Insets(5,5,250,250));
		log.setEditable(false);
		//Changes the font printed in the log scroll
		log.setFont(new Font("Serif", Font.BOLD, 14));
		JScrollPane logScroll = new JScrollPane(log);
		
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setMultiSelectionEnabled(true);
		open = new JButton("Browse...",
				createImageIcon("images/Open16.gif"));
		open.addActionListener(this);
		
		backup = new JButton("Backup Selected Files",
				createImageIcon("images/Backup.gif"));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(open);
		
		JPanel button2 = new JPanel();
		button2.add(backup);
		
		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScroll, BorderLayout.CENTER);
		add(button2, BorderLayout.PAGE_END);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == open){
			int returnVal = fc.showOpenDialog(FileSelect.this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File[] files = fc.getSelectedFiles();
				log.append("You have selected for backup: " + "\n");
				for(int i=0; i < files.length; i++){
					if(files[i].isFile()){
						log.append(files[i].getName() + "\n");
					}else if(files[i].isDirectory()){
						log.append(files[i].getName() + "\n");
					}
				}
			}
			log.setCaretPosition(log.getDocument().getLength());
		}
		if (e.getSource() == backup){
			
		}
	}
	protected static ImageIcon createImageIcon(String path){
		java.net.URL imgURL = FileChooserDemo.class.getResource(path);
		if (imgURL != null){
			return new ImageIcon(imgURL);
		}else{
			System.err.println("Could not locate file: " + path);
			return null;
		}
	}
	private static void createAndShowGUI(){
		JFrame frame = new JFrame("FileSelect");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new FileSelect());
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				UIManager.put("swing.boldMetal", Boolean.FALSE);
				createAndShowGUI();
			}
		});
	}
}

