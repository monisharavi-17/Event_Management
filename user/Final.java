package user;

import java.awt.EventQueue;
//import admin.*;
//import employee.*;
import food.*;
import hall.*;
import login.Main;
//import login.*;
//import manager.*;
import others.*;
import user.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.AbstractButton;
//import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Final extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Final frame = new Final();
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
	public Final() {
		User_Page.queue.add("Final()");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1287, 686);
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
		
		JLabel lblNewLabel = new JLabel("BILLING");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(614, 89, 128, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("THE TOTAL BILL AMOUNT GENERATED IS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(118, 163, 418, 19);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(606, 165, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("VIEW SPLITUP");
		chckbxNewCheckBox.setBounds(815, 164, 146, 23);
		contentPane.add(chckbxNewCheckBox);
		int sum = 0;
		System.out.println(User_Page.name);
		System.out.println(Book_Event.whatevent);
		System.out.println(Calender.numberofguests);
		System.out.println(Calender.strDate);
		System.out.println(Calender.strDate1);
		System.out.println(Calender.slot);
		System.out.println(beach.venuename);
		System.out.println(halls.venuename);
		System.out.println(hotel.venuename);
		System.out.println(menu.menutype);
		System.out.println(veg.countcheckbox);
		System.out.println(veg.firstbox);
		System.out.println(veg.secondbox);
		System.out.println(veg.thirdbox);
		System.out.println(veg.foodcombo);
		System.out.println(Decor.theme);
		System.out.println(Decor.decorpack);
		System.out.println(Music_dj.musicprefer);
		System.out.println(Music_dj.musiclang);
		System.out.println(Photo.phototype);
		System.out.println(Photo.pre_event);
		System.out.println(Giveaway.gift1);
		System.out.println(Giveaway.gift2);
		System.out.println(Giveaway.gift3);
		System.out.println(Car_rental.carid);
		
		
		   table = new JTable();
		   JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(429, 256, 452, 188);
	        contentPane.add(scrollPane);
	        scrollPane.setViewportView(table);
	        

	        table.setRowHeight(50);

	        table.setModel(new DefaultTableModel(

	        		  new Object[][] {

	                },

	                new String[] {

	                    "TYPE", "AMOUNT"

	                }

	            ));
	        //VENUE.............................................................................................//
	        int venuers=0;
	        if (beach.venuecost!=0)
	        {
	        	venuers = beach.venuecost;
	        }
	        else if (halls.venuecost!=0)
	        {
	        	venuers = halls.venuecost;
	        }
	        else if (hotel.venuecost!=0)
	        {
	        	venuers = hotel.venuecost;
	        }
	        venuers += beach.roomcost*Venue.numberofrooms;
	        //..................................................................................................//
	        //FOOD..............................................................................................//
	        int foodrs=0;
	        if (veg.foodcombo !=0)
	        {
	        	if (veg.foodcombo == 1)
	        	foodrs = 30*Calender.numberofguests;
	        	
	        	else if (veg.foodcombo == 2)
	        		foodrs = 40 * Calender.numberofguests;
	        	
	        	else 
	        		foodrs = 50* Calender.numberofguests;
	        	System.out.println("vegfoodcombo"+foodrs);
	        }
	        if (veg.countcheckbox!=0)
	        {
	        	int foodrs1 = veg.firstbox*10 + veg.secondbox*25 + veg.thirdbox*15;
	        	foodrs += foodrs1*Calender.numberofguests;
	        	System.out.println("vegcheck"+foodrs);
	        }
	        if (nonveg.foodcombo !=0)
	        {
	        	if (nonveg.foodcombo == 1)
	        	foodrs += 40*Calender.numberofguests;
	        	
	        	if (nonveg.foodcombo == 2)
	        		foodrs += 50 * Calender.numberofguests;
	        	
	        	else 
	        		foodrs += 60* Calender.numberofguests;
	        	
	        	System.out.println("nonvegfoodcombo"+foodrs);
	        }
	        if (nonveg.countcheckbox!=0)
	        {
	        	int foodrs1 = nonveg.firstbox*15 + nonveg.secondbox*30;
	        	foodrs += foodrs1*Calender.numberofguests;
	        	
	        	System.out.println("non veg check"+foodrs);
	        }
	        if (both.countcheckbox!=0)
	        {
	        	int foodrs1 = both.firstbox*20 + both.secondbox*30 + both.thirdbox*20;
	        	foodrs += foodrs1*Calender.numberofguests;
	        	
	        	System.out.println("both check"+foodrs);
	        }
//	        System.out.println(veg.foodcombo);
//	        System.out.println(nonveg.foodcombo);
//	        System.out.println(veg.countcheckbox);
//	        System.out.println(nonveg.countcheckbox);
//	        System.out.println(both.countcheckbox);
//	        System.out.println(foodrs);
//	        System.out.println(Calender.numberofguests);
	        
	        //.................................................................................................//
	        //DECORATION.......................................................................................//
	        int decorrs = 0;
	        if (Decor.decorpack!=null)
	        {
	        	if (Decor.decorpack.equals("basic"))
	        	{
	        		decorrs = 100000;
	        	}
	        	else if (Decor.decorpack.equals("premium"))
	        	{
	        		decorrs = 150000;
	        	}
	        	else if (Decor.decorpack.equals("elite"))
	        	{
	        		decorrs = 200000;
	        	}
	        	
	        }
	        int themers = 0;
	        if (Decor.theme!=null)
	        {
	        	themers = 200000;
	        }
	        //MUSIC.................................................................................................//
	        int musicrs = 0;
	        if (Music_dj.musictype!=null)
	        {
	        	if (Music_dj.musictype.equals("live"))
	        	{
	        		musicrs = 100000;
	        	}
	        	else
	        	{
	        		musicrs = 700000;
	        	}
	        }
	        musicrs += Music_dj.musicprefer.size()*5000;
	        musicrs += Music_dj.musiclang.size()*3000;
	        //PHOTO......................................................................................................
	        int photors = 0;
	        if (Photo.phototype==1)
	        {
	        	photors += 70000;
	        }
	        else if (Photo.phototype == 2)
	        {
	        	photors += 120000;
	        }
	        if (Photo.drone)
	        {
	        	photors += 40000;
	        }
	        if (Photo.photobooth)
	        {
	        	photors += 50000;
	        }
	        if (Photo.pre_event)
	        {
	        	photors += 50000;
	        }
	        //RETURN GIFT.................................................................................................//
	        int giftrs = 0;
	        if (Giveaway.gift1!=0)
	        {
	        	giftrs = Giveaway.gift1*100;
	        }
	        else if (Giveaway.gift2!=0)
	        {
	        	giftrs = Giveaway.gift2*150;
	        }
	        else if (Giveaway.gift3!=0)
	        {
	        	giftrs = Giveaway.gift3*200;
	        }
	        giftrs = giftrs*Calender.numberofguests;
	        //CAR RENTAL..............................................................................................
	        int carrs = 0;
	        if (Car_rental.carid !=0)
	        {
	        	carrs = 10000;
	        }
	        sum = venuers+foodrs+decorrs+themers+musicrs+photors+giftrs+carrs;
	        DefaultTableModel dt= (DefaultTableModel) table.getModel();
	        dt.addRow(new Object[] {"Venue",venuers});
	        dt.addRow(new Object[] {"Food",foodrs});
	        dt.addRow(new Object[] {"Decoration",decorrs});
	        dt.addRow(new Object[] {"Theme",themers});
	        dt.addRow(new Object[] {"Music",musicrs});
	        dt.addRow(new Object[] {"Photo",photors});
	        dt.addRow(new Object[] {"Return Gift",giftrs});
	        dt.addRow(new Object[] {"Car Rental",carrs});
	        dt.addRow(new Object[] {"GRAND TOTAL",sum});
	        
	        
	        table.setDefaultEditor(Object.class, null);
	        scrollPane.setVisible(false);
	        
	        ActionListener actionListener = new ActionListener() {
	            public void actionPerformed(ActionEvent actionEvent) {
	              AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
	              boolean selected = abstractButton.getModel().isSelected();
	              if (selected)
	              {
	            	  scrollPane.setVisible(true);
	              }
	              else
	              {
	            	  scrollPane.setVisible(false);
	              }
	              // abstractButton.setText(newLabel);
	            }

	          };
	          chckbxNewCheckBox.addActionListener(actionListener);
	          
	          textField.setText(String.valueOf(sum));
	          
	          JButton btnNewButton = new JButton("PAY");
	          btnNewButton.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		setVisible(false);
	          		new Payment().setVisible(true);
	          		
	          	}
	          });
	          btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 18));
	          btnNewButton.setBounds(624, 522, 89, 23);
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
	          btnNewButton_4.setBounds(869, 25, 150, 50);
	          contentPane.add(btnNewButton_4);
	          
	          JButton btnNewButton_7_1 = new JButton("BACK");
	          btnNewButton_7_1.addActionListener(new ActionListener() {
	          	public void actionPerformed(ActionEvent e) {
	          		setVisible(false);
					new Confirm_Order().setVisible(true);
	          	}
	          });
	          btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
	          btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
	          btnNewButton_7_1.setBackground(new Color(251, 234, 213));
	          btnNewButton_7_1.setBounds(1055, 25, 182, 50);
	          contentPane.add(btnNewButton_7_1);
	          
	      	try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
			
			
			
			Statement st = conn.createStatement();
			String s2 = "update orders set totalprice = ? where orderid = ?;";
			PreparedStatement ps = conn.prepareStatement(s2);
			ps.setInt(1, sum);
			ps.setInt(2, Confirm_Order.orderid);
			
			System.out.println(ps);
			ps.executeUpdate();
	      	}
	      	catch(Exception e)
	      	{
	      		System.out.println(e);
	      	}
	        
	        
	        
	        
	}
}
