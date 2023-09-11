package user;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		User_Page.queue.add("Payment");
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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAYMENT");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel.setBounds(270, 94, 172, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\MicrosoftTeams-image (4).png"));
		lblNewLabel_1.setBounds(45, 146, 547, 438);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("DONE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(btnNewButton, "Thank You! Your Order Details are saved. You can Pay later in your profile settings");
				}
				else
				{
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
					    String sk = "update orders set paymentstatus = ? where orderid = ?;";
					    java.sql.PreparedStatement ps = conn.prepareStatement(sk);
					    ps.setString(1, textField.getText());
					    ps.setInt(2, Confirm_Order.orderid);
					    ps.executeUpdate();
					    
					    JOptionPane.showMessageDialog(btnNewButton, "Thank You! Your Payment will be verified and you will receive response soon");
					
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(1030, 327, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER REFERENCE ID AFTER PAYMENT");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblNewLabel_2.setBounds(613, 279, 355, 37);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(613, 368, 319, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		btnNewButton_4.setBounds(865, 40, 150, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Final().setVisible(true);
		
			    
				
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1051, 40, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		JLabel lblNewLabel_3 = new JLabel("PLEASE PAY A MINIMUM ADVANCE OF ABOUT 5 % FOR BOOKING TO BE PROCESSED");
		lblNewLabel_3.setBounds(108, 125, 573, 14);
		contentPane.add(lblNewLabel_3);
	}
}
