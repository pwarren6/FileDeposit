import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;


public class MainInt {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInt window = new MainInt();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainInt() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 869, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelMenu = new JPanel();
		frame.getContentPane().add(panelMenu, "name_559344991277119");
		panelMenu.setLayout(null);
		
		
		
		JButton SignIn = new JButton("Sign In");
		SignIn.setBounds(353, 278, 115, 29);
		panelMenu.add(SignIn);
		SignIn.addActionListener(this);
		textField = new JTextField();
		textField.setBounds(157, 167, 184, 29);
		panelMenu.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(498, 167, 184, 29);
		panelMenu.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(169, 142, 115, 20);
		panelMenu.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(500, 142, 69, 20);
		panelMenu.add(lblPassword);
		
		JPanel panelStuff = new JPanel();
		frame.getContentPane().add(panelStuff, "name_559348892174895");
		panelStuff.setLayout(null);
		
		table = new JTable();
		table.setBounds(90, 112, 1, 1);
		panelStuff.add(table);
		
		JButton btnFiles = new JButton("Files");
		btnFiles.setBackground(Color.WHITE);
		btnFiles.setBounds(0, 112, 138, 51);
		panelStuff.add(btnFiles);
		
		JButton btnNewButton = new JButton("Photos");
		btnNewButton.setBounds(0, 160, 138, 51);
		panelStuff.add(btnNewButton);
		
		JButton btnLinks = new JButton("Links");
		btnLinks.setBackground(Color.WHITE);
		btnLinks.setBounds(0, 257, 138, 51);
		panelStuff.add(btnLinks);
		
		JButton btnFileRequests = new JButton("File Requests");
		btnFileRequests.setBackground(Color.WHITE);
		btnFileRequests.setBounds(0, 308, 138, 51);
		panelStuff.add(btnFileRequests);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setBounds(395, 0, 115, 29);
		panelStuff.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Upload");
		btnNewButton_3.setBounds(506, 0, 115, 29);
		panelStuff.add(btnNewButton_3);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setBounds(732, 0, 115, 29);
		panelStuff.add(btnSettings);
		
		JButton btnNewFolder = new JButton("New Folder");
		btnNewFolder.setBounds(621, 0, 115, 29);
		panelStuff.add(btnNewFolder);
		
		JButton btnMovies = new JButton("Movies");
		btnMovies.setBounds(0, 209, 138, 50);
		panelStuff.add(btnMovies);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Test", "Test2", "Test3", "Test4", "Test5", "Test6"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBackground(Color.WHITE);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(681, 373, -440, -260);
		panelStuff.add(list);
		
		JPanel panelChicken = new JPanel();
		frame.getContentPane().add(panelChicken, "name_559352434091295");
	}
}
