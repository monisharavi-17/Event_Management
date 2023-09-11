package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import login.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Profile extends JFrame {

	private JPanel contentPane;
	 private JTable table;
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 private JPasswordField passwordField;
	 private JPasswordField passwordField_1;
	 private JPasswordField passwordField_2;
	 private static JButton btnNewButton;
	 private static JButton btnNewButton_1;
	 private static JButton btnNewButton_2;
	 private static JButton btnNewButton_3;
	 private static JButton btnNewButton_4;
	 private static JButton btnNewButton_5;
	 private static JButton btnNewButton_6;
	 private JButton btnNewButton_7;
	 private JButton btnNewButton_7_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		User_Page.queue.add("Profile()");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 686);
		setExtendedState(MAXIMIZED_BOTH);
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
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setBounds(652, 190, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(926, 187, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("EMAIL");
		lblNewLabel_2.setBounds(652, 253, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(926, 250, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("MOBILE");
		lblNewLabel_3.setBounds(652, 310, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(926, 307, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(926, 357, 96, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(926, 400, 96, 20);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(926, 446, 96, 20);
		contentPane.add(passwordField_2);
		
		JLabel lblNewLabel_4 = new JLabel("OLD PASSWORD");
		lblNewLabel_4.setBounds(652, 360, 124, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ENTER NEW PASSWORD");
		lblNewLabel_5.setBounds(652, 403, 124, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("RE-ENTER NEW PASSWORD");
		lblNewLabel_6.setBounds(652, 452, 172, 14);
		contentPane.add(lblNewLabel_6);
		
		
		JLabel lblNewLabel = new JLabel("WELCOME "+User_Page.name);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblNewLabel.setBounds(420, 87, 335, 38);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(533, 168, 730, 310);
        contentPane.add(scrollPane);
		
		  table = new JTable();
	        scrollPane.setViewportView(table);
	        table.setRowHeight(50);
	        table.setModel(new DefaultTableModel(

	            new Object[][] {
	            },

	            new String[] {

	                "OrderId", "From" , "To", "Slot","EventName","VenueName","MenuItems","DecorPack","PhotoTYpe","Message"

	            }

	        ));
	        scrollPane.setVisible(false);
	    
	        
		btnNewButton = new JButton("VIEW ALL BOOKINGS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setVisible(false);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblNewLabel_4.setVisible(false);
				lblNewLabel_5.setVisible(false);
				lblNewLabel_6.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				passwordField.setVisible(false);
				passwordField_1.setVisible(false);
				passwordField_2.setVisible(false);
				btnNewButton_4 .setVisible(false);
				btnNewButton_5 .setVisible(false);
				btnNewButton_6 .setVisible(false);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
	        	model.setRowCount(0);
	            try {
	            	scrollPane.setVisible(true);

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
	            DefaultTableModel dt= (DefaultTableModel) table.getModel();
	            //Connection con = customer_login.getCon();
	            Statement st = (Statement) connection.createStatement();
	            String s ="select orderid,start,end,slot,eventname,venuename,menuitems,decorpack,phototype,message from ORDERS where userid=?;";
	            PreparedStatement ps = connection.prepareStatement(s);
	            ps.setString(1,Main.username);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())
	            {
	               dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
	            //sno++;

	            }

	            }

	            catch(Exception e1)

	            {

	                System.out.println(e1);

	            }

				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(175, 155, 259, 51);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("VIEW UPCOMING BOOKINGS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(true);
				lblNewLabel_1.setVisible(false);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
				lblNewLabel_4.setVisible(false);
				lblNewLabel_5.setVisible(false);
				lblNewLabel_6.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				passwordField.setVisible(false);
				passwordField_1.setVisible(false);
				passwordField_2.setVisible(false);
				btnNewButton_4 .setVisible(false);
				btnNewButton_5 .setVisible(false);
				btnNewButton_6 .setVisible(true);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
	        	model.setRowCount(0);
	            try {

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
	            DefaultTableModel dt= (DefaultTableModel) table.getModel();
	            //Connection con = customer_login.getCon();
	            Statement st = (Statement) connection.createStatement();
	            String now = java.time.LocalDate.now().toString();
	            System.out.println(now);
	            String s = "select orderid,start,end,slot,eventname,venuename,menuitems,decorpack,phototype,message from ORDERS where end > ? and userid = ?";
	            PreparedStatement ps = connection.prepareStatement(s);
	            ps.setString(1, now);
	            ps.setString(2, Main.username);
	            System.out.println(ps);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())
	            {
	            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
	            //sno++;

	            }

	            }

	            catch(Exception e1)

	            {

	                System.out.println(e1);

	            }

			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(175, 253, 335, 51);
		contentPane.add(btnNewButton_1);
		
	
		
		
		
		btnNewButton_5 = new JButton("CHANGE PASSWORD");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = passwordField_1.getText();
				String b = passwordField_2.getText();
				
				if (!a.equals(b))
				{
					JOptionPane.showMessageDialog(btnNewButton_5, "Confirm Password is not same as new password");
				}
				else
				{
					 try {

			            Class.forName("com.mysql.jdbc.Driver");
			            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
			          
			            //Connection con = customer_login.getCon();
			            Statement st = (Statement) connection.createStatement();
			            String s ="update user_details set password = ? where username = ?;";
			            PreparedStatement ps = connection.prepareStatement(s);	            
			            ps.setString(1,a);
			            ps.setString(2,Main.username);
			            ps.executeUpdate();
			            JOptionPane.showMessageDialog(scrollPane, "Password Updated Successfully");

			            }

			            catch(Exception e1)

			            {

			                System.out.println(e1);

			            }
				}
				
				
			}
		});
		btnNewButton_5.setBounds(705, 516, 151, 23);
		contentPane.add(btnNewButton_5);
		
		
		btnNewButton_4 = new JButton("UPDATE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String mobile = textField_1.getText();
				try {

		            Class.forName("com.mysql.jdbc.Driver");
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
		          
		            //Connection con = customer_login.getCon();
		            Statement st = (Statement) connection.createStatement();
		            String s ="update user_details set name = ?,mobile=? where username = ?;";
		            PreparedStatement ps = connection.prepareStatement(s);	            
		            ps.setString(1,name);
		            ps.setString(2,mobile);
		            ps.setString(3,Main.username);
		            
		            ps.executeUpdate();
		            JOptionPane.showMessageDialog(btnNewButton_4, "Profile Updated SUcessfully");

		            }

		            catch(Exception e1)

		            {

		                System.out.println(e1);

		            }
				
			}
		});
		btnNewButton_4.setBounds(926, 516, 89, 23);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_6 = new JButton("PAY");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Payment().setVisible(true);
			}
		});
		btnNewButton_6.setBounds(829, 563, 89, 23);
		contentPane.add(btnNewButton_6);
		table.setDefaultEditor(Object.class, null);
		
		
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_3.setVisible(false);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_5.setVisible(false);
		lblNewLabel_6.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		passwordField.setVisible(false);
		passwordField_1.setVisible(false);
		passwordField_2.setVisible(false);
		btnNewButton_4 .setVisible(false);
		btnNewButton_5 .setVisible(false);
		btnNewButton_6 .setVisible(false);
		
		

		
		
		btnNewButton_2 = new JButton("UPDATE PROFILE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(false);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_2.setVisible(true);
				lblNewLabel_3.setVisible(true);
				lblNewLabel_4.setVisible(true);
				lblNewLabel_5.setVisible(true);
				lblNewLabel_6.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				textField_2.setVisible(true);
				passwordField.setVisible(true);
				passwordField_1.setVisible(true);
				passwordField_2.setVisible(true);
				btnNewButton_4 .setVisible(true);
				btnNewButton_5 .setVisible(true);
				btnNewButton_6 .setVisible(false);
				try {

		            Class.forName("com.mysql.jdbc.Driver");
		            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
		          
		            //Connection con = customer_login.getCon();
		            Statement st = (Statement) connection.createStatement();
		            String s ="select name,email,mobile,password from user_details where username = ?";
		            PreparedStatement ps = connection.prepareStatement(s);	            
		            ps.setString(1, Main.username);
		           
		            ResultSet rs = ps.executeQuery();
		            while (rs.next())
		            {
		            	textField.setText(rs.getString(1));
		            	textField_1.setText(rs.getString(2));
		            	textField_2.setText(rs.getString(3));
		            	passwordField.setText(rs.getString(4));
		            }
		           

		            }

		            catch(Exception e1)

		            {

		                System.out.println(e1);

		            }
				
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(175, 357, 259, 51);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_7 = new JButton("HOME");
		btnNewButton_7.addActionListener(new ActionListener() {
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
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Home.48.png"));
		btnNewButton_7.setFont(new Font("Monospaced", Font.BOLD, 17));
		btnNewButton_7.setBackground(new Color(251, 234, 213));
		btnNewButton_7.setBounds(852, 31, 150, 50);
		contentPane.add(btnNewButton_7);
		
		btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.addActionListener(new ActionListener() {
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
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1038, 31, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		JButton btnNewButton_2_1 = new JButton("DELETE PROFILE");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int op = JOptionPane.showConfirmDialog(btnNewButton_2_1, "ARE YOU SURE TO DELETE YOUR PROFILE?");
				if (op == 0)
				{
					try
					{
						 Class.forName("com.mysql.jdbc.Driver");
				         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
				         String s = "Delete from user_details where username=?;";
				         PreparedStatement ps = conn.prepareStatement(s);
				         ps.setString(1,Main.username);
				         ps.executeUpdate();
				         dispose();
					}
					catch(Exception e1)
					{
						System.out.println(e1);
					}
				
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(175, 466, 259, 51);
		contentPane.add(btnNewButton_2_1);
		
		 double total = 0;
	        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	        	total += 1;
	        }
	        
	        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
	        	TableColumn column = table.getColumnModel().getColumn(i);
	        	column.setPreferredWidth((int)
	        			(480 * (100 / total)));
	        }
//	        double total1 = 0;
//	        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
//	        	total1 += 1;
//	        }
//	        TableColumn column = table.getColumnModel().getColumn(8);
//	        column.setPreferredWidth((int)
//	        		(480 * (100 / total1)));
	        
	        table.setDefaultEditor(Object.class, null);
		
		
	}
}
