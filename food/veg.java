package food;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import others.*;
import user.Book_Event;
import user.Calender;
import user.User_Page;

import java.awt.Color;
import javax.swing.ImageIcon;
public class veg extends JFrame {

	private JPanel contentPane;
	public static int countcheckbox=0;
	public static int firstbox = 0;
	public static int secondbox = 0;
	public static int thirdbox = 0;
	public static int foodcombo = 0;
	public static ArrayList menuitems = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					veg frame = new veg();
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
	public veg() throws ClassNotFoundException, SQLException {
		User_Page.queue.add("veg()");
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
		 setExtendedState(MAXIMIZED_BOTH);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO THE VEG SECTION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(513, 63, 337, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("OR");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(627, 126, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("CHOOSE A ALREADY AVAILABLE COMBO");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rdbtnNewRadioButton.setBounds(89, 124, 349, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("CUSTOMIZE YOURSELF");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rdbtnNewRadioButton_1.setBounds(896, 122, 236, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		
		JTextArea txtrSystemoutprintlnthisPackConsists = new JTextArea();
		txtrSystemoutprintlnthisPackConsists.setWrapStyleWord(true);
		txtrSystemoutprintlnthisPackConsists.setLineWrap(true);
		txtrSystemoutprintlnthisPackConsists.setEditable(false);
		txtrSystemoutprintlnthisPackConsists.setText("THIS PACK CONSISTS OF 3 STARTERS, 3 MAIN COURSE, 2 SWEETS AND 1 DRINK\r\n******STARTERS**********\r\n1.Cauliflower Manjurian\r\n2.Paneer Tikka\"\r\n3.Spring Roll\r\n**********MAIN COURSE***********\r\n1.Chapathi with Vegetable and Kurma\r\n2.Rice with Sambar,Curd, Rasam\r\n3.Aapam with Coconut Milk\r\n**********SWEETS****************\r\n1.Payasam\r\n2.Badam Halwa\r\n**********DRINK*****************\r\n1.Bovonto;");
		txtrSystemoutprintlnthisPackConsists.setBounds(89, 184, 393, 125);
		contentPane.add(txtrSystemoutprintlnthisPackConsists);
		
		
		JScrollPane scrollPanea = new JScrollPane(txtrSystemoutprintlnthisPackConsists);
		scrollPanea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanea.setBounds(89, 188, 393, 107);
		scrollPanea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanea.setVisible(false);
		contentPane.add(scrollPanea);
		
		JButton btnNewButton = new JButton("COMBO1\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodcombo=1;
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
		btnNewButton.setBounds(513, 235, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		JTextArea txtrThisPackConsists = new JTextArea();
		txtrThisPackConsists.setText("THIS PACK CONSISTS OF 5 STARTERS, 5 MAIN COURSE, 4 SWEETS AND 2 DRINK\r\n******STARTERS**********\"\r\n1.Cauliflower Manjurian\r\n2.Paneer Tikka\r\n3.Spring Roll\r\n4.Bonda & Bajji\r\n5.Onion Pakoda\r\n**********MAIN COURSE***********\r\n1.Chapathi with 2 Vegetables and Kurma\r\n2.Rice with Sambar,Curd, Rasam\r\n3.Aapam with Coconut Milk\r\n4.Puri with Kurma\r\n5.Idly & Dosa with 3 chutneys\r\n**********SWEETS****************\r\n1.Payasam\r\n2.Badam Halwa\r\n3.Kesari\r\n4.Gulab Jamun\r\n**********DRINK*****************\r\n1.Bovonto\r\n2.Butter Milk");
		txtrThisPackConsists.setBounds(89, 340, 393, 117);
		contentPane.add(txtrThisPackConsists);
		//txtrThisPackConsists.setVisible(false);
		
		JScrollPane scrollPaneb = new JScrollPane(txtrThisPackConsists);
		scrollPaneb.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneb.setBounds(89, 333, 393, 107);
		scrollPaneb.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneb.setVisible(false);
		contentPane.add(scrollPaneb);
		
		
		JButton btnNewButton_1 = new JButton("COMBO2\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodcombo=2;
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
		btnNewButton_1.setBounds(523, 389, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("COMBO3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodcombo=3;
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
		btnNewButton_2.setBounds(523, 524, 89, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
		JTextArea txtrThisPackConsists_1 = new JTextArea();
		txtrThisPackConsists_1.setText("THIS PACK CONSISTS OF 8 STARTERS, 8 MAIN COURSE, 7 SWEETS AND 4 DRINK\");\r\n******STARTERS**********\");\r\n1.Cauliflower Manjurian\");\r\n2.Paneer Tikka\");\r\n3.Spring Roll\");\r\n4.Bonda & Bajji\r\n5.Onion Pakoda\r\n6.Samosa\r\n7.Mushroom65\r\n8.Vegetable Kofta\r\n**********MAIN COURSE***********\r\n1.Chapathi with 2 Vegetables and Kurma\r\n2.Rice with Sambar,Curd, Rasam\r\n3.Aapam with Coconut Milk\r\n4.Puri with Kurma\r\n5.Idly & Dosa with 3 chutneys\r\n6.Vegetable Biriyani\r\n7.Noodles\r\n8. Fried Rice\r\n**********SWEETS****************\r\n1.Payasam\r\n2.Badam Halwa\r\n\"3.Kesari\r\n4.Gulab Jamun\r\n5.Rasgulla\r\n6.Soan Papdi\r\n7.Jelabi\r\n**********DRINK*****************\r\n1.Bovonto\r\n2.Butter Milk\r\n3.Falooda\r\n4.Milk Shakes");
		txtrThisPackConsists_1.setBounds(89, 496, 393, 117);
		contentPane.add(txtrThisPackConsists_1);
		//txtrThisPackConsists_1.setVisible(false);
		
		JScrollPane scrollPanec = new JScrollPane(txtrThisPackConsists_1);
		scrollPanec.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanec.setBounds(89, 487, 393, 107);
		scrollPanec.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanec.setVisible(false);
		contentPane.add(scrollPanec);
		
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
		scrollPane1.setBounds(641, 203, 185, 227);
		scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane1.setVisible(false);
		contentPane.add(scrollPane1);
		
		JScrollPane scrollPane2 = new JScrollPane(p1);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(848, 203, 185, 227);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane2.setVisible(false);
		contentPane.add(scrollPane2);
		
		JScrollPane scrollPane3 = new JScrollPane(p2);
		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane3.setBounds(1066, 203, 190, 227);
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane2.setVisible(false);
		contentPane.add(scrollPane3);
		
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
		Statement st = conn.createStatement();
		String s2 = "select name from food where (course = ? or course = ?) and diet = ?;"; 
		PreparedStatement ps = conn.prepareStatement(s2);
		ps.setString(1, "starter");
		ps.setString(2, "snack");
		ps.setString(3, "vegetarian");
		System.out.println(ps);
		ResultSet rs = ps.executeQuery();
        
		while (rs.next())
		{
			JCheckBox chckbxNewCheckBox = new JCheckBox(rs.getString(1));
			chckbxNewCheckBox.setBounds(728, 185, 154, 23);
			p.add(chckbxNewCheckBox);
		}
		
		String s3 = "select name from food where course = ? and diet = ?;"; 
		PreparedStatement ps1 = conn.prepareStatement(s3);
		ps1.setString(1, "main course");
		ps1.setString(2, "vegetarian");
		System.out.println(ps1);
		ResultSet rs1 = ps1.executeQuery();
        
		while (rs1.next())
		{
			JCheckBox chckbxNewCheckBox = new JCheckBox(rs1.getString(1));
			chckbxNewCheckBox.setBounds(728, 185, 154, 23);
			p1.add(chckbxNewCheckBox);
		}

		String s4 = "select name from food where course = ? and diet = ?;"; 
		PreparedStatement ps2 = conn.prepareStatement(s3);
		ps1.setString(1, "dessert");
		ps1.setString(2, "vegetarian");
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
		 scrollPane1.setVisible(false);
         scrollPane2.setVisible(false);
         scrollPane3.setVisible(false);
         
         JLabel lblNewLabel_1 = new JLabel("STARTERS");
         lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
         lblNewLabel_1.setBounds(662, 178, 104, 14);
         contentPane.add(lblNewLabel_1);
         
         JLabel lblNewLabel_3 = new JLabel("MAIN COURSE");
         lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
         lblNewLabel_3.setBounds(870, 178, 130, 14);
         contentPane.add(lblNewLabel_3);
         
         JLabel lblNewLabel_4 = new JLabel("SWEETS");
         lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
         lblNewLabel_4.setBounds(1106, 178, 89, 14);
         contentPane.add(lblNewLabel_4);
         
         lblNewLabel_1.setVisible(false);
         lblNewLabel_3.setVisible(false);
         lblNewLabel_4.setVisible(false);
         
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	    		
	    		if (Calender.budget1 == 500000)
	    		{
	    			//scrollPanea.setVisible(true);
	    		}
	
	    		else if (Calender.budget1 == 700000)
	    		{
//	    			scrollPanea.setVisible(true);
//	    			scrollPaneb.setVisible(true);
//	    			scrollPanec.setVisible(true);
	    			
	    		}
	    		else if (Calender.budget1 == 1000000)
	    		{
	    			
	    		}
	    		else if (Calender.budget1 == 1500000 && Book_Event.whatevent.equals("wedding"))
	    		{
	    			
	    		}
	    		else if (Calender.budget1 == 1500000)
	    		{
	    			scrollPane1.setVisible(true);
		            scrollPane2.setVisible(true);
		            scrollPane3.setVisible(true);
		            lblNewLabel_1.setVisible(true);
			         lblNewLabel_3.setVisible(true);
			         lblNewLabel_4.setVisible(true);
	    		}
	    		else if (Calender.budget1 == 2000000 && Book_Event.whatevent.equals("wedding"))
	    		{
	    			
	    		}
	    		else if (Calender.budget1 == 2000000)
	    		{
	    			scrollPane1.setVisible(true);
		            scrollPane2.setVisible(true);
		            scrollPane3.setVisible(true);
		            lblNewLabel_1.setVisible(true);
			         lblNewLabel_3.setVisible(true);
			         lblNewLabel_4.setVisible(true);
	    		}
	    		else if (Calender.budget1 == 3000000 && Book_Event.whatevent.equals("wedding"))
	    		{
	    			scrollPane1.setVisible(true);
		            scrollPane2.setVisible(true);
		            scrollPane3.setVisible(true);
		            lblNewLabel_1.setVisible(true);
			         lblNewLabel_3.setVisible(true);
			         lblNewLabel_4.setVisible(true);
	    		}
	    		else if (Calender.budget1 == 3000000)
	    		{
	                scrollPane1.setVisible(true);
		            scrollPane2.setVisible(true);
		            scrollPane3.setVisible(true);
		            lblNewLabel_1.setVisible(true);
			         lblNewLabel_3.setVisible(true);
			         lblNewLabel_4.setVisible(true);

	    			
	    		}
	    		else
	    		{
	    			 scrollPane1.setVisible(true);
			            scrollPane2.setVisible(true);
			            scrollPane3.setVisible(true);
			            lblNewLabel_1.setVisible(true);
				         lblNewLabel_3.setVisible(true);
				         lblNewLabel_4.setVisible(true);
	    		}
//	            scrollPane1.setVisible(true);
//	            scrollPane2.setVisible(true);
//	            scrollPane3.setVisible(true);
	            btnNewButton.setVisible(false);
		        btnNewButton_1.setVisible(false);
		        btnNewButton_2.setVisible(false);
		        btnNewButton.setVisible(false);
		        scrollPanea.setVisible(false);
		        scrollPaneb.setVisible(false);
		        scrollPanec.setVisible(false);
//		        lblNewLabel_1.setVisible(true);
//		         lblNewLabel_3.setVisible(true);
//		         lblNewLabel_4.setVisible(true);
		        

	        }
	    });
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            scrollPane1.setVisible(false);
	            scrollPane2.setVisible(false);
	            scrollPane3.setVisible(false);
//	            btnNewButton.setVisible(true);
//		        btnNewButton_1.setVisible(true);
//		        btnNewButton_2.setVisible(true);
//		        scrollPanea.setVisible(true);
//		        scrollPaneb.setVisible(true);
//		        scrollPanec.setVisible(true);
		        lblNewLabel_1.setVisible(false);
		         lblNewLabel_3.setVisible(false);
		         lblNewLabel_4.setVisible(false);
		         if (Calender.budget1 == 500000)
		    		{
		    			scrollPanea.setVisible(true);
		    			 btnNewButton.setVisible(true);
		    		}
		    		else if (Calender.budget1 == 700000)
		    		{
		    			scrollPanea.setVisible(true);
		    			scrollPaneb.setVisible(true);
		    			 btnNewButton.setVisible(true);
		 		        btnNewButton_1.setVisible(true);
		    		}
		    		
		    		else if (Calender.budget1 == 1000000)
		    		{
		    			scrollPanea.setVisible(true);
		    			scrollPaneb.setVisible(true);
		    			scrollPanec.setVisible(true);
		    			 btnNewButton.setVisible(true);
		 		        btnNewButton_1.setVisible(true);
		 		        btnNewButton_2.setVisible(true);
		    		}
		    		else if (Calender.budget1 == 1500000 && Book_Event.whatevent.equals("wedding"))
		    		{
		    			scrollPanea.setVisible(true);
		    			 btnNewButton.setVisible(true);
		    		}
		    		else if (Calender.budget1 == 1500000)
		    		{
		    			scrollPanea.setVisible(true);
		    			scrollPaneb.setVisible(true);
		    			scrollPanec.setVisible(true);
		    			 btnNewButton.setVisible(true);
		 		        btnNewButton_1.setVisible(true);
		 		        btnNewButton_2.setVisible(true);
		    		}
		   
		    		else if (Calender.budget1 == 2000000 && Book_Event.whatevent.equals("wedding"))
		    		{
		    			scrollPanea.setVisible(true);
		    			scrollPaneb.setVisible(true);
		    			
		    			 btnNewButton.setVisible(true);
		 		        btnNewButton_1.setVisible(true);
		 		       
		    		}
		    		else if (Calender.budget1 == 2000000)
		    		{
		    			scrollPanea.setVisible(true);
		    			scrollPaneb.setVisible(true);
		    			scrollPanec.setVisible(true);
		    			 btnNewButton.setVisible(true);
		 		        btnNewButton_1.setVisible(true);
		 		        btnNewButton_2.setVisible(true);
		    		}
		    		else if (Calender.budget1 == 3000000 && Book_Event.whatevent.equals("wedding"))
		    		{
		    			scrollPanea.setVisible(true);
		    			scrollPaneb.setVisible(true);
		    			scrollPanec.setVisible(true);
		    			 btnNewButton.setVisible(true);
		 		        btnNewButton_1.setVisible(true);
		 		        btnNewButton_2.setVisible(true);
		    		}
		    		else if (Calender.budget1 == 3000000)
		    		{
		    			scrollPanea.setVisible(true);
		    			scrollPaneb.setVisible(true);
		    			scrollPanec.setVisible(true);
		    			 btnNewButton.setVisible(true);
		 		        btnNewButton_1.setVisible(true);
		 		        btnNewButton_2.setVisible(true);
		    			
		    		}
		    		else
		    		{
		    			scrollPanea.setVisible(true);
		    			scrollPaneb.setVisible(true);
		    			scrollPanec.setVisible(true);
		    			 btnNewButton.setVisible(true);
		 		        btnNewButton_1.setVisible(true);
		 		        btnNewButton_2.setVisible(true);
		    		}

	        }
	    });
		btnNewButton_3.setBounds(974, 552, 89, 23);
		contentPane.add(btnNewButton_3);
		
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
		btnNewButton_4.setBounds(896, 11, 150, 50);
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
		btnNewButton_7_1.setBounds(1082, 11, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
		
		
	}
}
