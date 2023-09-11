package employee;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Assing extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assing frame = new Assing();
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
	public Assing() {
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
		scrollPane.setBounds(177, 189, 831, 427);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setRowHeight(65);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumnModel columnModel = table.getColumnModel();
        
        
        table.setModel(new DefaultTableModel(

            new Object[][] {
            },

            new String[] {

            		"OrderId", "UserName", "CustomerName","Mobile", "From" , "To", "Slot","EventName","VenueName","MenuItems","DecorPack","PhotoTYpe","Message","Total Price"

            }

        ));
        
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += 10;
        }
     
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                    (480 * (100 / total)));
        }
        double total1 = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total1 += 2;
        }
        TableColumn column = table.getColumnModel().getColumn(9);
        column.setPreferredWidth((int)
                (480 * (100 / total1)));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(870, 223, 0, 0);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton_4 = new JButton("HOME");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		try {
					new Employee_Page().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Graphicloads-100-Flat-Home.48.png"));
        btnNewButton_4.setFont(new Font("Monospaced", Font.BOLD, 17));
        btnNewButton_4.setBackground(new Color(251, 234, 213));
        btnNewButton_4.setBounds(893, 25, 150, 50);
        contentPane.add(btnNewButton_4);
        
        JButton btnNewButton_7_1 = new JButton("BACK");
        btnNewButton_7_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		try {
					new Employee_Page().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
        btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
        btnNewButton_7_1.setBackground(new Color(251, 234, 213));
        btnNewButton_7_1.setBounds(1079, 25, 182, 50);
        contentPane.add(btnNewButton_7_1);
        
        JLabel lblNewLabel_1 = new JLabel("ASSIGNED BOOKINGS");
        lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 21));
        lblNewLabel_1.setBounds(182, 140, 365, 38);
        contentPane.add(lblNewLabel_1);

        try {

        Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "root");
        DefaultTableModel dt= (DefaultTableModel) table.getModel();

        Statement st = (Statement) connection.createStatement();
        String s = "select orderid,userid,customerName,mobile,start,end,slot,eventname,venuename,menuitems,decorpack,phototype,message,totalprice from ORDERS where managerid=?;";
        PreparedStatement ps = connection.prepareStatement(s);
        ps.setInt(1, Employee_Page.managerid);
        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
        dt.addRow(new Object[] { rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getInt(14)});
        }

        }

        catch(Exception e)

        {

            System.out.println(e);

        }
        
        JLabel lblNewLabel_61 = new JLabel("New label");
        Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
   		Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
   		lblNewLabel_61.setIcon(new ImageIcon(newImage11));
   		lblNewLabel_61.setBounds(-20, 11, 357, 113);
        contentPane.add(lblNewLabel_61);
        
        table.setDefaultEditor(Object.class, null);
	}
}
