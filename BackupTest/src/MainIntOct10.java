import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JDialog;

import java.awt.Dimension;
import java.awt.Dialog;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.List;
import javax.swing.JMenu;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JCheckBoxMenuItem;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import javax.swing.JLayeredPane;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;



public class MainInt {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
        private final String authFile = "authFile.txt";

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
		
	
	
		textField = new JTextField();
		textField.setBounds(157, 167, 184, 29);
		panelMenu.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(498, 167, 184, 29);
		panelMenu.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(169, 142, 115, 20);
		panelMenu.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(500, 142, 69, 20);
		panelMenu.add(lblPassword);
		
		JPanel panelStuff = new JPanel();
		panelStuff.setBackground(new Color(102, 153, 255));
		frame.getContentPane().add(panelStuff, "name_559348892174895");
		
		Button Upload = new Button("Upload");
		Upload.setBounds(719, 33, 64, 27);
		Upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelStuff.setLayout(null);
		panelStuff.add(Upload);
		
		Button NewFolder = new Button("New Folder");
		NewFolder.setBounds(628, 33, 94, 27);
		panelStuff.add(NewFolder);
		
		Button Settings = new Button("Settings");
		Settings.setBounds(776, 33, 71, 27);
		panelStuff.add(Settings);
		
		Button Home = new Button("Home");
		Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Home.setBounds(573, 33, 56, 27);
		panelStuff.add(Home);
		SignIn.addActionListener(new ActionListener(){
			@Override
		
		public void actionPerformed(ActionEvent arg0){
                                if (!textField.getText().isEmpty() && passwordField.getPassword() != null)
                                {
                                    if(authenticate(textField.getText(), String.copyValueOf(passwordField.getPassword()))){
                                    panelMenu.setVisible(false);
                                    panelStuff.setVisible(true);
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(frame, "Invalid Credentials",
                                                "Log-In Failed", JOptionPane.ERROR_MESSAGE);
                                    }
				//System.exit(0);
                                }
			}
		}
	);
		
		JPanel panelSettings = new JPanel();
		frame.getContentPane().add(panelSettings, "name_559352434091295");
		panelSettings.setLayout(null);
		
		JButton Schedule = new JButton("Schedule");
		Schedule.setBounds(43, 39, 115, 29);
		panelSettings.add(Schedule);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(164, 39, 602, 365);
		panelSettings.add(panel_1);
		panel_1.setLayout(null);
		
		TextField textField_2 = new TextField();
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(111, 30, 351, 42);
		panel_1.add(textField_2);
		
		Settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStuff.setVisible(false);
				panelSettings.setVisible(true);
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
        
        /*
        Attempts to authenticate an inputted username and password against information in
        an external file with user info.
        */
        private boolean authenticate(String username, String password){
            if(username.isEmpty() && password.isEmpty()){
                System.out.println("Error: Non-null username and password expected.");
            }
            Boolean login = false;
            
            try {
            BufferedReader readFile = new BufferedReader(new FileReader(authFile));
            //This algorithm will be replaced once we figure out how the user/password file is created
            String userInfo = username + password;
            String line = readFile.readLine();
            while (line != null) {
                if (line.equals(userInfo)) {
                    login = true;
                    break;
                }
                line = readFile.readLine();
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            return login;
        }
}
