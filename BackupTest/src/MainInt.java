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



public class MainInt {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		panelStuff.setBackground(Color.WHITE);
		frame.getContentPane().add(panelStuff, "name_559348892174895");
		panelStuff.setLayout(null);
		SignIn.addActionListener(new ActionListener(){
			@Override
		
		public void actionPerformed(ActionEvent arg0){
				panelMenu.setVisible(false);
				panelStuff.setVisible(true);
				//System.exit(0);
			}
		}
	);
		
		JPanel panelChicken = new JPanel();
		frame.getContentPane().add(panelChicken, "name_559352434091295");
	}
}
