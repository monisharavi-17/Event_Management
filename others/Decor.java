package others;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import food.both;
import food.menu;
import food.nonveg;
import food.veg;
import user.Book_Event;
import user.Calender;
import user.Final;
import user.User_Page;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Decor extends JFrame {

	private JPanel contentPane;
	public static String theme=null;
	public static String decorpack=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Decor frame = new Decor();
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
	public Decor() {
		User_Page.queue.add("decor()");
		
	
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1294, 703);
			Image img111 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\monisha.dr\\Downloads\\Untitled design (1).png");
			contentPane = (new JPanel() {
				@Override
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(img111, 0, 0,1300,950, this);
					//g.fillRect(20, 20, 500, 300);
				}
			});
			contentPane.setBackground(new Color(251, 226, 170));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setExtendedState(MAXIMIZED_BOTH);
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO THE DECORATION SECTION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(415, 74, 451, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SELECT THEME ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(125, 507, 155, 23);
		contentPane.add(lblNewLabel_1);
		
		JTextArea txtrThisPackageIncludes = new JTextArea();
		txtrThisPackageIncludes.setBackground(new Color(251, 226, 170));
		txtrThisPackageIncludes.setEditable(false);
		txtrThisPackageIncludes.setWrapStyleWord(true);
		txtrThisPackageIncludes.setLineWrap(true);
		txtrThisPackageIncludes.setText("This package includes a decent decoration of party hall with materials including Artificial flowers, String Lights, Banners, Glitters and Wrappers. This is sutiable for Birthdays and other Parties");
		txtrThisPackageIncludes.setBounds(65, 180, 352, 180);
		contentPane.add(txtrThisPackageIncludes);
		
		JTextArea txtrThisPackageIncludes_1 = new JTextArea();
		txtrThisPackageIncludes_1.setBackground(new Color(251, 226, 170));
		txtrThisPackageIncludes_1.setText("This package includes a Premium decoration of marriage or party hall with materials including Original flowers, String Lights, Banners, Glitters and Wrappers. This is sutiable for Marriages and Receptions");
		txtrThisPackageIncludes_1.setLineWrap(true);
		txtrThisPackageIncludes_1.setWrapStyleWord(true);
		txtrThisPackageIncludes_1.setToolTipText("");
		txtrThisPackageIncludes_1.setBounds(514, 180, 352, 180);
		contentPane.add(txtrThisPackageIncludes_1);
		
		JTextArea txtrThisPackageIncludes_2 = new JTextArea();
		txtrThisPackageIncludes_2.setBackground(new Color(251, 226, 170));
		txtrThisPackageIncludes_2.setLineWrap(true);
		txtrThisPackageIncludes_2.setWrapStyleWord(true);
		txtrThisPackageIncludes_2.setText("This package includes a Elite decoration of marriage or party hall with Very Grand and rich interior and exterior decoration.");
		txtrThisPackageIncludes_2.setBounds(930, 180, 327, 174);
		contentPane.add(txtrThisPackageIncludes_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Moon Light Theme");
		rdbtnNewRadioButton.setBounds(368, 431, 139, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Royal Palace Theme");
		rdbtnNewRadioButton_1.setBounds(368, 483, 164, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Disney Theme");
		rdbtnNewRadioButton_2.setBounds(368, 526, 139, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Super Hero Theme");
		rdbtnNewRadioButton_3.setBounds(368, 581, 139, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Vintage Theme");
		rdbtnNewRadioButton_4.setBounds(603, 431, 139, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("FairyTale Theme");
		rdbtnNewRadioButton_5.setBounds(603, 483, 139, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Greenery Theme");
		rdbtnNewRadioButton_6.setBounds(603, 526, 139, 23);
		contentPane.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("BASIC PACKAGE");
		rdbtnNewRadioButton_9.setBounds(171, 139, 111, 23);
		contentPane.add(rdbtnNewRadioButton_9);
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("PREMIUM");
		rdbtnNewRadioButton_10.setBounds(623, 139, 111, 23);
		contentPane.add(rdbtnNewRadioButton_10);
		
		JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("ELITE");
		rdbtnNewRadioButton_11.setBounds(1046, 139, 111, 23);
		contentPane.add(rdbtnNewRadioButton_11);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton_9);
		G.add(rdbtnNewRadioButton_10);
		G.add(rdbtnNewRadioButton_11);
		
		ButtonGroup G1 = new ButtonGroup();
		G1.add(rdbtnNewRadioButton_1);
		G1.add(rdbtnNewRadioButton);
		G1.add(rdbtnNewRadioButton_2);
		G1.add(rdbtnNewRadioButton_3);
		G1.add(rdbtnNewRadioButton_4);
		G1.add(rdbtnNewRadioButton_5);
		G1.add(rdbtnNewRadioButton_6);
		
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (rdbtnNewRadioButton.isSelected())
				{
					theme="moon light";
				}
			    else if (rdbtnNewRadioButton_1.isSelected())
				{
					theme="royal";
				}
			    else if (rdbtnNewRadioButton_2.isSelected())
				{
					theme="disney";
				}
			    else if (rdbtnNewRadioButton_3.isSelected())
				{
					theme="superhero";
				}
			    else if (rdbtnNewRadioButton_4.isSelected())
				{
					theme="vintage";
				}
			    else if (rdbtnNewRadioButton_5.isSelected())
				{
					theme="fairytale";
				}
			    else if (rdbtnNewRadioButton_6.isSelected())
				{
					theme="grenery";
				}
				if (rdbtnNewRadioButton_9.isSelected())
				{
					decorpack="basic";
				}
				else if (rdbtnNewRadioButton_10.isSelected())
				{
					decorpack="premium";
				}
				else if (rdbtnNewRadioButton_11.isSelected())
				{
					decorpack="elite";
				}
				System.out.println(decorpack);
				setVisible(false);
				new Music_dj().setVisible(true);
			}
		});
		btnNewButton.setBounds(539, 386, 89, 23);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_4.setBounds(878, 40, 150, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new menu().setVisible(true);
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1064, 40, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		rdbtnNewRadioButton.setVisible(false);
		rdbtnNewRadioButton_1.setVisible(false);
		rdbtnNewRadioButton_2.setVisible(false);
		rdbtnNewRadioButton_3.setVisible(false);
		rdbtnNewRadioButton_4.setVisible(false);
		rdbtnNewRadioButton_5.setVisible(false);
		rdbtnNewRadioButton_6.setVisible(false);
		rdbtnNewRadioButton_9.setVisible(false);
		rdbtnNewRadioButton_10.setVisible(false);
		rdbtnNewRadioButton_11.setVisible(false);
		txtrThisPackageIncludes.setVisible(false);
		txtrThisPackageIncludes_1.setVisible(false);
		txtrThisPackageIncludes_2.setVisible(false);
		if (Calender.budget1 == 500000)
		{
			//scrollPanea.setVisible(true);
			rdbtnNewRadioButton_9.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			
		}
		else if (Calender.budget1 == 700000)
		{
//			scrollPanea.setVisible(true);
//			scrollPaneb.setVisible(true);
			rdbtnNewRadioButton_9.setVisible(true);
			rdbtnNewRadioButton_10.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			txtrThisPackageIncludes_1.setVisible(true);
			//txtrThisPackageIncludes_2.setVisible(true);
			
		
		}

		else if (Calender.budget1 == 1000000)
		{
			rdbtnNewRadioButton_9.setVisible(true);
			rdbtnNewRadioButton_10.setVisible(true);
			rdbtnNewRadioButton_11.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			txtrThisPackageIncludes_1.setVisible(true);
			txtrThisPackageIncludes_2.setVisible(true);
			
			
		}
		else if (Calender.budget1 == 1500000 && Book_Event.whatevent.equals("wedding"))
		{
			rdbtnNewRadioButton_9.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			//txtrThisPackageIncludes_1.setVisible(true);
			//txtrThisPackageIncludes_2.setVisible(true);
			
		}
		else if (Calender.budget1 == 1500000)
		{
			rdbtnNewRadioButton_9.setVisible(true);
			rdbtnNewRadioButton_10.setVisible(true);
			rdbtnNewRadioButton_11.setVisible(true);
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			rdbtnNewRadioButton_2.setVisible(true);
			rdbtnNewRadioButton_3.setVisible(true);
			rdbtnNewRadioButton_4.setVisible(true);
			rdbtnNewRadioButton_5.setVisible(true);
			rdbtnNewRadioButton_6.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			txtrThisPackageIncludes_1.setVisible(true);
			txtrThisPackageIncludes_2.setVisible(true);
			
	
			
		}
		else if (Calender.budget1 == 2000000 && Book_Event.whatevent.equals("wedding"))
		{
			rdbtnNewRadioButton_9.setVisible(true);
			rdbtnNewRadioButton_10.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			txtrThisPackageIncludes_1.setVisible(true);
			//txtrThisPackageIncludes_2.setVisible(true);
			
		}
		
		else if (Calender.budget1 == 2000000)
		{
			rdbtnNewRadioButton_9.setVisible(true);
			rdbtnNewRadioButton_10.setVisible(true);
			rdbtnNewRadioButton_11.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			txtrThisPackageIncludes_1.setVisible(true);
			txtrThisPackageIncludes_2.setVisible(true);
			
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			rdbtnNewRadioButton_2.setVisible(true);
			rdbtnNewRadioButton_3.setVisible(true);
			rdbtnNewRadioButton_4.setVisible(true);
			rdbtnNewRadioButton_5.setVisible(true);
			rdbtnNewRadioButton_6.setVisible(true);
			
		}
		else if (Calender.budget1 == 3000000 && Book_Event.whatevent.equals("wedding"))
		{
			rdbtnNewRadioButton_9.setVisible(true);
			rdbtnNewRadioButton_10.setVisible(true);
			rdbtnNewRadioButton_11.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			txtrThisPackageIncludes_1.setVisible(true);
			txtrThisPackageIncludes_2.setVisible(true);
			
			
		}
		else if (Calender.budget1 == 3000000)
		{
            
			rdbtnNewRadioButton_9.setVisible(true);
			rdbtnNewRadioButton_10.setVisible(true);
			rdbtnNewRadioButton_11.setVisible(true);
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			rdbtnNewRadioButton_2.setVisible(true);
			rdbtnNewRadioButton_3.setVisible(true);
			rdbtnNewRadioButton_4.setVisible(true);
			rdbtnNewRadioButton_5.setVisible(true);
			rdbtnNewRadioButton_6.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			txtrThisPackageIncludes_1.setVisible(true);
			txtrThisPackageIncludes_2.setVisible(true);
			
			
			
		}
		else
		{
			rdbtnNewRadioButton_9.setVisible(true);
			rdbtnNewRadioButton_10.setVisible(true);
			rdbtnNewRadioButton_11.setVisible(true);
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			rdbtnNewRadioButton_2.setVisible(true);
			rdbtnNewRadioButton_3.setVisible(true);
			rdbtnNewRadioButton_4.setVisible(true);
			rdbtnNewRadioButton_5.setVisible(true);
			rdbtnNewRadioButton_6.setVisible(true);
			txtrThisPackageIncludes.setVisible(true);
			txtrThisPackageIncludes_1.setVisible(true);
			txtrThisPackageIncludes_2.setVisible(true);
			
			
		}
		 JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img1 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
	} 
}
