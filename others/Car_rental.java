package others;

import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import user.*;
import java.awt.Color;
public class Car_rental extends JFrame {

	private JPanel contentPane;
	public static int carid=0;
	public static String carname=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Car_rental frame = new Car_rental();
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
	public Car_rental() {
		User_Page.queue.add("car_rental()");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 703);
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
		
		
		JLabel lblNewLabel = new JLabel("CAR RENTAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(564, 66, 137, 25);
		contentPane.add(lblNewLabel);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mercedes Benz");
		rdbtnNewRadioButton.setBounds(132, 324, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("JAGUAR\r\n");
		rdbtnNewRadioButton_1.setBounds(564, 324, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Audi");
		rdbtnNewRadioButton_3.setBounds(1008, 324, 111, 23);
		contentPane.add(rdbtnNewRadioButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(24, 118, 360, 181);
		Image img = new ImageIcon(this.getClass().getResource("/benz.jpg")).getImage(); //just drag and drop from computer
		Image newImage = img.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_1.setIcon(new ImageIcon(newImage));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(437, 118, 360, 181);
		Image img1 = new ImageIcon(this.getClass().getResource("/jaguar.jpg")).getImage(); //just drag and drop from computer
		Image newImage1 = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_2.setIcon(new ImageIcon(newImage1));
		contentPane.add(lblNewLabel_2);
		Image img2 = new ImageIcon(this.getClass().getResource("/benz.jpg")).getImage(); //just drag and drop from computer
		Image newImage2 = img2.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(874, 118, 360, 181);
		Image img3 = new ImageIcon(this.getClass().getResource("/audi.jpg")).getImage(); //just drag and drop from computer
		Image newImage3 = img3.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_4.setIcon(new ImageIcon(newImage3));
		contentPane.add(lblNewLabel_4);
	
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(24, 370, 360, 181);
		Image img4 = new ImageIcon(this.getClass().getResource("/minicooper.jpg")).getImage(); //just drag and drop from computer
		Image newImage4 = img4.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_5.setIcon(new ImageIcon(newImage4));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(437, 370, 360, 181);
		Image img5 = new ImageIcon(this.getClass().getResource("/ferari.jpg")).getImage(); //just drag and drop from computer
		Image newImage5 = img5.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_6.setIcon(new ImageIcon(newImage5));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(874, 370, 360, 181);
		Image img6 = new ImageIcon(this.getClass().getResource("/rolls.jpg")).getImage(); //just drag and drop from computer
		Image newImage6 = img6.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_7.setIcon(new ImageIcon(newImage6));
		contentPane.add(lblNewLabel_7);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Mini Cooper");
		rdbtnNewRadioButton_4.setBounds(146, 571, 111, 23);
		contentPane.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Ferari");
		rdbtnNewRadioButton_5.setBounds(564, 571, 111, 23);
		contentPane.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Rolls Royce");
		rdbtnNewRadioButton_6.setBounds(998, 571, 111, 23);
		contentPane.add(rdbtnNewRadioButton_6);
		
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		G.add(rdbtnNewRadioButton_3);
		G.add(rdbtnNewRadioButton_4);
		G.add(rdbtnNewRadioButton_5);
		G.add(rdbtnNewRadioButton_6);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (rdbtnNewRadioButton.isSelected())
				{
					carid = 1;
					carname = "Mercedez benz";
				}
			    else if (rdbtnNewRadioButton_1.isSelected())
				{
					carid = 2;
					carname = "Jaguar";
					
				}
			    else if (rdbtnNewRadioButton_3.isSelected())
				{
					carid = 3;
					carname = "Audi";
				}
			    else if (rdbtnNewRadioButton_4.isSelected())
				{
					carid = 4;
					carname = "Mini Cooper";
				}
			    else if (rdbtnNewRadioButton_5.isSelected())
				{
					carid = 5;
					carname = "Ferari";
				}
			    else if (rdbtnNewRadioButton_6.isSelected())
				{
					carid = 6;
					carname = "Rolls Royce";
				}
			    setVisible(false);
			    new Message().setVisible(true);
			}
		});
		btnNewButton.setBounds(520, 618, 89, 23);
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
		btnNewButton_4.setBounds(866, 22, 150, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Giveaway().setVisible(true);
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1052, 22, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		 JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-19, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
	
	} 
}
