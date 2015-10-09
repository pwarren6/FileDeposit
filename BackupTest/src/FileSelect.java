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
	JButton open, save;
	JTextArea log;
	JFileChooser fc;
	public FileSelect(){
		super(new BorderLayout());
		log = new JTextArea(5,20);
		log.setMargin(new Insets(5,5,5,5));
		log.setEditable(false);
		JScrollPane logScroll = new JScrollPane(log);
		
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setMultiSelectionEnabled(true);
		open = new JButton("Open...",
				createImageIcon("images/Open16.gif"));
		open.addActionListener(this);
		
		save = new JButton("Save...",
				createImageIcon("images/Save16.gif"));
		save.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(open);
		buttonPanel.add(save);
		
		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScroll, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == open){
			int returnVal = fc.showOpenDialog(FileSelect.this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File[] files = fc.getSelectedFiles();
				log.append("You have selected for backup: " + files.length + " file(s)." + "\n");
			}
			log.setCaretPosition(log.getDocument().getLength());
		}
		if (e.getSource() == save){
			int returnVal = fc.showSaveDialog(FileSelect.this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File[] files = fc.getSelectedFiles();
				log.append("You are now saving: " + files.hashCode() + "." + "\n");
			}
			log.setCaretPosition(log.getDocument().getLength());
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

