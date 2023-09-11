package food;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hall.Venue;
import others.Decor;
import user.User_Page;

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

public class menu extends JFrame {

	private JPanel contentPane;
	public static String menutype;
	static int m = 0;
	static int meals1;
	static int flag = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		User_Page.queue.add("menu()");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1307, 691);
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
		
		if (flag == 0)
		{
		String meals = JOptionPane.showInputDialog("How Many Meals(times) to be serverd");
		meals1 = Integer.parseInt(meals);
		String subs = "";
		flag = 1;
		}
		
//		//JLabel lb1 = new JLabel("Choose for the "+i+subs+"meal");
//		contentPane.add(lb1);
//		lb1.setBounds(502, 100, 354, 24);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO THE FOOD SECTION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(502, 79, 354, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(82, 161, 366, 212);
		Image img = new ImageIcon(this.getClass().getResource("/veg.jpg")).getImage(); //just drag and drop from computer
		Image newImage = img.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_1.setIcon(new ImageIcon(newImage));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("VEG");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menutype = "veg";
				setVisible(false);
				try {
					new veg().setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(175, 384, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(836, 161, 366, 212);
		Image img1 = new ImageIcon(this.getClass().getResource("/nonveg.jpg")).getImage(); //just drag and drop from computer
		Image newImage1 = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(newImage1));
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("NON VEG");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menutype = "nonveg";
				setVisible(false);
				try {
					new nonveg().setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(924, 384, 175, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(467, 391, 366, 212);
		Image img2 = new ImageIcon(this.getClass().getResource("/both.jpg")).getImage(); //just drag and drop from computer
		Image newImage2 = img2.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(newImage2));
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("VEG AND NON VEG");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menutype = "both";
				setVisible(false);
				try {
					new both().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(512, 629, 270, 23);
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
		btnNewButton_4.setBounds(886, 21, 150, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Venue(Venue.from,Venue.to,Venue.slot).setVisible(true);
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1072, 21, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
	
	}
}
