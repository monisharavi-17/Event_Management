package admin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1292, 695);
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
		
		JLabel lblNewLabel = new JLabel("WELCOME ADMIN");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblNewLabel.setBounds(363, 150, 256, 47);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("VIEW USERS");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Oxygen-Icons.org-Oxygen-Actions-view-media-artist.48.png"));
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ViewUsers().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(114, 237, 262, 104);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VIEW ORDERS");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Oxygen-Icons.org-Oxygen-Actions-view-list-details.48.png"));
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new View_Orders().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(547, 240, 262, 98);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ALTER PRICES");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Icons8-Ios7-Ecommerce-Price-Tag.48.png"));
		btnNewButton_2.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Alter_Prices().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(541, 450, 273, 104);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<html>ADD/VIEW <br> EMPLOYEE </html>");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Iconoir-Team-Iconoir-Add-user.48.png"));
		btnNewButton_3.setFont(new Font("Monospaced", Font.BOLD, 24));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Add_View_Employee().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(114, 450, 262, 104);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
	     
	     JButton btnNewButton_2_1 = new JButton("LOGOUT");
	     btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
	     btnNewButton_2_1.setFont(new Font("Monospaced", Font.BOLD, 19));
	     btnNewButton_2_1.setBounds(913, 29, 233, 41);
	     contentPane.add(btnNewButton_2_1);
	}
}
