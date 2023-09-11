package hall;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user.Calender;
import user.User_Page;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Venue extends JFrame {

	private JPanel contentPane;
	public static String from;
	public static String to;
	public static String slot;
	public static String halltype="";
	public static int numberofrooms = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venue frame = new Venue(from,to,slot);
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
	public Venue(String from, String to, String slot) {
		User_Page.queue.add("Venue()");
		this.from = from;
		this.to= to;
		this.slot = slot;
		System.out.println(from+" "+to+" "+slot);
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
		
		JLabel lblNewLabel = new JLabel("CHOOSE THE VENUE FOR YOUR GREAT DAY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(421, 99, 459, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(222, 170, 297, 175);
		Image img = new ImageIcon(this.getClass().getResource("/halls.jpg")).getImage(); //just drag and drop from computer
		Image newImage = img.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_1.setIcon(new ImageIcon(newImage));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SEPERATE HALLS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				halltype = "seperate halls";
				setVisible(false);
				try {
					new halls(from,to,slot).setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(248, 356, 223, 31);
		contentPane.add(btnNewButton);
		btnNewButton.setToolTipText("");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(751, 253, 365, 196);
		Image img1 = new ImageIcon(this.getClass().getResource("/beachresorts.jpg")).getImage(); //just drag and drop from computer
		Image newImage1 = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(newImage1));
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("PRIVATE BEACHES");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				halltype = "private beaches";
			   String result =  JOptionPane.showInputDialog("How many rooms you want to book? Type 0 For Null");
			   numberofrooms = Integer.parseInt(result);
				setVisible(false);
				try {
					new beach(from,to,slot).setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(809, 475, 257, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(223, 428, 297, 185);
		Image img2 = new ImageIcon(this.getClass().getResource("/hotel.jpg")).getImage(); //just drag and drop from computer
		Image newImage2 = img2.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(newImage2));
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("HOTELS AND RESORTS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				halltype = "hotels";
				String result =  JOptionPane.showInputDialog("How many rooms you want to book? Type 0 For Null.A room can occupy 5 to 6 members");
				   numberofrooms = Integer.parseInt(result);
				setVisible(false);
				try {
					new hotel(from,to,slot).setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(263, 624, 223, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("HOME");
		btnNewButton_4.addActionListener(new ActionListener() {
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
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Home.48.png"));
		btnNewButton_4.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnNewButton_4.setBackground(new Color(251, 234, 213));
		btnNewButton_4.setBounds(850, 23, 150, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Calender(Calender.type).setVisible(true);
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1036, 23, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
	}
}
