package admin;

import java.awt.EventQueue;
import mail_sms.*;
import java.util.*;
import java.io.*;
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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Add_View_Employee extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	static String type="Manager";
	 private JTable table;
	 private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_View_Employee frame = new Add_View_Employee();
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
	public Add_View_Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 703);
		contentPane = new JPanel();Image img111 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\monisha.dr\\Downloads\\Untitled design (1).png");
		contentPane_1 = (new JPanel() {
	         @Override
	         public void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            g.drawImage(img111, 0, 0,1300,950, this);
	            //g.fillRect(20, 20, 500, 300);
	         }
	      });contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
	      setExtendedState(MAXIMIZED_BOTH);
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(69, 129, 1140, 502);
		contentPane_1.add(tabbedPane);
//....................................................................................................................
	    
	    JPanel p2=new JPanel();   
	    tabbedPane.add("VIEW EMPLOYEES",p2);  
	    
	    
	    JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(150, 124, 635, 300);
        p2.add(scrollPane);
        

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setRowHeight(50);
        table.setModel(new DefaultTableModel(

            new Object[][] {
            },

            new String[] {

                "S.No", "Name", "Email", "Username" , "Mobile","Date Of Joining"

            }

        ));

        JLabel lblNewLabel4 = new JLabel("VIEW EMPLOYEES");
        lblNewLabel4.setFont(new Font("Monospaced", Font.BOLD, 20));
        lblNewLabel4.setBounds(347, 11, 207, 37);
        p2.setLayout(null);
        
        p2.add(lblNewLabel4);
 
        JRadioButton rdbtnNewRadioButton = new JRadioButton("VIEW ALL EMPLOYEES");
        rdbtnNewRadioButton.setBounds(133, 66, 111, 23);
        p2.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("SEARCH EMPLOYEE BY NAME/ID");
        rdbtnNewRadioButton_1.setBounds(587, 66, 165, 23);
        p2.add(rdbtnNewRadioButton_1);
        
        
        ButtonGroup G = new ButtonGroup();
        G.add(rdbtnNewRadioButton);
        G.add(rdbtnNewRadioButton_1);
        
        textField_5 = new JTextField();
        textField_5.setBounds(769, 67, 96, 20);
        p2.add(textField_5);
        textField_5.setColumns(10);
        
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
	            ResultSet rs = ((java.sql.Statement) st).executeQuery("select emp_id,name,email,username,mobile,date_of_joining from Employee_Details");
	            while(rs.next())
	            {
	            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
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
		            String a = textField_5.getText();
		            String s3 = "select EMP_ID,name,email,username,mobile,date_of_joining from EMPLOYEE_Details where EMP_ID like ? or name like ?;";
		            PreparedStatement ps = connection.prepareStatement(s3);
		            ps.setString(1,"%" + a + "%");
		            ps.setString(2, "%" + a + "%");
		            System.out.println(ps);
		            ResultSet rs = ps.executeQuery();
		            while(rs.next())
		            {
		            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
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
        
        JPanel p3=new JPanel(); 
	    
	    JPanel p1=new JPanel(); 
	    
	    tabbedPane.add("ADD EMPLOYEE",p1);
	    p1.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("ADD EMPLOYEES");
	    lblNewLabel.setBounds(109, 54, 197, 25);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	    p1.add(lblNewLabel);
	    
	    JLabel lblNewLabel_2 = new JLabel("Name");
	    lblNewLabel_2.setBounds(85, 126, 49, 14);
	    p1.add(lblNewLabel_2);
	    
	    textField_1 = new JTextField();
	    textField_1.setBounds(263, 123, 96, 20);
	    p1.add(textField_1);
	    textField_1.setColumns(10);
	    
	    JLabel lblNewLabel_3 = new JLabel("Email");
	    lblNewLabel_3.setBounds(85, 187, 49, 14);
	    p1.add(lblNewLabel_3);
	    
	    textField_2 = new JTextField();
	    textField_2.setBounds(263, 184, 96, 20);
	    p1.add(textField_2);
	    textField_2.setColumns(10);
	    
	    JLabel lblNewLabel_4 = new JLabel("Mobile");
	    lblNewLabel_4.setBounds(85, 250, 49, 14);
	    p1.add(lblNewLabel_4);
	    
	    textField_3 = new JTextField();
	    textField_3.setBounds(263, 247, 96, 20);
	    p1.add(textField_3);
	    textField_3.setColumns(10);
	    
	    JLabel lblNewLabel_5 = new JLabel("Date OF Joining(dd/mm/yyyy)");
	    lblNewLabel_5.setBounds(75, 307, 139, 14);
	    p1.add(lblNewLabel_5);
	    
	    textField_4 = new JTextField();
	    textField_4.setBounds(263, 307, 96, 20);
	    p1.add(textField_4);
	    textField_4.setColumns(10);
	    
	    
	    JButton btnNewButton = new JButton("SUBMIT");
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnNewButton.setBounds(423, 244, 116, 23);
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
//				String empid = textField.getText();
//				int emp_id = Integer.parseInt(empid);
	    		String name = textField_1.getText();
	    		String email = textField_2.getText();
	    		String mobile = textField_3.getText();
	    		String doj = textField_4.getText();
	    		String code = textField.getText();

	    		System.out.println(type);
	    		try {
	    			Class.forName("com.mysql.jdbc.Driver");
	    			Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
	    			String s3 = "insert into employee_details (name,email,mobile,date_of_joining,code,type)values(?,?,?,?,?,?);";
	    			PreparedStatement ps = c1.prepareStatement(s3);
	    			
	    			ps.setString(1, name);
	    			ps.setString(2, email);
	    			ps.setString(3, mobile);
	    			ps.setString(4, doj);
	    			ps.setString(5, code);
	    			ps.setString(6, "Manager");
	    
	    			ps.execute();
	    			JOptionPane.showMessageDialog(btnNewButton, "Employee "+name+" added");
	    			sendMaile.sendMail(email, code);
	    		} catch (Exception e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    		}
	    		
	    		
	    	}
	    });
	    p1.add(btnNewButton);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
	    
	    JButton btnNewButton_1 = new JButton("GENERATE CODE");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 Random rand = new Random(62);
	             
	    	        // Characters to be included
	    	        String chrs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    	      
	    	        // Generate n characters from above set and
	    	        // add these characters to captcha.
	    	        String captcha = "";
	    	        for (int i = 0; i < 6; i++){
	    	            int index = (int)(Math.random()*62);
	    	            captcha+=chrs.charAt(index);
	    	        }
	    	           
	    	        textField.setText(captcha);
	    	    
	    	}
	    });
	    btnNewButton_1.setBounds(75, 367, 139, 23);
	    p1.add(btnNewButton_1);
	    
	    textField = new JTextField();
	    textField.setBounds(263, 368, 96, 20);
	    p1.add(textField);
	    textField.setColumns(10);
	    
	    tabbedPane.add("ADD EMPLOYEE",p1);
	    p1.setLayout(null);
	    
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
	    btnNewButton_4.setBounds(841, 28, 150, 50);
	    contentPane_1.add(btnNewButton_4);
	    
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
	    btnNewButton_7_1.setBounds(1027, 28, 182, 50);
	    contentPane_1.add(btnNewButton_7_1);
	    
	    JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
      


 

        
	    
	    
	    
	}
}
