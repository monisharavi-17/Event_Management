package hall;

import java.awt.EventQueue;
import food.*;
import others.Decor;
import user.Book_Event;
import user.Calender;
import user.User_Page;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class beach extends JFrame {

	private JPanel contentPane;
	public static String from;
	public static String to;
	public static String slot;
	public static String venuename="";
	public static int venuecost=0;
	public static int roomcost = 0;
	public static int venueid;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	public static ArrayList location = new ArrayList<String>();
	public static ArrayList costperslot = new ArrayList<String>();
	public static ArrayList costperday = new ArrayList<String>();
	public static ArrayList costofroom = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					beach frame = new beach(from,to,slot);
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
	public beach(String from, String to, String slot) throws ClassNotFoundException, SQLException {
		User_Page.queue.add("beach()");
		this.from = from;
		this.to= to;
		this.slot = slot;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image imgg = Toolkit.getDefaultToolkit().getImage("C:\\Users\\monisha.dr\\Downloads\\Untitled design (1).png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 728);
		contentPane = (new JPanel() {
	         @Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(imgg, 0, 0,1300,950, this);
	            //g.fillRect(20, 20, 500, 300);
	         }
	      });
		 setExtendedState(MAXIMIZED_BOTH);
		 
		 

		 Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
			Statement st = conn.createStatement();
			
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BEACH RESORTS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(752, 75, 261, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(141, 154, 49, 14);
		Image img = new ImageIcon(this.getClass().getResource("/bluelagoon.jpg")).getImage(); //just drag and drop from computer
		Image newImage = img.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		String string1 = "";
		lblNewLabel_1.setToolTipText("<html><p width=\"500\">" +string1+"</p></html>");
		lblNewLabel_1.setIcon(new ImageIcon(newImage));
		//contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Blue Lagoon Beach Resort");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int flag = 0;
							String s2 = "select venue_id from venue where name = ?;";
							PreparedStatement ps = conn.prepareStatement(s2);
							ps.setString(1, "BLUE LAGOON"); 
							ResultSet rs = ps.executeQuery();
							int id=0;
							while (rs.next())
							{
								id = rs.getInt(1);
							}
//						    
							
							String s3 = "select start,end,slot from booking where venue_id = ?;";
							PreparedStatement ps1 = conn.prepareStatement(s3);
							ps1.setInt(1, id); 
							ResultSet rs1 = ps1.executeQuery();
							System.out.println(ps1);
							while (rs1.next())
							{
								String alreadyfrom = rs1.getString(1);
								String alreadyto = rs1.getString(2);
								String slot1 = rs1.getString(3);
	                            
								System.out.println(from);
								System.out.println(to);
								System.out.println(alreadyfrom);
								System.out.println(alreadyto);
								Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyfrom);  
								Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyto);  
								Date date3=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
								Date date4=new SimpleDateFormat("yyyy-MM-dd").parse(to);
								System.out.println(date1.equals(date2));
								System.out.println(date3.equals(date4));
								System.out.println(slot1.equals(slot));
								
								if (date1.equals(date2) && date3.equals(date4))
								{
									if (slot1.equals("nothing"))
									{
										JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
									    flag = 1;
										break;
									}
									if (slot1.equals(slot))
									{
										JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
									    flag = 1;
										break;
									}
									
								}
								else if ((date3.after(date1)) && (date3.after(date2)) || ((date3.before(date2)) && (date3.before(date1)) ))
								{
//									venuename = "BLUE LAGOON";
//									setVisible(false);
//									new menu().setVisible(true);
//									venueid = id;
//									JOptionPane.showMessageDialog( btnNewButton, "You Have Choosen "+venuename);
								    flag = 0;
								}
								else
								{
									JOptionPane.showMessageDialog(btnNewButton, "This Venue is already booked for your selected slot");
								    flag = 1;
									break;
								}
								
								
								
							}
							String s4 = "select costperslot, costperday, costofroom from venue where venue_id = ?;";
							PreparedStatement ps2 = conn.prepareStatement(s4);
							ps2.setInt(1, id); 
							ResultSet rs2 = ps2.executeQuery();
							while(rs2.next())
							{
								if (slot!=null)
								{
									venuecost = rs2.getInt(1);
									roomcost = rs2.getInt(3);
								}
								else
								{
									 Date date111=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
									 Date date222=new SimpleDateFormat("yyyy-MM-dd").parse(to);
									 long difference_In_Time= date222.getTime() - date111.getTime();
									 long difference_In_Days= ((difference_In_Time/ (1000 * 60 * 60 * 24))% 365)+1;
									 System.out.println(difference_In_Days);
									 venuecost = (int) (rs2.getInt(2)*difference_In_Days);
									 roomcost = rs2.getInt(3);
	
								}
								System.out.println("venuecost"+venuecost);
							}
							if (flag == 0)
							{
								
								venuename = "BLUE LAGOON";
								JOptionPane.showMessageDialog( btnNewButton, "You Have Choosen "+venuename);
								setVisible(false);
								new menu().setVisible(true);
								venueid = id;
								
							}
						} catch (SQLException | ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
			}
		});
		btnNewButton.setBounds(107, 186, 137, 23);
		//contentPane.add(btnNewButton);
		
		JPanel s1 = new JPanel();
		s1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		s1.add(lblNewLabel_1);
		s1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(100, 170, 49, 14);
		Image img1 = new ImageIcon(this.getClass().getResource("/mgm.jpg")).getImage(); //just drag and drop from computer
		Image newImage1 = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(newImage1));
		//contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("MGM BEACH RESORT");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int flag = 0;
					String s2 = "select venue_id from venue where name = ?;";
					PreparedStatement ps = conn.prepareStatement(s2);
					ps.setString(1, "MGM"); 
					ResultSet rs = ps.executeQuery();
					int id=0;
					while (rs.next())
					{
						id = rs.getInt(1);
					}
					
					
					String s3 = "select start,end,slot from booking where venue_id = ?;";
					PreparedStatement ps1 = conn.prepareStatement(s3);
					ps1.setInt(1, id); 
					ResultSet rs1 = ps1.executeQuery();
					System.out.println(ps1);
					while (rs1.next())
					{
						String alreadyfrom = rs1.getString(1);
						String alreadyto = rs1.getString(2);
						String slot1 = rs1.getString(3);
						System.out.println(from);
						System.out.println(to);
						System.out.println(alreadyfrom);
						System.out.println(alreadyto);
						Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyfrom);  
						Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyto);  
						Date date3=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
						Date date4=new SimpleDateFormat("yyyy-MM-dd").parse(to);
						System.out.println(date1.equals(date2));
						System.out.println(date3.equals(date4));
						System.out.println(slot1.equals(slot));
						
						if (date1.equals(date2) && date3.equals(date4))
						{
							if (slot1.equals("nothing"))
							{
								System.out.println("yes2");
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked2");
								flag = 1;
								break;
							}
							
							else if (slot1.equals(slot))
							{
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked1");
								flag = 1;
								break;
							}
							
						}
						else if ((date3.after(date1)) && (date3.after(date2)) || ((date3.before(date2)) && (date3.before(date1)) ))
						{
//							System.out.println("I am going");
//							setVisible(false);
//							new menu().setVisible(true);
//							venuename = "MGM";
//							venueid = id;
							flag = 0;
						}
						else
						{
							
							JOptionPane.showMessageDialog(btnNewButton, "This Venue is already booked for your selected slot");
							flag = 1;
						    break;
						}
						
						
						
					}
					String s4 = "select costperslot, costperday, costofroom from venue where venue_id = ?;";
					PreparedStatement ps2 = conn.prepareStatement(s4);
					ps2.setInt(1, id); 
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next())
					{
						if (slot!=null)
						{
							venuecost = rs2.getInt(1);
							roomcost = rs2.getInt(3);
						}
						else
						{
							 Date date111=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
							 Date date222=new SimpleDateFormat("yyyy-MM-dd").parse(to);
							 long difference_In_Time= date222.getTime() - date111.getTime();
							 long difference_In_Days= ((difference_In_Time/ (1000 * 60 * 60 * 24))% 365)+1;
							 System.out.println(difference_In_Days);
							 venuecost = (int) (rs2.getInt(2)*difference_In_Days);
							 roomcost = rs2.getInt(3);

						}
						System.out.println(venuecost);
					}
					System.out.println("flag check"+flag);
					if (flag == 0)
					{
						System.out.println("flag is 0");
						setVisible(false);
						new menu().setVisible(true);
						venuename = "MGM";
						venueid = id;
					}
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(107, 186, 137, 23);
		//contentPane.add(btnNewButton_1);
		
		JPanel s2 = new JPanel();
		s2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		s2.add(lblNewLabel_2);
		s2.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(1080, 154, 49, 14);
		Image img2 = new ImageIcon(this.getClass().getResource("/chariot.jpg")).getImage(); //just drag and drop from computer
		Image newImage2 = img2.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(newImage2));
		//contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("CHARIOT BEACH RESORT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int flag = 0;
					String s2 = "select venue_id from venue where name = ?;";
					PreparedStatement ps = conn.prepareStatement(s2);
					ps.setString(1, "CHARIOT"); 
					ResultSet rs = ps.executeQuery();
					int id=0;
					while (rs.next())
					{
						id = rs.getInt(1);
					}
					
					
					String s3 = "select start,end,slot from booking where venue_id = ?;";
					PreparedStatement ps1 = conn.prepareStatement(s3);
					ps1.setInt(1, id); 
					ResultSet rs1 = ps1.executeQuery();
					System.out.println(ps1);
					while (rs1.next())
					{
						String alreadyfrom = rs1.getString(1);
						String alreadyto = rs1.getString(2);
						String slot1 = rs1.getString(3);
						System.out.println(from);
						System.out.println(to);
						System.out.println(alreadyfrom);
						System.out.println(alreadyto);
						Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyfrom);  
						Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyto);  
						Date date3=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
						Date date4=new SimpleDateFormat("yyyy-MM-dd").parse(to);
						System.out.println(date1.equals(date2));
						System.out.println(date3.equals(date4));
						System.out.println(slot1.equals(slot));
						
						if (date1.equals(date2) && date3.equals(date4))
						{
							if (slot1.equals("nothing"))
							{
								
								System.out.println("yes2");
								flag = 1;
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
								break;
							}
							if (slot1.equals(slot))
							{
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
								flag = 1;
								break;
							}
						}
						else if ((date3.after(date1)) && (date3.after(date2)) || ((date3.before(date2)) && (date3.before(date1)) ))
						{
//							setVisible(false);
//							new menu().setVisible(true);
//							venuename = "CHARIOT";
//							venueid = id;
							flag = 0;
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton, "This Venue is already booked for your selected slot");
					        flag = 1;
					        break;
						}
						
						
					}
					String s4 = "select costperslot, costperday, costofroom from venue where venue_id = ?;";
					PreparedStatement ps2 = conn.prepareStatement(s4);
					ps2.setInt(1, id); 
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next())
					{
						if (slot!=null)
						{
							venuecost = rs2.getInt(1);
							roomcost = rs2.getInt(3);
						}
						else
						{
							 Date date111=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
							 Date date222=new SimpleDateFormat("yyyy-MM-dd").parse(to);
							 long difference_In_Time= date222.getTime() - date111.getTime();
							 long difference_In_Days= ((difference_In_Time/ (1000 * 60 * 60 * 24))% 365)+1;
							 System.out.println(difference_In_Days);
							 venuecost = (int) (rs2.getInt(2)*difference_In_Days);
							 roomcost = rs2.getInt(3);

						}
						System.out.println(venuecost);
					}
					if (flag == 0)
					{
						setVisible(false);
						new menu().setVisible(true);
						venuename = "CHARIOT";
						venueid = id;
					}
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(1050, 186, 137, 23);
		//contentPane.add(btnNewButton_2);
		
		JPanel s3 = new JPanel();
		s3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		s3.add(lblNewLabel_3);
		s3.add(btnNewButton_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(141, 444, 49, 14);
		Image img3 = new ImageIcon(this.getClass().getResource("/taj.jpg")).getImage(); //just drag and drop from computer
		Image newImage3 = img3.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_4.setIcon(new ImageIcon(newImage3));
		//contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("GREEN CLOVE RESORT");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int flag = 0;
					String s2 = "select venue_id from venue where name = ?;";
					PreparedStatement ps = conn.prepareStatement(s2);
					ps.setString(1, "GREEN CLOVE"); 
					ResultSet rs = ps.executeQuery();
					int id=0;
					while (rs.next())
					{
						id = rs.getInt(1);
					}
					
					
					String s3 = "select start,end,slot from booking where venue_id = ?;";
					PreparedStatement ps1 = conn.prepareStatement(s3);
					ps1.setInt(1, id); 
					ResultSet rs1 = ps1.executeQuery();
					System.out.println(ps1);
					while (rs1.next())
					{
						String alreadyfrom = rs1.getString(1);
						String alreadyto = rs1.getString(2);
						String slot1 = rs1.getString(3);
						System.out.println(from);
						System.out.println(to);
						System.out.println(alreadyfrom);
						System.out.println(alreadyto);
						Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyfrom);  
						Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyto);  
						Date date3=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
						Date date4=new SimpleDateFormat("yyyy-MM-dd").parse(to);
						System.out.println(date1.equals(date2));
						System.out.println(date3.equals(date4));
						System.out.println(slot1.equals(slot));
						
						if (date1.equals(date2) && date3.equals(date4))
						{
							if (slot1.equals("nothing"))
							{
								System.out.println("yes2");
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
								 flag = 1;
							        break;
							}
							if (slot1.equals(slot))
							{
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
								 flag = 1;
							        break;
							}
						}
						else if ((date3.after(date1)) && (date3.after(date2)) || ((date3.before(date2)) && (date3.before(date1)) ))
						{
//							setVisible(false);
//							new menu().setVisible(true);
//							venuename = "GREEN CLOVE";
//							venueid = id;
							flag = 0;
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton, "This Venue is already booked for your selected slot");
							 flag = 1;
						        break;
						}
						
						
					}
					String s4 = "select costperslot, costperday, costofroom from venue where venue_id = ?;";
					PreparedStatement ps2 = conn.prepareStatement(s4);
					ps2.setInt(1, id); 
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next())
					{
						if (slot!=null)
						{
							venuecost = rs2.getInt(1);
							roomcost = rs2.getInt(3);
						}
						else
						{
							 Date date111=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
							 Date date222=new SimpleDateFormat("yyyy-MM-dd").parse(to);
							 long difference_In_Time= date222.getTime() - date111.getTime();
							 long difference_In_Days= ((difference_In_Time/ (1000 * 60 * 60 * 24))% 365)+1;
							 System.out.println(difference_In_Days);
							 venuecost = (int) (rs2.getInt(2)*difference_In_Days);
							 roomcost = rs2.getInt(3);

						}
						System.out.println(venuecost);
					}
					if (flag == 0)
					{
						setVisible(false);
						new menu().setVisible(true);
						venuename = "GREEN CLOVE";
						venueid = id;
					}
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_3.setBounds(117, 474, 122, 23);
		//contentPane.add(btnNewButton_3);
		
		JPanel s4 = new JPanel();
		s4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		s4.add(lblNewLabel_4);
		s4.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(601, 444, 49, 14);
		Image img4 = new ImageIcon(this.getClass().getResource("/radison (1).jpg")).getImage(); //just drag and drop from computer
		Image newImage4 = img4.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_5.setIcon(new ImageIcon(newImage4));
		//contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_4 = new JButton("RADISON BLU RESORT");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int flag =0;
					String s2 = "select venue_id from venue where name = ?;";
					PreparedStatement ps = conn.prepareStatement(s2);
					ps.setString(1, "RADISON BLU"); 
					ResultSet rs = ps.executeQuery();
					int id=0;
					while (rs.next())
					{
						id = rs.getInt(1);
					}
					
					
					String s3 = "select start,end,slot from booking where venue_id = ?;";
					PreparedStatement ps1 = conn.prepareStatement(s3);
					ps1.setInt(1, id); 
					ResultSet rs1 = ps1.executeQuery();
					System.out.println(ps1);
					while (rs1.next())
					{
						String alreadyfrom = rs1.getString(1);
						String alreadyto = rs1.getString(2);
						String slot1 = rs1.getString(3);
						System.out.println(from);
						System.out.println(to);
						System.out.println(alreadyfrom);
						System.out.println(alreadyto);
						System.out.println(slot1);
						System.out.println(slot);
						Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyfrom);  
						Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyto);  
						Date date3=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
						Date date4=new SimpleDateFormat("yyyy-MM-dd").parse(to);
						System.out.println(date1.equals(date2));
						System.out.println(date3.equals(date4));
						System.out.println(slot1.equals(slot));
						
						if (date1.equals(date3) && date2.equals(date4))
						{
							System.out.println("yess11");
							if (slot1.equals("nothing"))
							{
								System.out.println("yes2");
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
								 flag = 1;
							        break;
							}
							if (slot1.equals(slot))
							{
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
								 flag = 1;
							        break;
							}
						}
						else if ((date3.after(date1)) && (date3.after(date2)) || ((date3.before(date1)) && (date3.before(date2)) ))
						{
//							System.out.println(true);
//							setVisible(false);
//							new menu().setVisible(true);
//							venuename = "RADISON BLU";
//							venueid = id;
							flag = 0;
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton, "This Venue is already booked for your selected slot");
							 flag = 1;
						        break;
						}
					
						
					}
					System.out.println(flag);
					String s4 = "select costperslot, costperday, costofroom from venue where venue_id = ?;";
					PreparedStatement ps2 = conn.prepareStatement(s4);
					ps2.setInt(1, id); 
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next())
					{
						if (slot!=null)
						{
							venuecost = rs2.getInt(1);
							roomcost = rs2.getInt(3);
						}
						else
						{
							 Date date111=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
							 Date date222=new SimpleDateFormat("yyyy-MM-dd").parse(to);
							 long difference_In_Time= date222.getTime() - date111.getTime();
							 long difference_In_Days= ((difference_In_Time/ (1000 * 60 * 60 * 24))% 365)+1;
							 System.out.println(difference_In_Days);
							 venuecost = (int) (rs2.getInt(2)*difference_In_Days);
							 roomcost = rs2.getInt(3);

						}
						System.out.println(venuecost);
					}
					if (flag == 0)
					{
						setVisible(false);
						new menu().setVisible(true);
						venuename = "RADISON BLU";
						venueid = id;
					}
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_4.setBounds(573, 474, 122, 23);
		//contentPane.add(btnNewButton_4);
		
		JPanel s5= new JPanel();
		s5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		s5.add(lblNewLabel_5);
		s5.add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(1080, 444, 49, 14);
		Image img5 = new ImageIcon(this.getClass().getResource("/intercontinental.jpg")).getImage(); //just drag and drop from computer
		Image newImage5 = img5.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_6.setIcon(new ImageIcon(newImage5));
		//contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_5 = new JButton("INTERCONTINENTAL ECR");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String s2 = "select venue_id from venue where name = ?;";
					PreparedStatement ps = conn.prepareStatement(s2);
					ps.setString(1, "INTERCONTINENTAL"); 
					ResultSet rs = ps.executeQuery();
					int id=0;
					while (rs.next())
					{
						id = rs.getInt(1);
					}
					
					
					String s3 = "select start,end,slot from booking where venue_id = ?;";
					PreparedStatement ps1 = conn.prepareStatement(s3);
					ps1.setInt(1, id); 
					ResultSet rs1 = ps1.executeQuery();
					System.out.println(ps1);
					int flag = 0;
					while (rs1.next())
					{
						String alreadyfrom = rs1.getString(1);
						String alreadyto = rs1.getString(2);
						String slot1 = rs1.getString(3);
						System.out.println(from);
						System.out.println(to);
						System.out.println(alreadyfrom);
						System.out.println(alreadyto);
						Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyfrom);  
						Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(alreadyto);  
						Date date3=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
						Date date4=new SimpleDateFormat("yyyy-MM-dd").parse(to);
						System.out.println(date1.equals(date2));
						System.out.println(date3.equals(date4));
						System.out.println(slot1.equals(slot));
						
						if (date1.equals(date2) && date3.equals(date4))
						{
							if (slot1.equals("nothing"))
							{
								System.out.println("yes2");
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
								 flag = 1;
							        break;
							}
							if (slot1.equals(slot))
							{
								JOptionPane.showMessageDialog(btnNewButton, "This is already booked");
								 flag = 1;
							        break;
							}
						}
						else if ((date3.after(date1)) && (date3.after(date2)) || ((date3.before(date1)) && (date3.before(date2)) ))
						{
//							setVisible(false);
//							new menu().setVisible(true);
//							venuename = "INTERCONTINENTAL";
//							venueid = id;/
							flag = 0;
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton, "This Venue is already booked for your selected slot");
							 flag = 1;
						        break;
						}
						
						
						
					}
					String s4 = "select costperslot, costperday, costofroom from venue where venue_id = ?;";
					PreparedStatement ps2 = conn.prepareStatement(s4);
					ps2.setInt(1, id); 
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next())
					{
						if (slot!=null)
						{
							venuecost = rs2.getInt(1);
							roomcost = rs2.getInt(3);
						}
						else
						{
							 Date date111=new SimpleDateFormat("yyyy-MM-dd").parse(from);  
							 Date date222=new SimpleDateFormat("yyyy-MM-dd").parse(to);
							 long difference_In_Time= date222.getTime() - date111.getTime();
							 long difference_In_Days= ((difference_In_Time/ (1000 * 60 * 60 * 24))% 365)+1;
							 System.out.println(difference_In_Days);
							 venuecost = (int) (rs2.getInt(2)*difference_In_Days);
							 roomcost = rs2.getInt(3);

						}
						System.out.println(venuecost);
					}
					if (flag == 0)
					{
						setVisible(false);
						new menu().setVisible(true);
						venuename = "INTERCONTINENTAL";
						venueid = id;
					}
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_5.setBounds(1050, 474, 137, 23);
		//contentPane.add(btnNewButton_5);
		
		JPanel s6 = new JPanel();
		s6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		s6.add(lblNewLabel_6);
		s6.add(btnNewButton_5);
		
		JPanel pContainer = new JPanel();
		pContainer.setLayout(new GridLayout(0, 1, 0, 0));
		
		pContainer.add(s1);
		pContainer.add(s2);
		pContainer.add(s3);
		pContainer.add(s4);
		pContainer.add(s5);
		pContainer.add(s6);
		
		JScrollPane jsp=new JScrollPane(pContainer);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(650, 116, 591, 538);
		contentPane.add(jsp);
		
		JLabel lblNewLabel_7 = new JLabel("<html>PLEASE CHOOSE FROM<br>THE LIST OF HALLS</html>");
		lblNewLabel_7.setFont(new Font("Monospaced", Font.BOLD, 34));
		lblNewLabel_7.setBounds(72, 91, 437, 152);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("BLUE LAGOON ");
		lblNewLabel_8.setBounds(83, 297, 132, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("MGM RESORT");
		lblNewLabel_9.setBounds(83, 348, 96, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("CHARIOT RESORT");
		lblNewLabel_10.setBounds(83, 404, 96, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("GREEN CLOVE");
		lblNewLabel_11.setBounds(83, 455, 96, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("RADISSON BLU");
		lblNewLabel_12.setBounds(83, 505, 96, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("INTERCONTINENTAL");
		lblNewLabel_13.setBounds(83, 549, 132, 14);
		contentPane.add(lblNewLabel_13);
		
		
try {
			
			String query = "select location,costperslot,costperday,costofroom from venue where type=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, "beach"); 
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				location.add(rs.getString(1));
				costperslot.add(rs.getString(2));
				costperday.add(rs.getString(3));
				costofroom.add(rs.getString(4));
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		ArrayList cost = new ArrayList<String>();
		String room = "";
		if (slot==null)
		{
			cost = costperday;
			room = "Cost Per Day";
		}
		else
		{
			cost = costperslot;
			room = "Cost Per Slot";
		}
		textField = new JTextField();
		textField.setText((String) location.get(0));
		textField.setBounds(251, 294, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText((String) cost.get(0));
		textField_1.setBounds(389, 294, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText((String) location.get(1));
		textField_2.setBounds(251, 345, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText((String) cost.get(1));
		textField_3.setBounds(389, 345, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		
		textField_4.setText((String) location.get(2));
		textField_4.setBounds(251, 401, 96, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText((String) cost.get(2));
		textField_5.setBounds(389, 401, 96, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText((String) location.get(3));
		textField_6.setBounds(251, 452, 96, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setText((String) cost.get(3));
		textField_7.setBounds(389, 452, 96, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setText((String) location.get(4));
		textField_8.setBounds(251, 502, 96, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setText((String) cost.get(4));
		textField_9.setBounds(389, 502, 96, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setText((String) location.get(5));
		textField_10.setBounds(251, 546, 96, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setText((String) cost.get(5));
		textField_11.setBounds(389, 546, 96, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setText((String) costofroom.get(0));
		textField_12.setBounds(518, 294, 96, 20);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setText((String) costofroom.get(1));
		textField_13.setBounds(518, 345, 96, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setText((String) costofroom.get(2));
		textField_14.setBounds(518, 401, 96, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setText((String) costofroom.get(3));
		textField_15.setBounds(518, 452, 96, 20);
		contentPane.add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setText((String) costofroom.get(4));
		textField_16.setBounds(518, 502, 96, 20);
		contentPane.add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setText((String) costofroom.get(5));
		textField_17.setBounds(518, 546, 96, 20);
		contentPane.add(textField_17);
		textField_17.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("LOCATION");
		lblNewLabel_14.setBounds(251, 254, 96, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel(room);
		lblNewLabel_15.setBounds(389, 254, 96, 14);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("COST OF ROOM");
		lblNewLabel_16.setBounds(518, 254, 96, 14);
		contentPane.add(lblNewLabel_16);
		
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
		btnNewButton_4_1.setBounds(888, 14, 150, 50);
		contentPane.add(btnNewButton_4_1);
		
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
		btnNewButton_7_1.setBounds(1074, 14, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		s1.setVisible(false);
		s2.setVisible(false);
		s3.setVisible(false);
		s4.setVisible(false);
		s5.setVisible(false);
		s6.setVisible(false);
		
		if (Calender.budget1 == 500000)
		{
			s1.setVisible(true);
		}
		else if (Calender.budget1 == 700000)
		{
			s1.setVisible(true);
			s2.setVisible(true);
		}
		
		else if (Calender.budget1 == 1000000)
		{
			s1.setVisible(true);
			s2.setVisible(true);
			s3.setVisible(true);
		}
		else if (Calender.budget1 == 1500000 && Book_Event.whatevent.equals("wedding"))
		{
			s1.setVisible(true);
			s2.setVisible(true);
		}
		else if (Calender.budget1 == 1500000)
		{
			s1.setVisible(true);
			s2.setVisible(true);
			s3.setVisible(true);
			s4.setVisible(true);
		}
		else if (Calender.budget1 == 2000000 && Book_Event.whatevent.equals("wedding"))
		{
			s1.setVisible(true);
			s2.setVisible(true);
			s3.setVisible(true);
		}
		else if (Calender.budget1 == 2000000)
		{
			s1.setVisible(true);
			s2.setVisible(true);
			s3.setVisible(true);
			s4.setVisible(true);
			s5.setVisible(true);
			
		}
		else if (Calender.budget1 == 3000000 && Book_Event.whatevent.equals("wedding"))
		{
			s1.setVisible(true);
			s2.setVisible(true);
			s3.setVisible(true);
			s4.setVisible(true);
		}
		else if (Calender.budget1 == 3000000)
		{
			s1.setVisible(true);
			s2.setVisible(true);
			s3.setVisible(true);
			s4.setVisible(true);
			s5.setVisible(true);
			s6.setVisible(true);
			
		}
		else
		{
			s1.setVisible(true);
			s2.setVisible(true);
			s3.setVisible(true);
			s4.setVisible(true);
			s5.setVisible(true); 
			s6.setVisible(true);
		}
		JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
	}

		
	}

