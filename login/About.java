package login;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class About extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() throws ClassNotFoundException, SQLException {
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setExtendedState(MAXIMIZED_BOTH);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABOUT US");
		lblNewLabel.setBounds(223, 131, 100, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JTextArea txtrLookingForThe = new JTextArea();
		txtrLookingForThe.setBackground(new Color(252, 239, 207));
		txtrLookingForThe.setBounds(25, 162, 533, 469);
		txtrLookingForThe.setEditable(false);
		txtrLookingForThe.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrLookingForThe.setWrapStyleWord(true);
		txtrLookingForThe.setLineWrap(true);
		//txtrLookingForThe.setText("Looking for the Wedding Event Planners in Chennai? Well, we are the one stop solution for Event Planners in Chennai, Wedding Event Organisers in Chennai and Wedding Planners in Chennai. Snowdrop is the leading Event Planners in Pallavaram, Chromepet, Tambaram in Chennai, specialising in corporate and social events with the experience of over 14 years.\r\n\r\nAs an experienced Event management company, we are functioning as the famous event planners for the following areas.\r\n\r\nTraditional wedding                                                             NRI wedding\r\nTheme based wedding                                                        Engagement\r\nBaby shower                                                                        Birthday events\r\nTheme-based Birthday setup                                               Corporate events\r\nAnnual day celebration and other school events                 Product launch and inauguration functions\r\nStaff appreciation and Retirement events                            Social and religious festival events.\r\n\r\nWe decorate and organize the event in an attractive manner that will receive appreciation from the guests for sure.");
		txtrLookingForThe.append("Looking for the Wedding Event Planners in Chennai? Well, we are the one stop solution for Event Planners in Chennai, Wedding Event Organisers in Chennai and Wedding Planners in Chennai. Snowdrop is the leading Event Planners in Pallavaram, Chromepet, Tambaram in Chennai, specialising in corporate and social events with the experience of over 14 years.\r\n"
				+ "");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("As an experienced Event management company, we are functioning as the famous event planners for the following areas.\r\n"
				+ "");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("Traditional wedding                  NRI wedding"
				+ "");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("Theme based wedding                  Engagement");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("Baby shower                          Birthday events");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("\n");
		txtrLookingForThe.append("We decorate and organize the event in an attractive manner that will receive appreciation from the guests for sure.");
		
		
		
		//contentPane.add(txtrLookingForThe);
//		txtrLookingForThe.setOpaque(false);
		
		
		JScrollPane sp1 = new JScrollPane();
		sp1.setSize(533, 402);
		sp1.setLocation(25, 162);
		sp1.setViewportView(txtrLookingForThe);
		contentPane.add(sp1);
		sp1.setOpaque(false);
		
//		JScrollPane scrollPane = new JScrollPane(txtriRecentlyDined);
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.setBounds(73, 491, 731, 172);
//		contentPane.add(scrollPane);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("OUR CUSTOMER'S FEEDBACKS");
		lblNewLabel_1.setBounds(841, 131, 289, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtriRecentlyDined = new JTextArea();
		txtriRecentlyDined.setBackground(new Color(252, 239, 207));
		txtriRecentlyDined.setBounds(5, 500, 1254, 312);
		txtriRecentlyDined.setEditable(false);
		txtriRecentlyDined.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtriRecentlyDined.setWrapStyleWord(true);
		txtriRecentlyDined.setLineWrap(true);
		//txtriRecentlyDined.setText("“I recently dined at [RestaurantName] and was thoroughly impressed by both the exquisite cuisine and the impeccable service. The menu showcased a variety of innovative dishes, blending bold flavors and beautiful presentation. The attentive and knowledgeable staff ensured that our meal was a memorable one, providing excellent recommendations and ensuring our satisfaction. I can’t recommend [RestaurantName] enough for a fantastic dining experience.”\r\n\r\nThe staff was great. The receptionists were very helpful and answered all our questions. The room was clean and bright, and the room service was always on time. Will be coming back! Thank you so much.”\r\n\r\nI recently had the pleasure of staying at [HotelName], and it was an unforgettable experience. From the moment I arrived, the staff went above and beyond to ensure my comfort and satisfaction. The luxurious accommodations, coupled with exceptional service, made my stay truly memorable. The hotel’s prime location made exploring the city a breeze, and I can’t wait to return to [HotelName] on my next visit. Highly recommended!”");
		//contentPane.add(txtriRecentlyDined);
		
		//.............GET FROM database
		Class.forName("com.mysql.jdbc.Driver");
		Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
		String s3 = "select * from ratings;";
		
		PreparedStatement ps = c1.prepareStatement(s3);
		ResultSet rs = ps.executeQuery(s3);
		while(rs.next())
		{
            
			txtriRecentlyDined.append(rs.getString(1) +" Gives ");
			txtriRecentlyDined.append("\n");
			txtriRecentlyDined.append(rs.getString(2)+" Star Rating ");
			txtriRecentlyDined.append("\n");
			txtriRecentlyDined.append(rs.getString(3));
			txtriRecentlyDined.append("\n");
			txtriRecentlyDined.append("*************************************************");
			txtriRecentlyDined.append("\n");
			txtriRecentlyDined.setFont(txtriRecentlyDined.getFont().deriveFont(Font.BOLD, txtriRecentlyDined.getFont().getSize()));

			
		}
		
		JScrollPane sp = new JScrollPane(txtriRecentlyDined);
		sp.setSize(533, 394);
		sp.setLocation(700, 170);
		contentPane.add(sp);
		
		
		//JScrollPane sp = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		JScrollPane scrollPane1 = new JScrollPane(contentPane);
//		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane1.setBounds(100, 100, 2000, 2000);
//		getContentPane().add(scrollPane1);
		
		
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
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
		
//		btnNewButton.setBackground(new Color(251, 234, 213));
//		btnNewButton_1.setBackground(new Color(251, 234, 213));
		btnNewButton_5.setBackground(new Color(251, 234, 213));
		btnNewButton_6.setBackground(new Color(251, 234, 213));
		btnNewButton_7.setBackground(new Color(251, 234, 213));
		
		
//		
	}
}
