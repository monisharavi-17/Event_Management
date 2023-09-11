package admin;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.sql.*;

//import com.mysql.cj.xdevapi.Statement;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

 
public class View_Orders extends JFrame {

 

 

 

    private JPanel contentPane;

   private JTable table;
    private JTable table11;
    private JTextField textField;
    private JTextField textField_1;

 

    /**

     * Launch the application.

     */

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

 

                    View_Orders frame = new View_Orders();

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

    public View_Orders() {

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
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setExtendedState(MAXIMIZED_BOTH);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(69, 91, 1140, 540);
        contentPane.add(tabbedPane);
        
        
        
        ButtonGroup G = new ButtonGroup();
        
        JPanel p1=new JPanel();
        p1.setBounds(69, 84, 1135, 547);
        tabbedPane.add("View Orders",p1);
        p1.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(142, 163, 741, 310);
        p1.add(scrollPane);
        
                table = new JTable();
                scrollPane.setViewportView(table);
                table.setRowHeight(50);
                table.setModel(new DefaultTableModel(

                    new Object[][] {
                    },

                    new String[] {

                        "OrderId", "UserName", "CustomerName", "From" , "To", "Slot","EventName","VenueName","MenuItems","DecorPack","PhotoTYpe","Message","Total Price","Reference Id"

                    }

                ));
                

                JLabel lblNewLabel = new JLabel("VIEW ORDERS");
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
                
                lblNewLabel.setBounds(547, 28, 197, 25);
                
                p1.add(lblNewLabel);
                
                       JRadioButton rdbtnNewRadioButton = new JRadioButton("VIEW ALL ORDERS");
                       rdbtnNewRadioButton.setBounds(116, 96, 153, 23);
                       p1.add(rdbtnNewRadioButton);
                       
                       
                       JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("VIEW UNASSIGNED ORDERS");
                       rdbtnNewRadioButton_1.setBounds(897, 96, 197, 23);
                       p1.add(rdbtnNewRadioButton_1);
                       
                       JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("VIEW CURRENT ORDERS");
                       rdbtnNewRadioButton_2.setBounds(521, 96, 153, 23);
                       p1.add(rdbtnNewRadioButton_2);
                       G.add(rdbtnNewRadioButton);
                       G.add(rdbtnNewRadioButton_1);
                       G.add(rdbtnNewRadioButton_2);
                       
                       textField = new JTextField();
                       textField.setBounds(931, 290, 96, 20);
                       p1.add(textField);
                       textField.setColumns(10);
                       
                       textField_1 = new JTextField();
                       textField_1.setBounds(931, 363, 96, 20);
                       p1.add(textField_1);
                       textField_1.setColumns(10);
                       
                       JButton btnNewButton = new JButton("Assign");
                       btnNewButton.addActionListener(new ActionListener() {
                       	public void actionPerformed(ActionEvent e) {
                       		int orderid = Integer.parseInt(textField.getText());
                       		int managerid = Integer.parseInt(textField_1.getText());
                       		
                       		 try {

     	            Class.forName("com.mysql.jdbc.Driver");
     	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
     	            DefaultTableModel dt= (DefaultTableModel) table.getModel();
     	            //Connection con = customer_login.getCon();
     	        
     	            String s = "update orders set assignstatus=?,managerid=? where orderid=?;";
     	            PreparedStatement ps = connection.prepareStatement(s);
     	            ps.setString(1, "yes");
     	            ps.setInt(2, managerid);
     	            ps.setInt(3, orderid);
     	            System.out.println(ps);
     	            ps.executeUpdate();
     	            JOptionPane.showMessageDialog(btnNewButton, "Manager Assigned");

     	            }

     	            catch(Exception e1)

     	            {

     	                System.out.println(e1);

     	            }
                       		
                       		
                       	}
                       });
                       btnNewButton.setBounds(938, 415, 89, 23);
                       p1.add(btnNewButton);
                       
                       JLabel lblNewLabel_1 = new JLabel("ASSIGN MANAGERS");
                       lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
                       lblNewLabel_1.setBounds(931, 209, 204, 25);
                       p1.add(lblNewLabel_1);
                       
                       JLabel lblNewLabel_2 = new JLabel("Order Id");
                       lblNewLabel_2.setBounds(931, 260, 128, 14);
                       p1.add(lblNewLabel_2);
                       
                       JLabel lblNewLabel_3 = new JLabel("Manager ID");
                       lblNewLabel_3.setBounds(932, 338, 111, 14);
                       p1.add(lblNewLabel_3);
        
        
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            
	        	DefaultTableModel model = (DefaultTableModel) table.getModel();
	        	model.setRowCount(0);
	            try {

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
	            DefaultTableModel dt= (DefaultTableModel) table.getModel();
	            //Connection con = customer_login.getCon();
	            Statement st = (Statement) connection.createStatement();
	            ResultSet rs = ((java.sql.Statement) st).executeQuery("select orderid,userid,customerName,start,end,slot,eventname,venuename,menuitems,decorpack,phototype,message,totalprice,paymentstatus from ORDERS");
	            while(rs.next())
	            {
	            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13),rs.getString(14)});
	            //sno++;

	            }

	            }

	            catch(Exception e1)

	            {

	                System.out.println(e1);

	            }


	        }
	    });
         
        
        //action listener for second radio button
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	DefaultTableModel model = (DefaultTableModel) table.getModel();
	        	model.setRowCount(0);
	            try {

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
	            DefaultTableModel dt= (DefaultTableModel) table.getModel();
	            //Connection con = customer_login.getCon();
	            Statement st = (Statement) connection.createStatement();
	            ResultSet rs = ((java.sql.Statement) st).executeQuery("select orderid,userid,customerName,start,end,slot,eventname,venuename,menuitems,decorpack,phototype,message,totalprice from ORDERS where assignstatus is null");
	            while(rs.next())
	            {
	            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13)});
	            //sno++;

	            }

	            }

	            catch(Exception e1)

	            {

	                System.out.println(e1);

	            }


	        }
	    });
        
        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
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
	            String s = "select orderid,userid,customerName,start,end,slot,eventname,venuename,menuitems,decorpack,phototype,message,totalprice from ORDERS where end > ?";
	            PreparedStatement ps = connection.prepareStatement(s);
	            ps.setString(1, now);
	            System.out.println(ps);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())
	            {
	            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13)});
	            //sno++;

	            }

	            }

	            catch(Exception e1)

	            {

	                System.out.println(e1);

	            }


	        }
	    });
        
        table.setDefaultEditor(Object.class, null);
        
        //PANEL 2 CODE...............................................................................
        JPanel p2=new JPanel();
        p2.setBounds(69, 84, 1135, 547);
        tabbedPane.add("View Contact Forms",p2);
        p2.setLayout(null);
        
        
        JScrollPane scrollPane11 = new JScrollPane();
        scrollPane11.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane11.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane11.setBounds(142, 163, 741, 310);
        p2.add(scrollPane11);
        
                table11 = new JTable();
                scrollPane11.setViewportView(table11);
                table11.setRowHeight(50);
                table11.setModel(new DefaultTableModel(

                    new Object[][] {
                    },

                    new String[] {

                        "OrderId", "Name", "MOBILE", "EMAIL" , "SUBJECT", "MESSAGE"

                    }

                ));
                

                JLabel lblNewLabel23 = new JLabel("VIEW ORDERS");
                lblNewLabel23.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
                
                lblNewLabel23.setBounds(547, 28, 197, 25);
                
                p2.add(lblNewLabel23);
                
                       JRadioButton rdbtnNewRadioButton123 = new JRadioButton("VIEW ALL ORDERS");
                       rdbtnNewRadioButton123.setBounds(116, 96, 153, 23);
                       p2.add(rdbtnNewRadioButton123);
                       
                       
                       JRadioButton rdbtnNewRadioButton_123 = new JRadioButton("VIEW UNASSIGNED ORDERS");
                       rdbtnNewRadioButton_123.setBounds(897, 96, 197, 23);
                       p2.add(rdbtnNewRadioButton_123);
                       G.add(rdbtnNewRadioButton123);
                       G.add(rdbtnNewRadioButton_123);
                       
                       JTextField textField12 = new JTextField();
                       textField12.setBounds(931, 290, 96, 20);
                       p2.add(textField12);
                       textField12.setColumns(10);
                       
                       JTextField textField_123 = new JTextField();
                       textField_123.setBounds(931, 363, 96, 20);
                       p2.add(textField_123);
                       textField_123.setColumns(10);
                       
                       JButton btnNewButton12 = new JButton("Assign");
                       btnNewButton12.addActionListener(new ActionListener() {
                       	public void actionPerformed(ActionEvent e) {
                       		int orderid = Integer.parseInt(textField12.getText());
                       		int managerid = Integer.parseInt(textField_123.getText());
                       		
                       		 try {

     	            Class.forName("com.mysql.jdbc.Driver");
     	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
     	            DefaultTableModel dt= (DefaultTableModel) table11.getModel();
     	            //Connection con = customer_login.getCon();
     	        
     	            String s = "update orders set managerid=? where orderid=?;";
     	            PreparedStatement ps = connection.prepareStatement(s);
     	            ps.setInt(1, managerid);
     	            ps.setInt(2, orderid);
     	            System.out.println(ps);
     	            ps.executeUpdate();
     	            JOptionPane.showMessageDialog(btnNewButton12, "Manager Assigned");

     	            }

     	            catch(Exception e1)

     	            {

     	                System.out.println(e1);

     	            }
                       		
                       		
                       	}
                       });
                       btnNewButton12.setBounds(938, 415, 89, 23);
                       p2.add(btnNewButton12);
                       
                       JLabel lblNewLabel_111 = new JLabel("ASSIGN MANAGERS");
                       lblNewLabel_111.setFont(new Font("Tahoma", Font.BOLD, 15));
                       lblNewLabel_111.setBounds(931, 209, 204, 25);
                       p2.add(lblNewLabel_111);
                       
                       JLabel lblNewLabel_222 = new JLabel("Order Id");
                       lblNewLabel_222.setBounds(931, 260, 128, 14);
                       p2.add(lblNewLabel_222);
                       
                       JLabel lblNewLabel_333 = new JLabel("Manager ID");
                       lblNewLabel_333.setBounds(932, 338, 111, 14);
                       p2.add(lblNewLabel_333);
                       
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
                       btnNewButton_4.setBounds(892, 22, 150, 50);
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
                       btnNewButton_7_1.setBounds(1078, 22, 182, 50);
                       contentPane.add(btnNewButton_7_1);
        
        
        rdbtnNewRadioButton123.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            
	        	DefaultTableModel model = (DefaultTableModel) table11.getModel();
	        	model.setRowCount(0);
	            try {

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
	            DefaultTableModel dt= (DefaultTableModel) table11.getModel();
	            //Connection con = customer_login.getCon();
	            Statement st = (Statement) connection.createStatement();
	            ResultSet rs = ((java.sql.Statement) st).executeQuery("select orderid,name,phone,email,subject,message,totalprice,managerid from offline");
	            while(rs.next())
	            {
	            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8)});
	            //sno++;

	            }

	            }

	            catch(Exception e1)

	            {

	                System.out.println(e1);

	            }


	        }
	    });
         
        
        //action listener for second radio button
        rdbtnNewRadioButton_123.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	DefaultTableModel model = (DefaultTableModel) table11.getModel();
	        	model.setRowCount(0);
	            try {

	            Class.forName("com.mysql.jdbc.Driver");
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
	            DefaultTableModel dt= (DefaultTableModel) table11.getModel();
	            //Connection con = customer_login.getCon();
	            Statement st = (Statement) connection.createStatement();
	            ResultSet rs = ((java.sql.Statement) st).executeQuery("select orderid,name,phone,email,subject,message,totalprice from OFFLINE where managerid is null");
	            while(rs.next())
	            {
	            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)});
	            //sno++;

	            }

	            }

	            catch(Exception e1)

	            {

	                System.out.println(e1);

	            }


	        }
	    });
        
        
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
        	total += 1;
        }
        
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
        	TableColumn column = table.getColumnModel().getColumn(i);
        	column.setPreferredWidth((int)
        			(480 * (100 / total)));
        }
        double total1 = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
        	total1 += 1;
        }
        TableColumn column = table.getColumnModel().getColumn(8);
        column.setPreferredWidth((int)
        		(480 * (100 / total1)));
        
        table11.setDefaultEditor(Object.class, null);
        
        
        JLabel lblNewLabel_61 = new JLabel("New label");
        Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
   		Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
   		lblNewLabel_61.setIcon(new ImageIcon(newImage11));
   		lblNewLabel_61.setBounds(-20, 11, 357, 113);
        contentPane.add(lblNewLabel_61);


 

        
 

 

        

    }
}
