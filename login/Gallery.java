package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;

public class Gallery extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gallery frame = new Gallery();
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
	public Gallery() {
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
		
		
		
		JLabel lblNewLabel = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/1.png")).getImage();
		Image newImage = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel.setIcon(new ImageIcon(newImage));
		lblNewLabel.setBounds(92, 86, 337, 212);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img11 = new ImageIcon(this.getClass().getResource("/2.png")).getImage();
		Image newImage1 = img11.getScaledInstance(354, 217, Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(newImage1));
		lblNewLabel_2.setBounds(502, 86, 354, 217);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/3.png")).getImage();
		Image newImage2 = img2.getScaledInstance(332, 220, Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(newImage2));
		lblNewLabel_3.setBounds(902, 78, 332, 220);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/gallery1.jpg")).getImage();
		Image newImage3 = img3.getScaledInstance(332, 220, Image.SCALE_DEFAULT);
		lblNewLabel_4.setIcon(new ImageIcon(newImage3));
		lblNewLabel_4.setBounds(97, 354, 332, 212);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/images.jpg")).getImage();
		Image newImage4 = img4.getScaledInstance(332, 220, Image.SCALE_DEFAULT);
		lblNewLabel_5.setIcon(new ImageIcon(newImage4));
		lblNewLabel_5.setBounds(502, 354, 337, 212);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/gallery2.jpg")).getImage();
		Image newImage5 = img5.getScaledInstance(332, 220, Image.SCALE_DEFAULT);
		lblNewLabel_6.setIcon(new ImageIcon(newImage5));
		lblNewLabel_6.setBounds(902, 351, 332, 215);
		contentPane.add(lblNewLabel_6);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scrollPane.setBounds(10, 11, 1263, 669);
//		scrollPane.add(lblNewLabel);
//		scrollPane.add(lblNewLabel_1);
//		scrollPane.add(lblNewLabel_2);
//		scrollPane.add(lblNewLabel_3); 
//		contentPane.add(scrollPane);
		
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
	     Image img111 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img111.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-20, -14, 357, 113);
	     contentPane.add(lblNewLabel_61);
		
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
	}
	}

