package others;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import food.menu;
import user.Book_Event;
import user.Calender;
import user.Final;
import user.User_Page;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Photo extends JFrame {

	private JPanel contentPane;
    public static int phototype;
    public static String photoname;
    public static boolean drone=false;
    public static boolean photobooth=false;
    public static int kg = 0;
    public static String flavour;
    
    public static boolean pre_event=false;
    private JTextField textField;
    private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Photo frame = new Photo();
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
	public Photo() {
			User_Page.queue.add("Photo()");
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
		
		JLabel lblNewLabel = new JLabel("PHOTOGRAPHY");
		lblNewLabel.setBounds(554, 69, 168, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Only Photos");
		rdbtnNewRadioButton.setBounds(742, 127, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Photos and Vedios");
		rdbtnNewRadioButton_1.setBounds(742, 153, 155, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Check for Pre-event shoots");
		chckbxNewCheckBox.setBounds(742, 180, 212, 23);
		contentPane.add(chckbxNewCheckBox);
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Check for Drone Shoots");
		chckbxNewCheckBox_1.setBounds(742, 214, 155, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Check for Photo Booths");
		chckbxNewCheckBox_2.setBounds(743, 250, 154, 23);
		contentPane.add(chckbxNewCheckBox_2);
		JLabel lblNewLabel_4 = new JLabel("REQUIRED QUANTITY (KG)");
		lblNewLabel_4.setBounds(747, 447, 182, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(939, 444, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DESIRED FLAVOUR");
		lblNewLabel_5.setBounds(743, 523, 141, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(939, 520, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected())
				{
					phototype = 1;
					photoname = "Only Photos";
				}
				else if (rdbtnNewRadioButton_1.isSelected())
				{
					phototype = 2;
					photoname = "Photos&Vedios";
				}
				if (chckbxNewCheckBox.isSelected())
				{
					pre_event = true;
				}
				if (chckbxNewCheckBox_1.isSelected())
				{
					drone = true;
				}
				if (chckbxNewCheckBox_2.isSelected())
				{
				    photobooth = true;
				}
				String kg1 =  textField.getText();
				if (!kg1.equals(""))
				{
					kg = Integer.parseInt(kg1);
				}
				flavour = textField_1.getText();
				setVisible(false);
				new Giveaway().setVisible(true);
				
			}
		});
		btnNewButton.setBounds(1058, 340, 120, 23);
		contentPane.add(btnNewButton);
		
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(328, 111, 371, 199);
		Image img = new ImageIcon(this.getClass().getResource("/photo.jpg")).getImage(); //just drag and drop from computer
		Image newImage = img.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_1.setIcon(new ImageIcon(newImage));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CAKE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(594, 338, 111, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(328, 393, 371, 239);
		Image img1 = new ImageIcon(this.getClass().getResource("/cake.jpeg")).getImage(); //just drag and drop from computer
		Image newImage1 = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_3.setIcon(new ImageIcon(newImage1));
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_3);
		
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
		btnNewButton_4.setBounds(810, 11, 150, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Music_dj().setVisible(true);
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(996, 11, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		rdbtnNewRadioButton.setVisible(false);
		rdbtnNewRadioButton_1.setVisible(false);
		chckbxNewCheckBox.setVisible(false);
		chckbxNewCheckBox_1.setVisible(false);
		chckbxNewCheckBox_2.setVisible(false);
		
		if (Calender.budget1 == 500000)
		{
			//scrollPanea.setVisible(true);
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(false);
			chckbxNewCheckBox.setVisible(false);
			chckbxNewCheckBox_1.setVisible(false);
			chckbxNewCheckBox_2.setVisible(false);
		}
		else if (Calender.budget1 == 700000)
		{
//			scrollPanea.setVisible(true);
//			scrollPaneb.setVisible(true);
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			chckbxNewCheckBox.setVisible(false);
			chckbxNewCheckBox_1.setVisible(false);
			chckbxNewCheckBox_2.setVisible(false);
		}

		else if (Calender.budget1 == 1000000)
		{
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			chckbxNewCheckBox.setVisible(true);
		}
		else if (Calender.budget1 == 1500000 && Book_Event.whatevent.equals("wedding"))
		{
			rdbtnNewRadioButton.setVisible(true);
		}
		else if (Calender.budget1 == 1500000)
		{
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			chckbxNewCheckBox.setVisible(true);
			chckbxNewCheckBox_1.setVisible(true);
		}
		else if (Calender.budget1 == 2000000 && Book_Event.whatevent.equals("wedding"))
		{
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
		}
		
		else if (Calender.budget1 == 2000000)
		{
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			chckbxNewCheckBox.setVisible(true);
			chckbxNewCheckBox_1.setVisible(true);
			chckbxNewCheckBox_2.setVisible(true);
		}
		else if (Calender.budget1 == 3000000 && Book_Event.whatevent.equals("wedding"))
		{
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			chckbxNewCheckBox.setVisible(true);
			chckbxNewCheckBox_1.setVisible(true);
		}
		else if (Calender.budget1 == 3000000)
		{
            
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			chckbxNewCheckBox.setVisible(true);
			chckbxNewCheckBox_1.setVisible(true);
			chckbxNewCheckBox_2.setVisible(true);
			
		}
		else
		{
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			chckbxNewCheckBox.setVisible(true);
			chckbxNewCheckBox_1.setVisible(true);
			chckbxNewCheckBox_2.setVisible(true);
		}
//        scrollPane1.setV
		
		JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
		
		
		
	} 
}
