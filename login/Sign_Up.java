package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Sign_Up extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_Up frame = new Sign_Up();
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
	public Sign_Up() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
		Statement st = conn.createStatement();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP PAGE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(145, 146, 170, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER YOUR NAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(26, 204, 170, 14);
		contentPane.add(lblNewLabel_1);
		
		
		textField = new JTextField();
		textField.setBounds(288, 203, 188, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("ENTER YOU EMAIL");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(26, 263, 178, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(288, 257, 188, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel a1 = new JLabel("");
		a1.setFont(new Font("Tahoma", Font.BOLD, 15));
		a1.setBounds(925, 250, 304, 14);
		JLabel a11 = new JLabel("");
		a11.setFont(new Font("Tahoma", Font.BOLD, 15));
		a11.setBounds(582, 263, 304, 14);
		contentPane.add(a1);
		contentPane.add(a11);
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField_1.getText();
				System.out.println(text);
				String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
				        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(text);
				if (matcher.matches())
				{
					a11.setText("");
				}
				else
				{
					a11.setText("ENTER A VALID EMAIL ADDRESS");
				}
				
				int flag = 1; 
				ResultSet s1;
				try {
					s1 = st.executeQuery("select email from user_details");
					while (s1.next())
					{
						String test =  s1.getString(1);
						if (test.equals(text))
						{
							flag = 0;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (flag == 0)
				{
					a1.setText("This Email Has already registered");
				}
				else
				{
					a1.setText("");
				}
			}
		});
				
		
		JLabel lblNewLabel_3 = new JLabel("MOBILE NUMBER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(34, 328, 149, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(288, 314, 188, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel a2 = new JLabel("");
		a2.setFont(new Font("Tahoma", Font.BOLD, 15));
		a2.setBounds(907, 320, 348, 14);
		contentPane.add(a2);
		JLabel a21 = new JLabel("");
		a21.setFont(new Font("Tahoma", Font.BOLD, 15));
		a21.setBounds(545, 320, 348, 14);
		contentPane.add(a21);
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField_2.getText();
				
				Pattern pattern = Pattern.compile("^\\d{10}$");
			    Matcher matcher = pattern.matcher(text);
                if (matcher.matches())
                {
                	a21.setText("");
                }
                else
                {
                	a21.setText("ENTER A VALID MOBILE NUMBER");
                }
                
                int flag = 1; 
				ResultSet s1;
				try {
					s1 = st.executeQuery("select mobile from user_details");
					while (s1.next())
					{
						String test =  s1.getString(1);
						if (test.equals(text))
						{
							flag = 0;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (flag == 0)
				{
					a2.setText("This Mobile Has already registered");
				}
				else
				{
					a2.setText("");
				}
			}
		});
				
		
		JLabel lblNewLabel_4 = new JLabel("ENTER USERNAME");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(34, 385, 170, 14);
		contentPane.add(lblNewLabel_4);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(288, 379, 188, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		JLabel a = new JLabel("");
		a.setBounds(582, 437, 335, 14);
		contentPane.add(a);
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField_3.getText();
				int flag = 1; 
				ResultSet s1;
				try {
					s1 = st.executeQuery("select username from user_details");
					while (s1.next())
					{
						String test =  s1.getString(1);
						if (test.equals(text))
						{
							flag = 0;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (flag == 1)
				{
					a.setText("username available");
				}
				else
				{
					a.setText("username Not available");
				}
				
				
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("ENTER PASSWORD");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(34, 446, 170, 14);
		contentPane.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(288, 431, 188, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_6 = new JLabel("RE-ENTER PASSWORD");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(33, 506, 185, 14);
		contentPane.add(lblNewLabel_6);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(288, 505, 188, 20);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String email = textField_1.getText();
				String mobile = textField_2.getText();
				String uname = textField_3.getText();
				String pwd = passwordField.getText();
				String pwd1 = passwordField_1.getText();
				if (name.length()==0 || email.length()==0 || mobile.length() == 0 || uname.length()==0 || pwd.length()==0 ||pwd1.length() == 0)
				{
					JOptionPane.showMessageDialog(btnNewButton, "Please Fill Out Missing Fields");
				}
				else
				{
					 if (pwd.equals(pwd1))
					 {
						String s = "Insert into user_details(name,email,mobile,username,password) values(?,?,?,?,?);";
						try {
							PreparedStatement ps = conn.prepareStatement(s);
							ps.setString(1, name);
							ps.setString(2, email);
							ps.setString(3, mobile);
							ps.setString(4, uname);
							ps.setString(5, pwd);
							ps.execute();
							JOptionPane.showMessageDialog(btnNewButton, "You Have SuccessFully Signed Up");
							setVisible(false);
							try {
								new Main().setVisible(true);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
							JOptionPane.showMessageDialog(btnNewButton, "Clear the Existing Erros");
						}
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(btnNewButton, "Confirm Password Doesnt Match");
					 }
					
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(545, 502, 117, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Already a user?? Back to Login");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(803, 118, 244, 25);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("LOGIN");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(1059, 119, 102, 23);
		contentPane.add(btnNewButton_1);
		
		textField.addActionListener(new ActionListener() {
			   @Override
			    public void actionPerformed(ActionEvent e) {
			      textField_1.requestFocusInWindow();    
			    }
			});	
		textField_1.addActionListener(new ActionListener() {
			   @Override
			    public void actionPerformed(ActionEvent e) {
			      textField_2.requestFocusInWindow();    
			    }
			});
		textField_2.addActionListener(new ActionListener() {
			   @Override
			    public void actionPerformed(ActionEvent e) {
			      textField_3.requestFocusInWindow();    
			    }
			});
		textField_3.addActionListener(new ActionListener() {
			   @Override
			    public void actionPerformed(ActionEvent e) {
			      passwordField.requestFocusInWindow();    
			    }
			});
		passwordField.addActionListener(new ActionListener() {
			   @Override
			    public void actionPerformed(ActionEvent e) {
			      passwordField_1.requestFocusInWindow();    
			    }
			});
		
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
		btnNewButton_4.setBounds(367, 44, 150, 50);
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
		btnNewButton_5.setBounds(562, 44, 165, 50);
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
		btnNewButton_6.setBounds(759, 44, 176, 50);
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
		btnNewButton_7.setBounds(979, 40, 182, 50);
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
	     Image img1 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
	     
		btnNewButton.setBackground(new Color(251, 234, 213));
		btnNewButton_1.setBackground(new Color(251, 234, 213));
		btnNewButton_4.setBackground(new Color(251, 234, 213));
		btnNewButton_5.setBackground(new Color(251, 234, 213));
		btnNewButton_6.setBackground(new Color(251, 234, 213));
		btnNewButton_7.setBackground(new Color(251, 234, 213));
	  
		
	}
}
