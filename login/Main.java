package login;
import user.*;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.Adminlogin;
import employee.Employee_Page;
import mail_sms.sendMailep;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JCheckBox;




public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtAbcgmailcom;
	private JTextField textField_1;
	public static String username;
	public static String email;
	public static JButton btnNewButton_9;
	public static JLabel lblNewLabel_8;
	public static String phoneno;

	/**
	 * Launch the application.
	 */
	private AlphaComposite makeComposite(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}
	
	public static void main(String[] args) throws Exception {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
         
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */

	
	public Main() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
		Statement st = conn.createStatement();
		 setExtendedState(MAXIMIZED_BOTH);
		Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\monisha.dr\\Downloads\\Untitled design (1).png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 728);
		contentPane = (new JPanel() {
	         @Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img, 0, 0,1300,950, this);
	            //g.fillRect(20, 20, 500, 300);
	         }
	      });
		 setExtendedState(MAXIMIZED_BOTH);
		//contentPane = new JPanel();
		//contentPane.setBackground(new Color(0,0,0,225));
//		pack();
//	    setVisible(true);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO SIGNATURE SOIRE`ES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(486, 176, 456, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(576, 372, 65, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(571, 428, 70, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		
		textField = new JTextField();
		textField.setBounds(559, 397, 96, 20);
		contentPane.add(textField);
		textField.setVisible(false);
		textField.setColumns(10);
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(559, 453, 96, 23);
		contentPane.add(passwordField_1);
		passwordField_1.setVisible(false);
		
		JButton btnNewButton_3 = new JButton("SUBMIT");
		btnNewButton_3.setFont(new Font("Monospaced", Font.BOLD, 15));
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Iconoir-Team-Iconoir-Submit-document.48.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = textField.getText();
				String pwd = passwordField_1.getText();
				int flag = 0;
				ResultSet s1;
				try {
					s1 = st.executeQuery("select name,username,password,email,mobile from user_details");
					String name = "";
					while (s1.next())
					{
						if (s1.getString(2).equals(uname) && s1.getString(3).equals(pwd))
						{
							flag = 1;
							name = s1.getString(1);
							username = uname;
							email = s1.getString(4);
							phoneno = s1.getString(5);
						}
					}
					if (flag == 1)
					{
						JOptionPane.showMessageDialog(btnNewButton_3, "LOGIN SUCCESSFULL");
						
						setVisible(false);
						new User_Page(name).setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton_3, "INVALID USERNAME OR PASSWORD");
					}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(724, 397, 192, 50);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.setVisible(false);
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Oxygen-Icons.org-Oxygen-Apps-preferences-system-login.48.png"));
		btnNewButton.setBounds(83, 146, 150, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setVisible(true);
				lblNewLabel_2.setVisible(true);
				textField.setVisible(true);
				passwordField_1.setVisible(true);
				btnNewButton_3.setVisible(true);
				btnNewButton_9.setVisible(true);
				lblNewLabel_8.setVisible(true);
				
			
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGNUP");
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Custom-Icon-Design-Flatastic-3-Signup.48.png"));
		btnNewButton_1.setBounds(83, 239, 179, 50);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					new Sign_Up().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADMIN LOGIN");
		btnNewButton_2.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Alecive-Flatwoken-Apps-Computer-Login.48.png"));
		btnNewButton_2.setBounds(83, 345, 192, 41);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Adminlogin().setVisible(true);
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("HOME");
		btnNewButton_4.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Home.48.png"));
		btnNewButton_4.setBackground(new Color(251, 234, 213));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(347, 44, 150, 50);
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
		btnNewButton_5.setBounds(522, 44, 165, 50);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("GALLERY");
		btnNewButton_6.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Vcferreira-Firefox-Os-Gallery.48.png"));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Gallery().setVisible(true);
			}
		});
		btnNewButton_6.setBounds(697, 44, 176, 50);
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
		btnNewButton_7.setBounds(883, 44, 182, 50);
		contentPane.add(btnNewButton_7);
		
		JTextArea txtrSearchingForAn = new JTextArea();
		txtrSearchingForAn.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtrSearchingForAn.setBackground(new Color(255, 254, 247));
		txtrSearchingForAn.setEditable(false);
		txtrSearchingForAn.setText("We work closely with you to make your vision a reality and to ensure your ideas are delivered exactly as you'd imagined.\r\n");
		txtrSearchingForAn.setBounds(386, 247, 700, 92);
		contentPane.add(txtrSearchingForAn); 
		 txtrSearchingForAn.setLineWrap(true);
	     txtrSearchingForAn.setWrapStyleWord(true);
	     txtrSearchingForAn.setOpaque(false);
	     txtrSearchingForAn.setBackground(new Color(0, 0, 0,0));
	     
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
	     
	     txtAbcgmailcom = new JTextField();
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
	     
	     
	     textField_1 = new JTextField();
	     textField_1.setFont(new Font("Tahoma", Font.BOLD, 16));
	     textField_1.setEditable(false);
	     textField_1.setText("9962141580");
	     textField_1.setBounds(1116, 592, 109, 38);
	     contentPane.add(textField_1);
	     textField_1.setColumns(10);
	     textField_1.setOpaque(false);
	     textField_1.setBackground(new Color(0,0,0,0));
	     
	     JLabel lblNewLabel_6 = new JLabel("New label");
	     Image img1 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_6.setIcon(new ImageIcon(newImage));
			lblNewLabel_6.setBounds(0, 0, 337, 118);
	     contentPane.add(lblNewLabel_6);
	     
		btnNewButton.setBackground(new Color(251, 234, 213));
		btnNewButton_1.setBackground(new Color(251, 234, 213));
		btnNewButton_2.setBackground(new Color(251, 234, 213));
		btnNewButton_3.setBackground(new Color(251, 234, 213));
		btnNewButton_4.setBackground(new Color(251, 234, 213));
		btnNewButton_5.setBackground(new Color(251, 234, 213));
		btnNewButton_6.setBackground(new Color(251, 234, 213));
		btnNewButton_7.setBackground(new Color(251, 234, 213));
	   
	     
	     JButton btnNewButton_8 = new JButton("EMPLOYEE LOGIN");
	     btnNewButton_8.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		setVisible(false);
	     		try {
					new Employee_Page().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	     	}
	     });
	     btnNewButton_8.setFont(new Font("Monospaced", Font.BOLD, 15));
	     btnNewButton_8.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Hopstarter-Sleek-Xp-Basic-Preppy.48.png"));
	     btnNewButton_8.setBounds(82, 437, 232, 50);
	     contentPane.add(btnNewButton_8);
	     
	     btnNewButton_8.setBackground(new Color(251, 234, 213));
	     
	     btnNewButton_9 =new JButton("Forgot password?? Click Here");
	     btnNewButton_9.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		
	     		String mailp = JOptionPane.showInputDialog(btnNewButton_9,"Enter Your Register Mail Id");
	     		JOptionPane.showMessageDialog(btnNewButton_9,"You Would Receive new password in your registerd mail id" );
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
	    	        try {
						sendMailep.sendMail(mailp,captcha);
						String s4 = "update user_details set password = ? where email = ?";
						PreparedStatement ps = conn.prepareStatement(s4);
						ps.setString(1, captcha);
						ps.setString(2, mailp);
						ps.executeUpdate();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
	    	        
	    	        
	    	     
	     
	     	}
	     });
	     btnNewButton_9.setBounds(506, 487, 226, 23);
	     btnNewButton_9.setOpaque(false);
	     btnNewButton_9.setContentAreaFilled(false);
	     btnNewButton_9.setBorderPainted(false);
	     btnNewButton_9.setVisible(false);
	     contentPane.add(btnNewButton_9);
	     
	     lblNewLabel_8 = new JLabel("");
	     lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Aniket-Suvarna-Box-Regular-Bx-show.48 (1).png"));

	        lblNewLabel_8.addMouseListener(new MouseAdapter() {

	            @Override

	            public void mousePressed(MouseEvent e) {

	                passwordField_1.setEchoChar((char)0);

	            }

	            @Override

	            public void mouseReleased(MouseEvent e) {

	                passwordField_1.setEchoChar('*');

	            }

	        });

	        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);

	        lblNewLabel_8.setBounds(653, 453, 67, 23);

	        contentPane.add(lblNewLabel_8);
	        lblNewLabel_8.setVisible(false);
	  
	     
	    
	    
		
		
	}
}
