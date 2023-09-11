		package others;
		
		import java.awt.EventQueue;
		
		import javax.swing.JFrame;
		import javax.swing.JPanel;
		import javax.swing.border.EmptyBorder;

import user.Book_Event;
import user.Calender;
import user.Final;
import user.User_Page;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JRadioButton;
		import javax.swing.JTextArea;
		import javax.swing.JCheckBox;
		import javax.swing.JScrollPane;
		import javax.swing.ScrollPaneConstants;
		import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
		import javax.swing.JButton;
		import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
		
		public class Giveaway extends JFrame {
		
			private JPanel contentPane;
		    public static int gift1=0;
		    public static int gift2=0;
		    public static int gift3=0;
		    public static ArrayList giftitems = new ArrayList<String>();
			/**
			 * Launch the application.
			 */
			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Giveaway frame = new Giveaway();
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
			public Giveaway() {
				User_Page.queue.add("giveaway()");
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
				
				JLabel lblNewLabel = new JLabel("SELECT YOUR GIVEAWAY GIFTS");
				lblNewLabel.setBounds(450, 29, 362, 55);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
				contentPane.add(lblNewLabel);
				
				JRadioButton rdbtnNewRadioButton = new JRadioButton("RETURN GIFTS 100RS EACH");
				rdbtnNewRadioButton.setBounds(108, 163, 200, 49);
				contentPane.add(rdbtnNewRadioButton);
				
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("GIFTS 150RS EACH");
				rdbtnNewRadioButton_1.setBounds(514, 160, 254, 55);
				contentPane.add(rdbtnNewRadioButton_1);
				
				JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("PREMIUM RETURN GIFTS 200 RS EACH");
				rdbtnNewRadioButton_2.setBounds(905, 161, 254, 53);
				contentPane.add(rdbtnNewRadioButton_2);
				
				ButtonGroup G = new ButtonGroup();
				G.add(rdbtnNewRadioButton);
				G.add(rdbtnNewRadioButton_1);
				G.add(rdbtnNewRadioButton_2);
					
				JCheckBox chckbxNewCheckBox = new JCheckBox("Steel Medium sized Tiffen Box");
																			//		contentPane.add(chckbxNewCheckBox_8);
				
				 JPanel s1 = new JPanel();
			        s1.setBounds(71, 200, 254, 199);
			        s1.setLayout(new GridLayout(0, 1, 0, 0));
			        s1.add(chckbxNewCheckBox);
				//contentPane.add(chckbxNewCheckBox);
				
				JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Medium Size Steel Cup");
				s1.add(chckbxNewCheckBox_1);
				//		contentPane.add(chckbxNewCheckBox_2);
						
				JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Chocolates combo");
				s1.add(chckbxNewCheckBox_3);
				//		contentPane.add(chckbxNewCheckBox_4);
						
				JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Water Bottle");
				s1.add(chckbxNewCheckBox_5);
				//		contentPane.add(chckbxNewCheckBox_6);
						
			    JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Coffe Mug");
			    s1.add(chckbxNewCheckBox_7);
				//		contentPane.add(chckbxNewCheckBox_3);
						
				JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Candy Pouch");
				s1.add(chckbxNewCheckBox_4);
				//		contentPane.add(chckbxNewCheckBox_1);
						
				JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Small Clock");
				s1.add(chckbxNewCheckBox_2);
				//		contentPane.add(chckbxNewCheckBox_7);
						
				JCheckBox chckbxNewCheckBox_8 = new JCheckBox("Photo Frames");
				s1.add(chckbxNewCheckBox_8);
			    //		contentPane.add(chckbxNewCheckBox_5);
			    		
				JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Fridge Magnets");
				s1.add(chckbxNewCheckBox_6);
					
			   
				JScrollPane scrollPane = new JScrollPane(s1);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				scrollPane.setBounds(69, 258, 274, 154);
				scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				contentPane.add(scrollPane);
				scrollPane.setVisible(false);
				
				JPanel s2 = new JPanel();
		        s2.setBounds(200, 200, 254, 199);
		        s2.setLayout(new GridLayout(0, 1, 0, 0));
		  
		
			JCheckBox chckbxNewCheckBox_11 = new JCheckBox("Steel Plate Medium Size");
			s2.add(chckbxNewCheckBox_11);
					
			JCheckBox chckbxNewCheckBox_13 = new JCheckBox("Steel Water Bottle");
			s2.add(chckbxNewCheckBox_13);
					
			JCheckBox chckbxNewCheckBox_15 = new JCheckBox("Potrait of god");
			s2.add(chckbxNewCheckBox_15);
			
					
		    JCheckBox chckbxNewCheckBox_17 = new JCheckBox("Random Art Works");
		    s2.add(chckbxNewCheckBox_17);
			
					
			JCheckBox chckbxNewCheckBox_14 = new JCheckBox("Accesseries consisting of silver ring and bracelet");
			s2.add(chckbxNewCheckBox_14);
			
					
			JCheckBox chckbxNewCheckBox_12 = new JCheckBox("Brass Diyas");
			s2.add(chckbxNewCheckBox_12);
					
			JCheckBox chckbxNewCheckBox_18 = new JCheckBox("Dry Fruit Boxes");
			s2.add(chckbxNewCheckBox_18);
			
		  
		    		
			JCheckBox chckbxNewCheckBox_16 = new JCheckBox("Channapatna Toys");
			s2.add(chckbxNewCheckBox_16);
				
		   
			JScrollPane scrollPane1 = new JScrollPane(s2);
			scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane1.setBounds(466, 258, 274, 154);
			scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			contentPane.add(scrollPane1);
			scrollPane1.setVisible(false);
			
			JPanel s3 = new JPanel();
		    s3.setBounds(400, 200, 254, 199);
		    s3.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JCheckBox chckbxNewCheckBox_21 = new JCheckBox("Dolls Of GODS");
		s3.add(chckbxNewCheckBox_21);
				
		JCheckBox chckbxNewCheckBox_23 = new JCheckBox("Brass Dashavathar Idols(Brown Antique Finish)");
		s3.add(chckbxNewCheckBox_23);
				
		JCheckBox chckbxNewCheckBox_25 = new JCheckBox("Hand Painted Wooden Organizer");
		s3.add(chckbxNewCheckBox_25);
		
				
		JCheckBox chckbxNewCheckBox_27 = new JCheckBox("Tree Wall Hanging");
		s3.add(chckbxNewCheckBox_27);
		
				
		JCheckBox chckbxNewCheckBox_24 = new JCheckBox("Silver Kuthu Velaku");
		s3.add(chckbxNewCheckBox_24);
		
				
		JCheckBox chckbxNewCheckBox_22 = new JCheckBox("Gold Oxidised Dabba");
		s3.add(chckbxNewCheckBox_22);
				
		JCheckBox chckbxNewCheckBox_28 = new JCheckBox("German Silver Pooja Thali Set");
		s3.add(chckbxNewCheckBox_28);
		
		
				
		JCheckBox chckbxNewCheckBox_26 = new JCheckBox("Chowkidar showpieces");
		s3.add(chckbxNewCheckBox_26);
			
		
		JScrollPane scrollPane2 = new JScrollPane(s3);
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(885, 258, 274, 154);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane2);
		scrollPane2.setVisible(false);
		
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            scrollPane.setVisible(true);
		            scrollPane1.setVisible(false);
		            scrollPane2.setVisible(false);

		        }
		    });
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            scrollPane1.setVisible(true);
	            scrollPane.setVisible(false);
	            scrollPane2.setVisible(false);

	        }
	    });
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            scrollPane2.setVisible(true);
	            scrollPane.setVisible(false);
	            scrollPane1.setVisible(false);

	        }
	    });
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = s1.getComponentCount();
				int index = 0;
				while (index < num)
				{
					if(((AbstractButton) s1.getComponent(index)).isSelected())
					{
						Object k = s1.getComponent(index);
						giftitems.add(((javax.swing.AbstractButton)k).getText());
						gift1+=1;
						
						
	
					}
					index+=1;
				}
				int num1 = s2.getComponentCount();
				int index1= 0;
				while (index1 < num1)
				{
					if(((AbstractButton) s2.getComponent(index1)).isSelected())
					{
						Object k = s2.getComponent(index1);
						giftitems.add(((javax.swing.AbstractButton)k).getText());
						gift2+=1;
	
					}
					index1+=1;
				}
				int num2 = s3.getComponentCount();
				int index2= 0;
				while (index2 < num2)
				{
					if(((AbstractButton) s3.getComponent(index2)).isSelected())
					{
						Object k = s3.getComponent(index2);
						giftitems.add(((javax.swing.AbstractButton)k).getText());
						gift3+=1;
						
	
					}
					System.out.println(giftitems);
					index2+=1;
				}
				if (Book_Event.whatevent.equals("wedding"))
				{
					setVisible(false);
					new Car_rental().setVisible(true);
				}
				else
				{
					setVisible(false);
					new Message().setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(1029, 485, 89, 23);
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
		btnNewButton_4.setBounds(874, 29, 150, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7_1 = new JButton("BACK");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Photo().setVisible(true);
			}
		});
		btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
		btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
		btnNewButton_7_1.setBackground(new Color(251, 234, 213));
		btnNewButton_7_1.setBounds(1060, 29, 182, 50);
		contentPane.add(btnNewButton_7_1);
		
		if (Calender.budget1 == 500000)
		{
			//scrollPanea.setVisible(true);
			rdbtnNewRadioButton.setVisible(true);
			
			
		}
		else if (Calender.budget1 == 700000)
		{
//			scrollPanea.setVisible(true);
//			scrollPaneb.setVisible(true);
			rdbtnNewRadioButton.setVisible(true);
		
		
		}

		else if (Calender.budget1 == 1000000)
		{
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			
		}
		else if (Calender.budget1 == 1500000 && Book_Event.whatevent.equals("wedding"))
		{
			rdbtnNewRadioButton.setVisible(true);
		}
		else if (Calender.budget1 == 1500000)
		{
			
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			rdbtnNewRadioButton_2.setVisible(true);
			
	
			
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
			rdbtnNewRadioButton_2.setVisible(true);
			
			
		}
		else if (Calender.budget1 == 3000000 && Book_Event.whatevent.equals("wedding"))
		{
			
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
		}
		else if (Calender.budget1 == 3000000)
		{
            
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			rdbtnNewRadioButton_2.setVisible(true);
			
			
			
		}
		else
		{
			
			rdbtnNewRadioButton.setVisible(true);
			rdbtnNewRadioButton_1.setVisible(true);
			rdbtnNewRadioButton_2.setVisible(true);
			
			
		}
		 JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img1 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
		} 
			
			}
		
		
