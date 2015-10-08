import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FolderSelect extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton open, save;
	JTextArea log;
	JFileChooser fc;
	public FolderSelect(){
		super(new BorderLayout());
		log = new JTextArea(5,20);
		log.setMargin(new Insets(5,5,5,5));
		log.setEditable(false);
		JScrollPane logScroll = new JScrollPane(log);
		
		fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
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
			int returnVal = fc.showOpenDialog(FolderSelect.this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File file = fc.getSelectedFile();
				log.append("You have selected: " + file.getName() + "." + "\n");
			}else{
				log.append("Selection cancelled." + "\n");
			}
			log.setCaretPosition(log.getDocument().getLength());
		}
		if (e.getSource() == save){
			int returnVal = fc.showSaveDialog(FolderSelect.this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File file = fc.getSelectedFile();
				log.append("You are now saving: " + file.getName() + "." + "\n");
			}else{
				log.append("Save command cancelled." + "\n");
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
		JFrame frame = new JFrame("FolderSelect");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new FolderSelect());
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
