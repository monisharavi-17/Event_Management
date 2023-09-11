package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import mail_sms.*;
import food.both;
import food.menu;
import food.nonveg;
import food.veg;
import hall.Venue;
import hall.beach;
import hall.halls;
import hall.hotel;
import login.Main;
import others.Message;
import others.Car_rental;
import others.Decor;
import others.Giveaway;
import others.Music_dj;
import others.Photo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Confirm_Order extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static int venueid1;
	public static String venuename1;
	public static ArrayList menuitems = new ArrayList<String>();
	public static int orderid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm_Order frame = new Confirm_Order();
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
	public Confirm_Order() {
		User_Page.queue.add("Confirm_Order()");
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
	        scrollPane.setBounds(230, 155, 516, 285);
	        contentPane.add(scrollPane);
	        scrollPane.setViewportView(table);
	        

	        table.setRowHeight(50);

	        table.setModel(new DefaultTableModel(

	        		  new Object[][] {

	                },

	                new String[] {

	                    "SNO", "CHOOSEN ITEMS"

	                }

	            ));
	        
	        //VENUE/........................................................................
	        
	        
	        if (beach.venuecost!=0)
	        {
	        	System.out.println("yessss");
	        	venuename1 = beach.venuename;
	        	venueid1 = beach.venueid;
	        }
	        else if (halls.venuecost!=0)
	        {
	        	System.out.println("yessss1");
	        	venuename1 = halls.venuename;
	        	venueid1 = halls.venueid;
	        }
	        else if (hotel.venuecost !=0)
	        {
	        	System.out.println("yessss2");
	        	venuename1 = hotel.venuename;
	        	venueid1 = hotel.venueid;
	        }
	        else
	        {
	        	venuename1 = Book_Event.venue;
	        }
	        //PHOTO.................................................................................
	        String photos;
	        if (Photo.phototype == 1)
	        {
	        	photos = "Only Photos";
	        }
	        else if (Photo.phototype == 2)
	        {
	        	photos = "Photos and Vedios";
	        }
	        else
	        {
	        	photos = null;
	        }
	        //MENU..................................................................................
	        
	        if (veg.menuitems.size() !=0)
	        {
	        	menuitems = veg.menuitems;
	        }
	        else if (nonveg.menuitems.size() !=0)
	        {
	        	menuitems = nonveg.menuitems;
	        }
	        else if (both.menuitems.size() !=0)
	        {
	        	menuitems = both.menuitems;
	        }
	        else if (veg.foodcombo!=0)
	        {
	        	menuitems.add("Food Combo "+veg.foodcombo);
	        }
	        else if (nonveg.foodcombo!=0)
	        {
	        	menuitems.add("Food Combo "+nonveg.foodcombo);
	        }
	        //............................................................................................
	        
	    	  
	        
		  DefaultTableModel dt= (DefaultTableModel) table.getModel();
	        dt.addRow(new Object[] {"NAME",User_Page.name});
	        dt.addRow(new Object[] {"EVENT NAME",Book_Event.whatevent});
	        dt.addRow(new Object[] {"FROM",Calender.strDate});
	        dt.addRow(new Object[] {"TO",Calender.strDate1});
	        dt.addRow(new Object[] {"SLOT",Calender.slot});
	        dt.addRow(new Object[] {"NUMBER OF GUESTS",Calender.numberofguests});
	        dt.addRow(new Object[] {"VENUE TYPE",Venue.halltype});
	        dt.addRow(new Object[] {"VENUE NAME",venuename1});
	        dt.addRow(new Object[] {"MENU TYPE",menu.menutype});
	        dt.addRow(new Object[] {"MENU ITEMS",menuitems});
	        dt.addRow(new Object[] {"DECORATION PACK",Decor.decorpack});
	        dt.addRow(new Object[] {"DECORATION THEME",Decor.theme});
	        dt.addRow(new Object[] {"MUSIC TYPE",Music_dj.musictype});
	        dt.addRow(new Object[] {"MUSIC LANGUAGE",Music_dj.musiclang});
	        dt.addRow(new Object[] {"MENU PREFERENCE",Music_dj.musicprefer});
	        dt.addRow(new Object[] {"PHOTO TYPE",photos});
	        dt.addRow(new Object[] {"DRONE",Photo.drone});
	        dt.addRow(new Object[] {"PHOTO BOOTH",Photo.photobooth});
	        dt.addRow(new Object[] {"CAKE QUANTITY",Photo.kg});
	        dt.addRow(new Object[] {"CAKE FLAVOUR",Photo.flavour});
	        dt.addRow(new Object[] {"GIFT NAME",Giveaway.giftitems});
	        dt.addRow(new Object[] {"CAR NAME",Car_rental.carid});
	        dt.addRow(new Object[] {"MESSAGE",Message.message});
	        
	        
	        table.setDefaultEditor(Object.class, null);
	        
	      
		
		JButton btnNewButton = new JButton("Confirm Booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int out = JOptionPane.showConfirmDialog(table, "Do You want to Add on More??");
			        if (out == 0)
			        {
			        	if (Decor.decorpack==null)
			        	{
			        		setVisible(false);
			        		new Decor().setVisible(true);
			        	}
			        	else if (Music_dj.musictype.equals(""))
			        	{
			        		setVisible(false);
			        		new Music_dj().setVisible(true);
			        	}
			        	else if (Giveaway.giftitems.size()==0)
			        	{
			        		setVisible(false);
			        		new Giveaway().setVisible(true);
			        	}
			        	else if (Message.message.equals(""))
			        	{
			        		setVisible(false);
			        		new Message().setVisible(true);
			        	}
			        			
			        }
			        else
			        {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
				
				
				
				Statement st = conn.createStatement();
				String s2 = "insert into orders(userid,customerName,start,end,slot,numberofguests,eventname,"
						+ "venuetype,venue_id,venuename,menutype,menuitems,decorpack,decortheme,musictype,musiclang,"
						+ "musicprefer,phototype,drone,photobooth,cakekg,cakeflavour,giftname,carname,message,mobile) values"
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				PreparedStatement ps = conn.prepareStatement(s2);
				ps.setString(1, Main.username);
				ps.setString(2, User_Page.name);
				ps.setString(3, Calender.strDate);
				ps.setString(4, Calender.strDate1);
				ps.setString(5, Calender.slot);
				ps.setInt(6, Calender.numberofguests);
				ps.setString(7, Book_Event.whatevent);
				ps.setString(8, Venue.halltype);
				ps.setInt(9, venueid1);
				ps.setString(10, venuename1);
				ps.setString(11, menu.menutype);
				ps.setString(12, menuitems.toString());
				ps.setString(13, Decor.decorpack);
				ps.setString(14, Decor.theme);
				ps.setString(15, Music_dj.musictype);
				ps.setString(16, Music_dj.musiclang.toString());
				ps.setString(17, Music_dj.musicprefer.toString());
				ps.setString(18, Photo.photoname);
				ps.setBoolean(19, Photo.drone);
				ps.setBoolean(20, Photo.photobooth);
				ps.setInt(21, Photo.kg);
				ps.setString(22, Photo.flavour);
				ps.setString(23, Giveaway.giftitems.toString());
				ps.setString(24, Car_rental.carname);
				ps.setString(25, Message.message);
				ps.setString(26, Main.phoneno);
				System.out.println(ps);
				ps.executeUpdate();
				
				String s3 = "select orderid from orders where userid = ? and start=? and end=? and venue_id=?;";
				PreparedStatement ps1 = conn.prepareStatement(s3);
				ps1.setString(1, Main.username);
				ps1.setString(2, Calender.strDate);
				ps1.setString(3, Calender.strDate1);
				ps1.setInt(4, venueid1);
				System.out.println(ps1);
				ResultSet rs = ps1.executeQuery();
				while (rs.next())
				{
					orderid = rs.getInt(1);
					System.out.println(orderid);
				}
				System.out.println("ok");
				String s4 = "insert into orderstatus(orderid) values(?);";
				PreparedStatement ps2 = conn.prepareStatement(s4);
				ps2.setInt(1, orderid);
				System.out.println(ps2);
				ps2.executeUpdate();
				
				String s5 = "Insert into Booking values (?,?,?,?,?);";
				PreparedStatement ps3 = conn.prepareStatement(s5);
				ps3.setString(1,Calender.strDate);
				ps3.setString(2, Calender.strDate1);
				ps3.setInt(3,venueid1);
				String slot;
				if (Calender.slot == null)
				{
					slot="nothing";
				}
				else
				{
					slot = Calender.slot;
				}
				ps3.setString(4,slot);
				ps3.setString(5, Main.username);
				ps3.executeUpdate();
						
				
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(btnNewButton, "Your Booking has been Processed! You Will +"
						+ "Receive a confirmation via email and sms soon");
				
				try {
					Sms.main(null);
					sendMail.sendMail(Main.email,"demo");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				 new Final().setVisible(true);

			}}
		});
		btnNewButton.setBounds(396, 482, 151, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CONFIRM YOUR BOOKING");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(327, 84, 290, 33);
		contentPane.add(lblNewLabel);
		
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
		btnNewButton_4.setBounds(863, 28, 150, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Message().setVisible(true);
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1049, 28, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
	}
}
