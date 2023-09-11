package login;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user.User_Page;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class Rating extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rating frame = new Rating();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Rating() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOW WOULD YOU RATE OUR SERVICE OUR OUR WEBSITE");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel.setBounds(88, 146, 881, 33);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1");
		rdbtnNewRadioButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		rdbtnNewRadioButton.setBounds(88, 213, 47, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("2");
		rdbtnNewRadioButton_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		rdbtnNewRadioButton_1.setBounds(151, 213, 40, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("3");
		rdbtnNewRadioButton_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		rdbtnNewRadioButton_2.setBounds(212, 213, 40, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("4");
		rdbtnNewRadioButton_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		rdbtnNewRadioButton_3.setBounds(270, 213, 47, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("5");
		rdbtnNewRadioButton_4.setFont(new Font("Monospaced", Font.BOLD, 20));
		rdbtnNewRadioButton_4.setBounds(347, 213, 47, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("(1 BEING THE LOWEST AND 5 BEING THE HIGHEST)");
		lblNewLabel_1.setBounds(495, 221, 317, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FEEDBACK");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel_2.setBounds(86, 316, 166, 23);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(88, 350, 761, 234);
		contentPane.add(textArea);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		G.add(rdbtnNewRadioButton_2);
		G.add(rdbtnNewRadioButton_3);
		G.add(rdbtnNewRadioButton_4);
		
		rdbtnNewRadioButton.setActionCommand("1");
		rdbtnNewRadioButton_1.setActionCommand("2");
		rdbtnNewRadioButton_2.setActionCommand("3");
		rdbtnNewRadioButton_3.setActionCommand("4");
		rdbtnNewRadioButton_4.setActionCommand("5");
		
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = User_Page.name;
				String rate= G.getSelection().getActionCommand();
				String feedback = textArea.getText();
				int rating = Integer.parseInt(rate);
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
					String s3 = "insert into ratings values(?,?,?);";
					PreparedStatement ps = conn.prepareStatement(s3);
					ps.setString(1, name);
					ps.setInt(2, rating);
					ps.setString(3,feedback);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton, "Thanks For Your Responce");
					textArea.setText("");
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 19));
		btnNewButton.setBounds(969, 447, 128, 33);
		contentPane.add(btnNewButton);
		
		
		 JLabel lblNewLabel_6 = new JLabel("New label");
	     Image img1 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_6.setIcon(new ImageIcon(newImage));
			lblNewLabel_6.setBounds(0, 0, 337, 118);
	     contentPane.add(lblNewLabel_6);
	     
	 	JButton btnNewButton_7 = new JButton("HOME");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					new User_Page(User_Page.name).setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Home.48.png"));
		btnNewButton_7.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnNewButton_7.setBackground(new Color(251, 234, 213));
		btnNewButton_7.setBounds(852, 31, 150, 50);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					new User_Page(User_Page.name).setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1038, 31, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		
	    
	}
}
