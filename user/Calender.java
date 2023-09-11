
package user;
import hall.*;
import others.Decor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
import com.toedter.calendar.JDayChooser;

import food.menu;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;  
public class Calender extends JFrame {

	private JPanel contentPane;
	public static String type;
	private JTextField textField;
	static String strDate;
	static String strDate1;
	public static String slot;
	public static int numberofguests;
	public static int budget1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calender frame = new Calender(type);
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
	public Calender(String type) {
		User_Page.queue.add("Calender()");
		this.type = type;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 728);
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
		
		Date from;
		Date to;
		String slot = null;
		
		JLabel lblNewLabel_1 = new JLabel("Number Of Guests Expected");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(75, 465, 317, 23);
		contentPane.add(lblNewLabel_1);
		//lblNewLabel_1.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(73, 539, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		//textField.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("What is the Date of Your "+type);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(65, 84, 327, 40);
		contentPane.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(57, 198, 259, 47);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(431, 198, 240, 47);
		contentPane.add(dateChooser1);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Book For full day 12AM TO 11 PM");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setBounds(35, 353, 235, 23);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setVisible(false);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Morning Slot 6 AM TO 12 PM");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setBounds(298, 353, 216, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setVisible(false);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Evening Slot 4 PM TO 11 PM");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2.setBounds(536, 353, 208, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setVisible(false);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	             Calender.slot = null;

	        }
	    });
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	             Calender.slot = "morning";

	        }
	    });
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	             Calender.slot = "evening";

	        }
	    });
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		G.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
				Date from= dateChooser.getDate();
				Date to = dateChooser1.getDate(); 
				System.out.println(from);
//				strDate = DateFormat.getDateInstance().format(from);
//				strDate1 = DateFormat.getDateInstance().format(to);
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    strDate = formatter.format(from);  
				System.out.println(strDate);
				
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");  
				strDate1 = formatter1.format(to);  
				System.out.println(strDate1);
				
				
				if (date.compareTo(from) > 0)
					JOptionPane.showMessageDialog(btnNewButton, "Please Choose a date After Current Date");
				
				if (from.compareTo(to) > 0)
					JOptionPane.showMessageDialog(btnNewButton, "Please Choose TO date correctly");
				
//				Date compare1 = new Date(from.getYear(), from.getMonth(), from.getDay());
//				Date compare2 = new Date(to.getYear(), to.getMonth(), to.getDay()); 
				
				//System.out.println("hi"+compare1.compareTo(compare2));

				if(strDate.compareTo(strDate1) == 0){

					rdbtnNewRadioButton.setVisible(true);
					rdbtnNewRadioButton_1.setVisible(true);
					rdbtnNewRadioButton_2.setVisible(true);
					
					lblNewLabel_1.setVisible(true);
					textField.setVisible(true);
					btnNewButton_1.setVisible(true);			
				}
				else
				{
					
					lblNewLabel_1.setVisible(true);
					textField.setVisible(true);
					btnNewButton_1.setVisible(true);
					
				}
				
				
				
				//JOptionPane.showMessageDialog(btnNewButton, date);
				
				
				
			}
		});
		btnNewButton.setBounds(314, 295, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("From");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(57, 164, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(431, 164, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BUDGET OPTIONS");
		lblNewLabel_4.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblNewLabel_4.setBounds(877, 146, 179, 23);
		contentPane.add(lblNewLabel_4);
		
		String Budget[]={"NIL","<500000","<700000","<1000000","<1500000","<2000000","<3000000"};    
		
		JComboBox comboBox = new JComboBox(Budget);
		comboBox.setBounds(877, 183, 185, 61);
		contentPane.add(comboBox);
		
		
		btnNewButton_1 = new JButton("NEXT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberofguests = Integer.parseInt(textField.getText());
				
				int budget2 = comboBox.getSelectedIndex();
				if (budget2 == 1)
				{
					budget1 = 500000;
				}
				else if (budget2 == 2)
				{
					budget1 = 700000;
				}
				else if (budget2 == 3)
				{
					budget1 = 1000000;
				}
				else if (budget2 == 4)
				{
					budget1 = 1500000;
				}
				else if (budget2 == 5)
				{
					budget1 = 2000000;
				}
				else if (budget2 == 6)
				{
					budget1 = 3000000;
				}
				if (budget1 == 0)
				{
					if (Book_Event.whatevent.equals("catering"))
					{
						setVisible(false);
						new menu().setVisible(true);
					}
					else if (Book_Event.whatevent.equals("stagesetup") || Book_Event.whatevent.equals("festival"))
					{
						setVisible(false);
						new Decor().setVisible(true);
					}
					else if (Book_Event.whatevent.equals("others"))
					{
						int option = JOptionPane.showConfirmDialog(btnNewButton_1, "Do You want to Choose a venue?");
						if (option == 0)
						{
							setVisible(false);
							new Venue(strDate,strDate1,Calender.slot).setVisible(true);
						}
						else if (option == 1)
						{
							Book_Event.venue = JOptionPane.showInputDialog("Enter the Name and location of Venue");
							setVisible(false);
							new menu().setVisible(true);
						}

					}
					else
					{
					setVisible(false);
					new Venue(strDate,strDate1,Calender.slot).setVisible(true);
					}
				}
				else if (Book_Event.whatevent.equals("wedding"))
				{
					if (budget1 < 1500000)
						JOptionPane.showMessageDialog(btnNewButton_1, "This budget is not applicable for wedding");
					
					
					else
					{
							setVisible(false);
						new Venue(strDate,strDate1,Calender.slot).setVisible(true);
					}
					
					
				}
				else if (budget1 < 1500000 && Calender.slot==null)
				{
					JOptionPane.showMessageDialog(btnNewButton_1,"This Budget is applicable only for slots");
				}
				
				else
				{
					if (Book_Event.whatevent.equals("stagesetup") || Book_Event.whatevent.equals("festival"))
					{
						setVisible(false);
						new Decor().setVisible(true);
					}
					else if (Book_Event.whatevent.equals("catering"))
					{
						setVisible(false);
						new menu().setVisible(true);
					}
					else
					{
						setVisible(false);
						new Venue(strDate,strDate1,Calender.slot).setVisible(true);
					}
				}
				System.out.println(budget1);
			
			}
		});
		btnNewButton_1.setBounds(234, 538, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Book_Event().setVisible(true);
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1063, 31, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
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
		btnNewButton_4.setBounds(877, 31, 150, 50);
		contentPane.add(btnNewButton_4);
		btnNewButton_1.setVisible(false);
		
	}
}
