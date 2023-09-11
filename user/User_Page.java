package user;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import login.Contact_us;
import login.About;

import login.Gallery;
import login.Rating;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class User_Page extends JFrame {

	private JPanel contentPane;
	public static String name;
	public static Stack<String> queue = new Stack<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Page frame = new User_Page(name);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public User_Page(String name) throws ClassNotFoundException, SQLException {
		queue.add("User_Page()");
		this.name=name;
//		System.out.println(name);/
		int temp = 0;
		if (name==null)
		{
			JOptionPane.showMessageDialog(contentPane, "Please Login To Continue");
			setVisible(false);
			temp=1;
			new login.Main().setVisible(true);
			
		}
		if (temp == 0)
		{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1292, 704);
		Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\monisha.dr\\Downloads\\Untitled design (1).png");
		contentPane = (new JPanel() {
	         @Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0,1300,950, this);
	            //g.fillRect(20, 20, 500, 300);
	         }
	      });
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setExtendedState(MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(195, 136, 250, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setText("WELCOME "+name+"!");
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("What is your plan for today?");
		lblNewLabel_1.setBounds(195, 186, 320, 24);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel_1);
		Image img1 = new ImageIcon(this.getClass().getResource("/bookevent.jpg")).getImage(); //just drag and drop from computer
		Image newImage = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		Image img11 = new ImageIcon(this.getClass().getResource("/viewprofile.jpg")).getImage(); //just drag and drop from computer
		Image newImage1 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		
		JButton btnNewButton = new JButton("BOOK AN EVENT");
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Book_Event().setVisible(true);
			}
		});
		btnNewButton.setBounds(187, 227, 256, 96);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VIEW /UPDATE PROFILE");
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     setVisible(false);
			     new Profile().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(195, 424, 250, 105);
		contentPane.add(btnNewButton_1);
	     Image img111 = new ImageIcon(this.getClass().getResource("/logo1.png")).getImage();
			Image newImage11 = img111.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
	     
	 	
			JButton btnNewButton_6 = new JButton("GALLERY");
			btnNewButton_6.setFont(new Font("Monospaced", Font.BOLD, 16));
			btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Vcferreira-Firefox-Os-Gallery.48.png"));
			btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new Gallery().setVisible(true);
				}
			});
			btnNewButton_6.setBounds(697, 15, 176, 50);
			contentPane.add(btnNewButton_6);
			
			JButton btnNewButton_7 = new JButton("CONTACT US");
			btnNewButton_7.setFont(new Font("Monospaced", Font.BOLD, 16));
			btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Email-2.48.png"));
			btnNewButton_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					try {
						new Contact_us().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_7.setBounds(883, 15, 182, 50);
			contentPane.add(btnNewButton_7);
		     
		     JLabel lblNewLabel_31 = new JLabel("LOCATION");
		     lblNewLabel_31.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Github-Octicons-Location-16.48.png"));
		     lblNewLabel_31.setFont(new Font("Monospaced", Font.BOLD, 18));
		     lblNewLabel_31.setBounds(38, 585, 150, 50);
		     contentPane.add(lblNewLabel_31);
		     
		     JTextArea txtrNagalkeniRamanujam = new JTextArea();
		     txtrNagalkeniRamanujam.setFont(new Font("Monospaced", Font.BOLD, 16));
		     txtrNagalkeniRamanujam.setEditable(false);
		     txtrNagalkeniRamanujam.setWrapStyleWord(true);
		     txtrNagalkeniRamanujam.setLineWrap(true);
		     txtrNagalkeniRamanujam.setText("Nagalkeni, 98, Ramanujam St,\r\nPeriyar Nagar, Pallavaram, Chennai,\r\nTamil Nadu 600044");
		     txtrNagalkeniRamanujam.setBounds(209, 569, 340, 81);
		     contentPane.add(txtrNagalkeniRamanujam);
		     txtrNagalkeniRamanujam.setOpaque(false);
		     txtrNagalkeniRamanujam.setBackground(new Color(0, 0, 0,0));
		     
		     JLabel lblNewLabel_41 = new JLabel("EMAIL");
		     lblNewLabel_41.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Rafiqul-Hassan-Blogger-Email-3.48.png"));
		     lblNewLabel_41.setFont(new Font("Monospaced", Font.BOLD, 18));
		     lblNewLabel_41.setBounds(596, 590, 118, 41);
		     contentPane.add(lblNewLabel_41);
		     
		     JTextField txtAbcgmailcom = new JTextField();
		     txtAbcgmailcom.setFont(new Font("Tahoma", Font.BOLD, 16));
		     txtAbcgmailcom.setEditable(false);
		     txtAbcgmailcom.setText("abc@gmail.com");
		     txtAbcgmailcom.setBounds(734, 591, 160, 41);
		     contentPane.add(txtAbcgmailcom);
		     txtAbcgmailcom.setColumns(10);
		     txtAbcgmailcom.setOpaque(false);
		     txtAbcgmailcom.setBackground(new Color(0,0,0,0));
		     
		     JLabel lblNewLabel_51 = new JLabel("PHONE");
		     lblNewLabel_51.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Iconsmind-Outline-Telephone.48.png"));
		     lblNewLabel_51.setFont(new Font("Monospaced", Font.BOLD, 18));
		     lblNewLabel_51.setBounds(997, 585, 109, 50);
		     contentPane.add(lblNewLabel_51);
		     
		     
		     JTextField textField_11 = new JTextField();
		     textField_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		     textField_11.setEditable(false);
		     textField_11.setText("9962141580");
		     textField_11.setBounds(1116, 592, 109, 38);
		     contentPane.add(textField_11);
		     textField_11.setColumns(10);
		     textField_11.setOpaque(false);
		     textField_11.setBackground(new Color(0,0,0,0));
		     
		     JLabel lblNewLabel_61 = new JLabel("New label");
		     Image img1111 = new ImageIcon(this.getClass().getResource("/logo1.png")).getImage();
				Image newImage111 = img1111.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
				lblNewLabel_61.setIcon(new ImageIcon(newImage111));
				lblNewLabel_61.setBounds(-20, -14, 357, 113);
		     contentPane.add(lblNewLabel_61);
			
			JButton btnNewButton_4 = new JButton("HOME");
			btnNewButton_4.setFont(new Font("Monospaced", Font.BOLD, 17));
			btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Home.48.png"));
			btnNewButton_4.setBackground(new Color(251, 234, 213));
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnNewButton_4.setBounds(347, 15, 150, 50);
			contentPane.add(btnNewButton_4);
			
			JButton btnNewButton_5 = new JButton("ABOUT US");
			btnNewButton_5.setFont(new Font("Monospaced", Font.BOLD, 16));
			btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Oxygen-Icons.org-Oxygen-Actions-help-about.48.png"));
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					try {
						new About().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_5.setBounds(521, 15, 165, 50);
			contentPane.add(btnNewButton_5);
			
//			btnNewButton.setBackground(new Color(251, 234, 213));
//			btnNewButton_1.setBackground(new Color(251, 234, 213));
			btnNewButton_5.setBackground(new Color(251, 234, 213));
			btnNewButton_6.setBackground(new Color(251, 234, 213));
			btnNewButton_7.setBackground(new Color(251, 234, 213));
			
			JButton btnNewButton_7_1 = new JButton("LOGOUT");
			btnNewButton_7_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(btnNewButton, "Thank you for choosing Signature Soire`es!");
					dispose();
					
				}
			});
			btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
			btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
			btnNewButton_7_1.setBackground(new Color(251, 234, 213));
			btnNewButton_7_1.setBounds(1075, 15, 182, 50);
			contentPane.add(btnNewButton_7_1);
			
			JButton btnNewButton_2 = new JButton("<html>PROVIDE US WITH <br> YOUR VALUABLE FEEDBACK </html>");
			btnNewButton_2.setFont(new Font("Monospaced", Font.BOLD, 20));
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					try {
						new Rating().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_2.setBounds(646, 296, 279, 105);
			contentPane.add(btnNewButton_2);
	}
} }
