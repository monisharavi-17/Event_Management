package admin;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Alter_Prices extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alter_Prices frame = new Alter_Prices();
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
	public Alter_Prices() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 700);
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
		
		 JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	        scrollPane.setBounds(54, 160, 793, 444);
	        contentPane.add(scrollPane);

        JTable table = new JTable();
        scrollPane.setViewportView(table);
        table.setRowHeight(50);
        table.setModel(new DefaultTableModel(

            new Object[][] {
            },

            new String[] {

                "VenueId", "Type", "Name", "Location" , "CostPerDay", "CostPerSlot","CostOfRoom"

            }

        ));
        

        JLabel lblNewLabel = new JLabel("VIEW VENUES");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        
        lblNewLabel.setBounds(355, 110, 155, 25);
        
        contentPane.add(lblNewLabel);
   
        DefaultTableModel dt= (DefaultTableModel) table.getModel();
               
   
   try {

       Class.forName("com.mysql.jdbc.Driver");
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
       //Connection con = customer_login.getCon();
   
       String s = "select venue_id,type,name,location,costperday,costperslot,costofroom from venue;";
       PreparedStatement ps = connection.prepareStatement(s);
       ResultSet rs =  ps.executeQuery();
       while(rs.next())
       {
         dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
       //sno++;

       }

       }

       catch(Exception e1)

       {

           System.out.println(e1);

       }
          	
   JTextField textField = new JTextField();
   textField.setBounds(1114, 299, 96, 20);
   contentPane.add(textField);
   textField.setColumns(10);
   
   JTextField textField_1 = new JTextField();
   textField_1.setBounds(1114, 368, 96, 20);
   contentPane.add(textField_1);
   textField_1.setColumns(10);
   
   JLabel lblNewLabel_1 = new JLabel("UPDATE PRICE");
   lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
   lblNewLabel_1.setBounds(978, 236, 155, 19);
   contentPane.add(lblNewLabel_1);
   
   JLabel lblNewLabel_2 = new JLabel("VENUE ID");
   lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 18));
   lblNewLabel_2.setBounds(889, 299, 101, 14);
   contentPane.add(lblNewLabel_2);
   
   JLabel lblNewLabel_3 = new JLabel("SET COST PER DAY");
   lblNewLabel_3.setFont(new Font("Monospaced", Font.BOLD, 18));
   lblNewLabel_3.setBounds(889, 368, 178, 14);
   contentPane.add(lblNewLabel_3);
   
   JLabel lblNewLabel_3_1 = new JLabel("SET COST PER SLOT");
   lblNewLabel_3_1.setFont(new Font("Monospaced", Font.BOLD, 18));
   lblNewLabel_3_1.setBounds(889, 433, 198, 14);
   contentPane.add(lblNewLabel_3_1);
   
   textField_2 = new JTextField();
   textField_2.setColumns(10);
   textField_2.setBounds(1114, 433, 96, 20);
   contentPane.add(textField_2);
   
   JLabel lblNewLabel_3_2 = new JLabel("SET COST OF ROOM");
   lblNewLabel_3_2.setFont(new Font("Monospaced", Font.BOLD, 18));
   lblNewLabel_3_2.setBounds(889, 487, 190, 14);
   contentPane.add(lblNewLabel_3_2);
   
   textField_3 = new JTextField();
   textField_3.setColumns(10);
   textField_3.setBounds(1114, 487, 96, 20);
   contentPane.add(textField_3);
   
   JButton btnNewButton = new JButton("UPDATE PRICE");
   btnNewButton.addActionListener(new ActionListener() {
   	public void actionPerformed(ActionEvent e) {
   		 String venue = textField.getText();
   		 String a = textField_1.getText();
   		 String b = textField_2.getText();
   		 String c = textField_3.getText();
   		 System.out.println(a+" "+b+" "+c);
   		 
   		 if (venue.equals(""))
   		 {
   			 JOptionPane.showMessageDialog(btnNewButton, "ENTER VENUE ID");
   		 }
   		 else if (a.equals("") && b.equals("") && c.equals(""))
   		 {
   			 JOptionPane.showMessageDialog(btnNewButton, "Enter Any Value to Update");
   		 }
   		 else if (Integer.parseInt(venue)<41 || Integer.parseInt(venue) > 66)
   		 {
   			 JOptionPane.showMessageDialog(btnNewButton, "Enter Correct Venue Id");
   		 }
   		 else
   		 {		 
	   		 int venueid = Integer.parseInt(venue); 
	   		 try {
	   			 Class.forName("com.mysql.jdbc.Driver");
	   			 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
	   			if (!a.equals(""))
	   			{
	   				int a1 = Integer.parseInt(a);
	   				String s = "update venue set costperday = ? where venue_id = ?;";
	   				PreparedStatement ps = connection.prepareStatement(s);
	   				ps.setInt(1, a1);
	   				ps.setInt(2, venueid);
	   				ps.executeUpdate();
	   				JOptionPane.showMessageDialog(btnNewButton, "Updated Successfully");
	   				
	   			}
	   			if (!b.equals(""))
	   			{
	   				int b1 = Integer.parseInt(b);
	   				String s = "update venue set costperslot = ? where venue_id = ?;";
	   				PreparedStatement ps = connection.prepareStatement(s);
	   				ps.setInt(1, b1);
	   				ps.setInt(2, venueid);
	   				ps.executeUpdate();
	   				JOptionPane.showMessageDialog(btnNewButton, "Updated Successfully");
	   				
	   			}
	   			if (!c.equals(""))
	   			{
	   				int c1 = Integer.parseInt(c);
	   				String s = "update venue set costofroom = ? where venue_id = ?;";
	   				PreparedStatement ps = connection.prepareStatement(s);
	   				ps.setInt(1, c1);
	   				ps.setInt(2, venueid);
	   				ps.executeUpdate();
	   				
	   				JOptionPane.showMessageDialog(btnNewButton, "Updated Successfully");
	   			}
	   	     dt.setRowCount(0);
	
	   		 String s = "select venue_id,type,name,location,costperday,costperslot,costofroom from venue;";
	         PreparedStatement ps = connection.prepareStatement(s);
	         ResultSet rs =  ps.executeQuery();
	         while(rs.next())
	         {
	           dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
	         //sno++;

	         }

	        
	
	            }
	
	            catch(Exception e1)
	
	            {
	                JOptionPane.showMessageDialog(btnNewButton, "Update Unsuccessfull");
	                System.out.println(e1);
	
	            }
   		 }
	               		
	               		
	               	}
	            });
	
               btnNewButton.setBounds(979, 557, 128, 23);
               contentPane.add(btnNewButton);
               
               JButton btnNewButton_4 = new JButton("HOME");
               btnNewButton_4.addActionListener(new ActionListener() {
               	public void actionPerformed(ActionEvent e) {
               		setVisible(false);
            		new AdminPage().setVisible(true);
               	}
               });
               btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Home.48.png"));
               btnNewButton_4.setFont(new Font("Monospaced", Font.BOLD, 17));
               btnNewButton_4.setBackground(new Color(251, 234, 213));
               btnNewButton_4.setBounds(842, 31, 150, 50);
               contentPane.add(btnNewButton_4);
               
               JButton btnNewButton_7_1 = new JButton("BACK");
               btnNewButton_7_1.addActionListener(new ActionListener() {
               	public void actionPerformed(ActionEvent e) {
               		setVisible(false);
            		new AdminPage().setVisible(true);
               	}
               });
               btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
               btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
               btnNewButton_7_1.setBackground(new Color(251, 234, 213));
               btnNewButton_7_1.setBounds(1028, 31, 182, 50);
               contentPane.add(btnNewButton_7_1);
               
               JLabel lblNewLabel_61 = new JLabel("New label");
               Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
          		Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
          		lblNewLabel_61.setIcon(new ImageIcon(newImage11));
          		lblNewLabel_61.setBounds(-20, 11, 357, 113);
               contentPane.add(lblNewLabel_61);
               
	            	                        
	}
}
