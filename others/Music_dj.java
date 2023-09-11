package others;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Music_dj extends JFrame {

	private JPanel contentPane;
	public static String musictype=null;
	
	
	public static ArrayList musicprefer = new ArrayList<String>();
	public static ArrayList musiclang = new ArrayList<String>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Music_dj frame = new Music_dj();
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
	public Music_dj() {
		User_Page.queue.add("music_dj()");
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
		
		JLabel lblNewLabel = new JLabel("MUSIC AND DJ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(537, 78, 166, 30);
		contentPane.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Live Music Band");
		rdbtnNewRadioButton.setBounds(155, 148, 158, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("DJ");
		rdbtnNewRadioButton_1.setBounds(940, 148, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		
		 JPanel s1 = new JPanel();
	        s1.setBounds(71, 200, 254, 199);
	        s1.setLayout(new GridLayout(0, 1, 0, 0));
		//contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Acoustic/Covers");
		s1.add(chckbxNewCheckBox_1);
		//		contentPane.add(chckbxNewCheckBox_2);
				
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("CLassical");
		s1.add(chckbxNewCheckBox_3);
		//		contentPane.add(chckbxNewCheckBox_4);
				
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("Film Music");
		s1.add(chckbxNewCheckBox_5);
		//		contentPane.add(chckbxNewCheckBox_6);
				
	    JCheckBox chckbxNewCheckBox_7 = new JCheckBox("Folk Music");
	    s1.add(chckbxNewCheckBox_7);
		//		contentPane.add(chckbxNewCheckBox_3);
				
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Indian Pop Music");
		s1.add(chckbxNewCheckBox_4);
		//		contentPane.add(chckbxNewCheckBox_1);
				
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Instrumental");
		s1.add(chckbxNewCheckBox_2);
		//		contentPane.add(chckbxNewCheckBox_7);
				
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("Jazz");
		s1.add(chckbxNewCheckBox_8);
	    //		contentPane.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_9= new JCheckBox("Melody");
		s1.add(chckbxNewCheckBox_9);
	    //		contentPane.add(chckbxNewCheckBox_5);
	    	
		JCheckBox chckbxNewCheckBox_10= new JCheckBox("Romantic");
		s1.add(chckbxNewCheckBox_10);
	    		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("Relegious Music");
		s1.add(chckbxNewCheckBox_6);
			
	   
		JScrollPane scrollPane = new JScrollPane(s1);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(201, 477, 274, 154);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		JPanel s2 = new JPanel();
        s2.setBounds(200, 200, 254, 199);
        s2.setLayout(new GridLayout(0, 1, 0, 0));
  

	JCheckBox chckbxNewCheckBox_11 = new JCheckBox("Tamil");
	s2.add(chckbxNewCheckBox_11);
			
	JCheckBox chckbxNewCheckBox_13 = new JCheckBox("English");
	s2.add(chckbxNewCheckBox_13);
			
	JCheckBox chckbxNewCheckBox_15 = new JCheckBox("Hindi");
	s2.add(chckbxNewCheckBox_15);
	
			
    JCheckBox chckbxNewCheckBox_17 = new JCheckBox("Kannada");
    s2.add(chckbxNewCheckBox_17);
	
			
	JCheckBox chckbxNewCheckBox_14 = new JCheckBox("Malayalam");
	s2.add(chckbxNewCheckBox_14);
	
			
	JCheckBox chckbxNewCheckBox_12 = new JCheckBox("Bengali");
	s2.add(chckbxNewCheckBox_12);
			
	JCheckBox chckbxNewCheckBox_18 = new JCheckBox("Telugu");
	s2.add(chckbxNewCheckBox_18);
	
  
    		
	JCheckBox chckbxNewCheckBox_16 = new JCheckBox("Punjabi");
	s2.add(chckbxNewCheckBox_16);
		
   
	JScrollPane scrollPane1 = new JScrollPane(s2);
	scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPane1.setBounds(647, 477, 274, 154);
	scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	contentPane.add(scrollPane1);
	
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setBounds(50, 193, 375, 195);
	Image img = new ImageIcon(this.getClass().getResource("/livemusic.jpg")).getImage();
	Image newImage = img.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
	lblNewLabel_1.setIcon(new ImageIcon(newImage));
	contentPane.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("");
	lblNewLabel_2.setBounds(797, 193, 375, 195);
	Image img1 = new ImageIcon(this.getClass().getResource("/dj.jpg")).getImage();
	Image newImage1 = img1.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
	lblNewLabel_2.setIcon(new ImageIcon(newImage1));
	contentPane.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("WHAT TYPE OF MUSIC DO YOU PREFER");
	lblNewLabel_3.setBounds(239, 441, 255, 14);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("CHOOSE LANGUAGES FOR MUSIC");
	lblNewLabel_4.setBounds(690, 441, 174, 14);
	contentPane.add(lblNewLabel_4);
	
	JButton btnNewButton = new JButton("SUBMIT");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int count1 = 0;
			int count2 = 0;
			if (Calender.budget1 == 500000)
			{
				count1=1;
				count2=1;
				//scrollPanea.setVisible(true);
			}
			else if (Calender.budget1 == 700000)
			{
//				scrollPanea.setVisible(true);
//				scrollPaneb.setVisible(true);
				count1=2;
				count2=2;
				
			}

			else if (Calender.budget1 == 1000000)
			{
				count1=3;
				count2=3;
			}
			else if (Calender.budget1 == 1500000 && Book_Event.whatevent.equals("wedding"))
			{
				count1=1;
				count2=1;
			}
			else if (Calender.budget1 == 1500000)
			{
				count1=4;
				count2=4;
			}
			else if (Calender.budget1 == 2000000 && Book_Event.whatevent.equals("wedding"))
			{
				count1=2;
				count2=2;
			}
			
			else if (Calender.budget1 == 2000000)
			{
				count1=5;
				count2=5;
			}
			else if (Calender.budget1 == 3000000 && Book_Event.whatevent.equals("wedding"))
			{
				count1=3;
				count2=3;
			}
			else if (Calender.budget1 == 3000000)
			{
	            
				
				count1=6;
				count2=6;
			}
			else
			{
				count1=2;
				count2=2;
			}
			if (rdbtnNewRadioButton.isSelected())
			{
				musictype="live";
			}
			if (rdbtnNewRadioButton_1.isSelected())
			{
				musictype="dj";
			}
			if (chckbxNewCheckBox_1.isSelected())
			{
				musicprefer.add("covers");
			}
			if(chckbxNewCheckBox_2.isSelected())
			{
				musicprefer.add("instrumental");
			}
			if(chckbxNewCheckBox_3.isSelected())
			{
				musicprefer.add("classical");
			}
			if(chckbxNewCheckBox_4.isSelected())
			{
				musicprefer.add("pop");
			}
			if(chckbxNewCheckBox_5.isSelected())
			{
				musicprefer.add("film");
			}
			if(chckbxNewCheckBox_6.isSelected())
			{
				musicprefer.add("jazz");
			}
			if(chckbxNewCheckBox_7.isSelected())
			{
				musicprefer.add("folk");
			}
			if(chckbxNewCheckBox_8.isSelected())
			{
				musicprefer.add("jazz");
			}
			if(chckbxNewCheckBox_9.isSelected())
			{
				musicprefer.add("melody");
			}
			if(chckbxNewCheckBox_10.isSelected())
			{
				musicprefer.add("romantic");
			}
			if (chckbxNewCheckBox_11.isSelected())
			{
				musiclang.add("tamil");
			}
			if (chckbxNewCheckBox_12.isSelected())
			{
				musiclang.add("bengali");
			}
			if (chckbxNewCheckBox_13.isSelected())
			{
				musiclang.add("hindi");
			}
			if (chckbxNewCheckBox_14.isSelected())
			{
				musiclang.add("malayali");
			}
			if (chckbxNewCheckBox_15.isSelected())
			{
				musiclang.add("english");
			}
			if (chckbxNewCheckBox_16.isSelected())
			{
				musiclang.add("punjabi");
			}
			if (chckbxNewCheckBox_17.isSelected())
			{
				musiclang.add("kannada");
			}
			if (chckbxNewCheckBox_18.isSelected())
			{
				musiclang.add("punjabi");
			}
 
			System.out.println("0"+musicprefer);
			if (musicprefer.size() >count1 )
			{
			    System.out.println("1"+musicprefer.size()+" "+count1);
				JOptionPane.showMessageDialog(btnNewButton, "Your Selection List has exceeded the Limit.");
				musicprefer.clear();
				musiclang.clear();
				System.out.println("2"+""+musicprefer);
			}
			
			else if (musiclang.size() >count2 )
			{
				JOptionPane.showMessageDialog(btnNewButton, "Your Selection List has exceeded the Limit1.");
				musicprefer.clear();
				musiclang.clear();
			}
			else
			{
				setVisible(false);
				new Photo().setVisible(true);
			}
		}
			
	});
	btnNewButton.setBounds(1060, 518, 89, 23);
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
	btnNewButton_4.setBounds(857, 32, 150, 50);
	contentPane.add(btnNewButton_4);
	
	JButton btnNewButton_7_1 = new JButton("BACK");
	btnNewButton_7_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new Decor().setVisible(true);
		}
	});
	btnNewButton_7_1.setIcon(new ImageIcon("C:\\Users\\monisha.dr\\Downloads\\Pictogrammers-Material-Light-Logout.48.png"));
	btnNewButton_7_1.setFont(new Font("Monospaced", Font.BOLD, 16));
	btnNewButton_7_1.setBackground(new Color(251, 234, 213));
	btnNewButton_7_1.setBounds(1043, 32, 182, 50);
	contentPane.add(btnNewButton_7_1);
	
	 JLabel lblNewLabel_61 = new JLabel("New label");
     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
		Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_61.setIcon(new ImageIcon(newImage11));
		lblNewLabel_61.setBounds(-20, 11, 357, 113);
     contentPane.add(lblNewLabel_61);
	

	} 
}
