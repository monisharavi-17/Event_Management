package food;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
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
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import others.Decor;
import user.User_Page;

import java.awt.Color;
import javax.swing.ImageIcon;

public class both extends JFrame {

	private JPanel contentPane;
	public static int countcheckbox=0;
	public static int firstbox = 0;
	public static int secondbox = 0;
	public static int thirdbox = 0;
	public static ArrayList menuitems = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					both frame = new both();
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
	public both() throws SQLException, ClassNotFoundException {
		User_Page.queue.add("both()");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1293, 702);
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
		setContentPane(contentPane);
		 setExtendedState(MAXIMIZED_BOTH);
		 contentPane.setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("WELCOME TO THE VEG & NON VEG SECTION");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel.setBounds(438, 87, 478, 25);
			contentPane.add(lblNewLabel);
			JPanel p = new JPanel();
	        p.setBounds(200, 200, 254, 199);
	        p.setLayout(new GridLayout(0, 1, 0, 0));
	        
	        JPanel p1 = new JPanel();
	        p1.setBounds(200, 200, 254, 199);
	        p1.setLayout(new GridLayout(0, 1, 0, 0));
	        
	        JPanel p2 = new JPanel();
	        p2.setBounds(200, 200, 254, 199);
	        p2.setLayout(new GridLayout(0, 1, 0, 0));
			
			JScrollPane scrollPane1 = new JScrollPane(p);
			scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane1.setBounds(157, 241, 230, 227);
			scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			//scrollPane1.setVisible(false);
			contentPane.add(scrollPane1);
			
			JScrollPane scrollPane2 = new JScrollPane(p1);
			scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane2.setBounds(545, 241, 274, 227);
			scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			//scrollPane2.setVisible(false);
			contentPane.add(scrollPane2);
			
			JScrollPane scrollPane3 = new JScrollPane(p2);
			scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane3.setBounds(983, 241, 248, 227);
			scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			//scrollPane2.setVisible(false);
			contentPane.add(scrollPane3);
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
			Statement st = conn.createStatement();
			String s2 = "select name from food where course = ? or course = ?;"; 
			PreparedStatement ps = conn.prepareStatement(s2);
			ps.setString(1, "starter");
			ps.setString(2, "snack");
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
	        
			while (rs.next())
			{
				JCheckBox chckbxNewCheckBox = new JCheckBox(rs.getString(1));
				chckbxNewCheckBox.setBounds(728, 185, 154, 23);
				p.add(chckbxNewCheckBox);
			}
			
			String s3 = "select name from food where course = ?;"; 
			PreparedStatement ps1 = conn.prepareStatement(s3);
			ps1.setString(1, "main course");
			System.out.println(ps1);
			ResultSet rs1 = ps1.executeQuery();
	        
			while (rs1.next())
			{
				JCheckBox chckbxNewCheckBox = new JCheckBox(rs1.getString(1));
				chckbxNewCheckBox.setBounds(728, 185, 154, 23);
				p1.add(chckbxNewCheckBox);
			}

			String s4 = "select name from food where course = ?;"; 
			PreparedStatement ps2 = conn.prepareStatement(s3);
			ps1.setString(1, "dessert");
			System.out.println(ps2);
			ResultSet rs2 = ps1.executeQuery();
	        
			while (rs2.next())
			{
				JCheckBox chckbxNewCheckBox = new JCheckBox(rs2.getString(1));
				chckbxNewCheckBox.setBounds(728, 185, 154, 23);
				p2.add(chckbxNewCheckBox);
			}
			
			JButton btnNewButton_3 = new JButton("NEXT");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int num = p.getComponentCount();
					int index = 0;
					while (index < num)
					{
						if(((AbstractButton) p.getComponent(index)).isSelected())
						{
							Object k = p.getComponent(index);
							menuitems.add(((javax.swing.AbstractButton)k).getText());
							countcheckbox+=1;
							firstbox+=1;
		
						}
						index+=1;
					}
					int num1 = p1.getComponentCount();
					int index1= 0;
					while (index1 < num1)
					{
						if(((AbstractButton) p1.getComponent(index1)).isSelected())
						{
							Object k = p1.getComponent(index1);
							menuitems.add(((javax.swing.AbstractButton)k).getText());
							countcheckbox+=1;
							secondbox+=1;
		
						}
						index1+=1;
					}
					int num2 = p2.getComponentCount();
					int index2= 0;
					while (index2 < num2)
					{
						if(((AbstractButton) p2.getComponent(index2)).isSelected())
						{
							Object k = p2.getComponent(index2);
							menuitems.add(((javax.swing.AbstractButton)k).getText());
							countcheckbox+=1;
							thirdbox+=1;
		
						}
						System.out.println(menuitems);
						index2+=1;
					}
					System.out.println(countcheckbox);
					System.out.println(firstbox);
					System.out.println(secondbox);
					System.out.println(thirdbox);
					menu.m += 1;
					if (menu.m == menu.meals1)
					{
					setVisible(false);
					new Decor().setVisible(true);
					}
					else 
					{
						setVisible(false);
						new menu().setVisible(true);
					}
					
				}
			});
			btnNewButton_3.setBounds(974, 552, 89, 23);
			contentPane.add(btnNewButton_3);
			
			JLabel lblNewLabel_1 = new JLabel("CUSTOMIZE YOURSELF");
			lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 21));
			lblNewLabel_1.setBounds(529, 137, 268, 25);
			contentPane.add(lblNewLabel_1);
			
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
			btnNewButton_4.setBounds(874, 21, 150, 50);
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
			btnNewButton_7_1.setBounds(1060, 21, 182, 50);
			contentPane.add(btnNewButton_7_1);
			
			JLabel lblNewLabel_2 = new JLabel("STARTERS");
			lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 18));
			lblNewLabel_2.setBounds(157, 195, 208, 35);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("MAIN COURSE");
			lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 18));
			lblNewLabel_3.setBounds(545, 195, 622, 35);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("DESSERTS");
			lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 18));
			lblNewLabel_4.setBounds(983, 195, 184, 14);
			contentPane.add(lblNewLabel_4);
			
//			scrollPane1.setVisible(false);
//			scrollPane2.setVisible(false);
//			scrollPane3.setVisible(false);
//			lblNewLabel_4.setVisible(false);
//			lblNewLabel_2.setVisible(false);
//			lblNewLabel_3.setVisible(false);
			
			JLabel lblNewLabel_61 = new JLabel("New label");
		     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
				Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
				lblNewLabel_61.setIcon(new ImageIcon(newImage11));
				lblNewLabel_61.setBounds(-20, 11, 357, 113);
		     contentPane.add(lblNewLabel_61);
		     
			
			
			

		
		
		
	}
}
