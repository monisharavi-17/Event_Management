package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Book_Event extends JFrame {

	private JPanel contentPane;
	public static String whatevent="";
	public static String venue="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book_Event frame = new Book_Event();
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
	public Book_Event() {
		User_Page.queue.add("Book_Event()");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 728);
		Image img111 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\monisha.dr\\Downloads\\Untitled design (1).png");
		contentPane = (new JPanel() {
	         @Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img111, 0, 0,1300,950, this);
	            //g.fillRect(20, 20, 500, 300);
	         }
	      });
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setExtendedState(MAXIMIZED_BOTH);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHOOSE THE EVENT YOU WANT TO BOOK");
		lblNewLabel.setBounds(444, 72, 425, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 165, 295, 154);
		Image img = new ImageIcon(this.getClass().getResource("/wedding.jpg")).getImage(); //just drag and drop from computer
		Image newImage = img.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_1.setIcon(new ImageIcon(newImage));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("WEDDING");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DateTextField d = new DateTextField();
				whatevent="wedding";
				setVisible(false);
				new Calender("Wedding").setVisible(true);
			}
		});
		btnNewButton.setBounds(55, 337, 196, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(325, 165, 295, 154);
		Image img1 = new ImageIcon(this.getClass().getResource("/babyshower.jpg")).getImage(); //just drag and drop from computer
		Image newImage1 = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(newImage1));
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("BABY SHOWER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whatevent="babyshower";
				setVisible(false);
				new Calender("Baby Shower").setVisible(true);
			}
		});
		btnNewButton_1.setBounds(381, 337, 196, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(650, 165, 295, 154);
		Image img2 = new ImageIcon(this.getClass().getResource("/birthday.jpg")).getImage(); //just drag and drop from computer
		Image newImage2 = img2.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(newImage2));
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("BIRTHDAY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whatevent="birthday";
				setVisible(false);
				new Calender("Birthday").setVisible(true);
			}
		});
		btnNewButton_2.setBounds(737, 337, 196, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(969, 165, 295, 154);
		Image img3 = new ImageIcon(this.getClass().getResource("/retirement.jpg")).getImage(); //just drag and drop from computer
		Image newImage3 = img3.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_4.setIcon(new ImageIcon(newImage3));
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("RETIREMENT EVENTS");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whatevent="retirement";
				setVisible(false);
				new Calender("Retirement Event").setVisible(true);
			}
		});
		btnNewButton_3.setBounds(1014, 337, 196, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(10, 430, 295, 154);
		Image img4 = new ImageIcon(this.getClass().getResource("/stage.jpg")).getImage(); //just drag and drop from computer
		Image newImage4 = img4.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_5.setIcon(new ImageIcon(newImage4));
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("STAGE SETUP");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whatevent="stagesetup";
				venue = JOptionPane.showInputDialog(btnNewButton_4, "Give The Name of Venue");
				setVisible(false);
				new Calender("Stage SetUp").setVisible(true);
			}
		});
		btnNewButton_4.setBounds(66, 604, 196, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(337, 430, 295, 154);
		Image img5 = new ImageIcon(this.getClass().getResource("/festival.jpg")).getImage(); //just drag and drop from computer
		Image newImage5 = img5.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_6.setIcon(new ImageIcon(newImage5));
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_5 = new JButton("FESTIVAL EVENTS");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whatevent="festival";
				venue = JOptionPane.showInputDialog(btnNewButton_4, "Give The Name and location of Venue");
				setVisible(false);
				new Calender("festival").setVisible(true);
			}
		});
		btnNewButton_5.setBounds(393, 604, 196, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(650, 430, 295, 154);
		Image img6 = new ImageIcon(this.getClass().getResource("/catering.jpg")).getImage(); //just drag and drop from computer
		Image newImage6 = img6.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_7.setIcon(new ImageIcon(newImage6));
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_6 = new JButton("OTHERS");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String whatevent1 = JOptionPane.showInputDialog(btnNewButton_4, "Enter Name of the Event");
				whatevent="others";
				setVisible(false);
				new Calender(whatevent1).setVisible(true);
			}
		});
		btnNewButton_6.setBounds(1014, 604, 196, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(969, 430, 295, 154);
		Image img7 = new ImageIcon(this.getClass().getResource("/others.jpg")).getImage(); //just drag and drop from computer
		Image newImage7 = img7.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_8.setIcon(new ImageIcon(newImage7));
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_7 = new JButton("CATERING SERVICES");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				whatevent="catering";
				venue = JOptionPane.showInputDialog(btnNewButton_4, "Give The Name and Address of Venue");
				setVisible(false);
				new Calender("catering").setVisible(true);
			}
		});
		btnNewButton_7.setBounds(714, 604, 196, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_4_1 = new JButton("HOME");
		btnNewButton_4_1.addActionListener(new ActionListener() {
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
		btnNewButton_4_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Home.48.png"));
		btnNewButton_4_1.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnNewButton_4_1.setBackground(new Color(251, 234, 213));
		btnNewButton_4_1.setBounds(865, 11, 150, 50);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new User_Page(User_Page.name).setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1051, 11, 182, 50);
		contentPane.add(btnNewButton_7_1);
	}
}
