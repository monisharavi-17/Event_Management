package admin;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.sql.*;

//import com.mysql.cj.xdevapi.Statement;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

 
public class ViewUsers extends JFrame {

 

 

 

    private JPanel contentPane;

    private JTable table;
    private JTextField textField;

 

    /**

     * Launch the application.

     */

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

 

                    ViewUsers frame = new ViewUsers();

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

    public ViewUsers() {

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
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(329, 308, 635, 300);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setRowHeight(50);
        table.setModel(new DefaultTableModel(

            new Object[][] {
            },

            new String[] {

                "S.No", "Name", "Email", "Username" , "Mobile"

            }

        ));

        JLabel lblNewLabel = new JLabel("VIEW USERS");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        
        lblNewLabel.setBounds(580, 151, 197, 25);
        
        contentPane.add(lblNewLabel);
 
        JRadioButton rdbtnNewRadioButton = new JRadioButton("VIEW ALL USERS");
        rdbtnNewRadioButton.setBounds(170, 221, 111, 23);
        contentPane.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("SEARCH USER BY NAME/ID");
        rdbtnNewRadioButton_1.setBounds(911, 221, 197, 23);
        contentPane.add(rdbtnNewRadioButton_1);
        
        
        ButtonGroup G = new ButtonGroup();
        G.add(rdbtnNewRadioButton);
        G.add(rdbtnNewRadioButton_1);
        
        textField = new JTextField();
        textField.setBounds(933, 258, 96, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
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
        btnNewButton_4.setBounds(895, 11, 150, 50);
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
        btnNewButton_7_1.setBounds(1081, 11, 182, 50);
        contentPane.add(btnNewButton_7_1);
        
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
	            ResultSet rs = ((java.sql.Statement) st).executeQuery("select sno,name,email,username,mobile from User_Details");
	            while(rs.next())
	            {
	            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
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
	            String a = textField.getText();
	            String s3 = "select sno,name,email,username,mobile from User_Details where sno like ? or name like ?;";
	            PreparedStatement ps = connection.prepareStatement(s3);
	            ps.setString(1,"%" + a + "%");
	            ps.setString(2, "%" + a + "%");
	            System.out.println(ps);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next())
	            {
	            dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
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
            total += 10;
        }
     
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                    (480 * (100 / total)));
        }
//        double total1 = 0;
//        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
//            total1 += 2;
//        }
//        TableColumn column = table.getColumnModel().getColumn(9);
//        column.setPreferredWidth((int)
//                (480 * (100 / total1)));
        
        
        table.setDefaultEditor(Object.class, null);
      
        JLabel lblNewLabel_61 = new JLabel("New label");
        Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
   		Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
   		lblNewLabel_61.setIcon(new ImageIcon(newImage11));
   		lblNewLabel_61.setBounds(-20, 11, 357, 113);
        contentPane.add(lblNewLabel_61);

 

        
 

 

        

    }
}
