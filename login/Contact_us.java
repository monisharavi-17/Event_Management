package login;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Contact_us extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtCaptha;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact_us frame = new Contact_us();
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
	public Contact_us() throws SQLException, ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 728);
		Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\monisha.dr\\Downloads\\Untitled design (1).png");
		contentPane = (new JPanel() {
	         @Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0,1300,950, this);
	            //g.fillRect(20, 20, 500, 300);
	         }
	      });
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
		Statement st = conn.createStatement();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setExtendedState(MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(106, 153, 360, 59);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setToolTipText("");
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(576, 153, 337, 59);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(106, 242, 807, 38);
		contentPane.add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 318, 807, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(106, 387, 807, 162);
		contentPane.add(textArea_1);
		
		txtCaptha = new JTextField();
		txtCaptha.setFont(new Font("Tahoma", Font.BOLD, 17));
		txtCaptha.setBounds(976, 345, 130, 47);
		contentPane.add(txtCaptha);
		txtCaptha.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(976, 433, 130, 47);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("CONTACT US");
		lblNewLabel.setBounds(454, 76, 185, 41);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBounds(106, 128, 90, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PHONE");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(576, 128, 90, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("EMAIL");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(106, 217, 90, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("SUBJECT");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(106, 293, 90, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("MESSAGE");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(106, 362, 90, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JButton btnNewButton_1 = new JButton("GENERATE CAPTCHA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Random rand = new Random(62);
                 
     	        // Characters to be included
     	        String chrs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
     	      
     	        // Generate n characters from above set and
     	        // add these characters to captcha.
     	        String captcha = "";
     	        for (int i = 0; i < 6; i++){
     	            int index = (int)(Math.random()*62);
     	            captcha+=chrs.charAt(index);
     	        }
     	           
     	       txtCaptha.setText(captcha);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(976, 256, 216, 51);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER CAPTCHA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(976, 403, 130, 14);
		contentPane.add(lblNewLabel_2);
		
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
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7.setBounds(883, 15, 182, 50);
		contentPane.add(btnNewButton_7);
	     
	     JLabel lblNewLabel_3 = new JLabel("LOCATION");
	     lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Github-Octicons-Location-16.48.png"));
	     lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 18));
	     lblNewLabel_3.setBounds(38, 585, 150, 50);
	     contentPane.add(lblNewLabel_3);
	     
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
	     
	     JLabel lblNewLabel_4 = new JLabel("EMAIL");
	     lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Rafiqul-Hassan-Blogger-Email-3.48.png"));
	     lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 18));
	     lblNewLabel_4.setBounds(596, 590, 118, 41);
	     contentPane.add(lblNewLabel_4);
	     
	     JTextField txtAbcgmailcom = new JTextField();
	     txtAbcgmailcom.setFont(new Font("Tahoma", Font.BOLD, 16));
	     txtAbcgmailcom.setEditable(false);
	     txtAbcgmailcom.setText("abc@gmail.com");
	     txtAbcgmailcom.setBounds(734, 591, 160, 41);
	     contentPane.add(txtAbcgmailcom);
	     txtAbcgmailcom.setColumns(10);
	     txtAbcgmailcom.setOpaque(false);
	     txtAbcgmailcom.setBackground(new Color(0,0,0,0));
	     
	     JLabel lblNewLabel_5 = new JLabel("PHONE");
	     lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Iconsmind-Outline-Telephone.48.png"));
	     lblNewLabel_5.setFont(new Font("Monospaced", Font.BOLD, 18));
	     lblNewLabel_5.setBounds(997, 585, 109, 50);
	     contentPane.add(lblNewLabel_5);
	     
	     
	     JTextField textField_11 = new JTextField();
	     textField_11.setFont(new Font("Tahoma", Font.BOLD, 16));
	     textField_11.setEditable(false);
	     textField_11.setText("9962141580");
	     textField_11.setBounds(1116, 592, 109, 38);
	     contentPane.add(textField_11);
	     textField_11.setColumns(10);
	     textField_11.setOpaque(false);
	     textField_11.setBackground(new Color(0,0,0,0));
	     
	     JLabel lblNewLabel_6 = new JLabel("New label");
	     Image img1 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_6.setIcon(new ImageIcon(newImage));
			lblNewLabel_6.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_6);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(106, 313, 807, 38);
		contentPane.add(textArea_2);
		
		JButton btnNewButton_4 = new JButton("HOME");
		btnNewButton_4.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Home.48.png"));
		btnNewButton_4.setBackground(new Color(251, 234, 213));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					new Main().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		btnNewButton_1.setBackground(new Color(251, 234, 213));
		btnNewButton_5.setBackground(new Color(251, 234, 213));
		btnNewButton_6.setBackground(new Color(251, 234, 213));
		btnNewButton_7.setBackground(new Color(251, 234, 213));
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = txtName.getText();
				String phone = textField.getText();
				String email = textArea.getText();
				String subject = textField_1.getText();
				String message = textArea_1.getText();
				
				String capt = txtCaptha.getText();
				String capt1 = textField_3.getText();
				
				if (capt1.equals(capt))
				{
					try {
						String s2 = "insert into offline values (?,?,?,?,?)";
						PreparedStatement ps = conn.prepareStatement(s2);
						ps.setString(1, name);
						ps.setString(2, phone);
						ps.setString(3, email);
						ps.setString(4, subject);
						ps.setString(5, message);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(btnNewButton, "Your Message/Request to Us has been Received Successfully! You will be contacted by our Event Manager Soon!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Captcha Incorrect");
				}
			}
		});
		btnNewButton.setBounds(976, 506, 185, 47);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
		
		btnNewButton.setBackground(new Color(251, 234, 213));
	}
}
