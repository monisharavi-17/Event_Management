package employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import user.User_Page;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Employee_Page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
	
	public static int managerid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_Page frame = new Employee_Page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Employee_Page() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 700);
		setExtendedState(MAXIMIZED_BOTH);
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
		

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
		Statement st = conn.createStatement();
		 setExtendedState(MAXIMIZED_BOTH);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO EMPLOYEE SECTION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(478, 101, 368, 23);
		contentPane.add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setBounds(923, 240, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(923, 357, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(661, 241, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(661, 335, 103, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("LOGIN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int empid = Integer.parseInt(textField_3.getText());
				System.out.println(empid);
				String uname = textField.getText();
				String pwd = passwordField.getText();
				System.out.println(uname+pwd+"hi");
				int flag = 0;
				ResultSet s1;
				try {
					s1 = st.executeQuery("select emp_id,username,password from employee_details");
					String name = "";
					System.out.println("yes");
					while (s1.next())
					{
						if (s1.getInt(1)==empid && s1.getString(2).equals(uname) && s1.getString(3).equals(pwd))
						{
							flag = 1;
							
							managerid = s1.getInt(1);
							
						}
					}
					if (flag == 1)
					{
						JOptionPane.showMessageDialog(btnNewButton_2, "LOGIN SUCCESSFULL");
						setVisible(false);
						new Assing().setVisible(true);
						
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton_2, "INVALID USERNAME OR PASSWORD");
					}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(741, 495, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOGON");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int empid = Integer.parseInt(textField_3.getText());
				String code = (textField_2.getText());
				String uname = textField_1.getText();
				String password = passwordField_1.getText();
				int flag = 0;
				ResultSet s1;
				try {
					s1 = st.executeQuery("select emp_id,code from employee_details");
				   
					while (s1.next())
					{
						int a = Integer.parseInt(s1.getString(1));
						String b = s1.getString(2);
						if (a==empid && b.equals(code));
						{
							flag = 1;
							
//							username = uname;
//							email = s1.getString(4);
						}
					}
					if (flag == 1)
					{
						JOptionPane.showMessageDialog(btnNewButton_3, "LOGIN SUCCESSFULL");
						
						String s3 = "Update employee_details set username = ?, password = ? where emp_id = ?";
						PreparedStatement ps = conn.prepareStatement(s3);
						ps.setString(1, uname);
						ps.setString(2, password);
						ps.setInt(3, empid);
						ps.executeUpdate();
						setVisible(false);
						new Employee_Page().setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(btnNewButton_3, "INVALID CREDENTIALS");
					}
				}
					catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNewButton_3.setBounds(741, 547, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("ENTER CODE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(661, 277, 123, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(923, 277, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("NEW USERNAME");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(661, 357, 155, 14);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(923, 326, 96, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("CREATE PASSWORD");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(659, 434, 187, 14);
		contentPane.add(lblNewLabel_5);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(923, 434, 93, 20);
		contentPane.add(passwordField_1);
		JLabel lblNewLabel_6 = new JLabel("ENTER EMPLOYEE ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_6.setBounds(661, 199, 187, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(923, 199, 96, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField.setVisible(false);
		passwordField_1.setVisible(false);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		textField_3.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_3.setVisible(false);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_5.setVisible(false);
		lblNewLabel_6.setVisible(false);
		btnNewButton_2.setVisible(false);
		btnNewButton_3.setVisible(false);
		
		
	JButton btnNewButton = new JButton("LOGIN");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			passwordField.setVisible(true);
			passwordField_1.setVisible(false);
			textField.setVisible(true);
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			textField_3.setVisible(true);
			lblNewLabel_1.setVisible(true);
			lblNewLabel_2.setVisible(true);
			lblNewLabel_3.setVisible(false);
			lblNewLabel_4.setVisible(false);
			lblNewLabel_5.setVisible(false);
			lblNewLabel_6.setVisible(true);
			btnNewButton_2.setVisible(true);
			btnNewButton_3.setVisible(false);
			
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 19));
	btnNewButton.setBounds(194, 238, 166, 53);
	contentPane.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("SIGNUP");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			passwordField.setVisible(false);
			passwordField_1.setVisible(true);
			textField.setVisible(false);
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			textField_3.setVisible(true);
			lblNewLabel_1.setVisible(false);
			lblNewLabel_2.setVisible(false);
			lblNewLabel_3.setVisible(true);
			lblNewLabel_4.setVisible(true);
			lblNewLabel_5.setVisible(true);
			lblNewLabel_6.setVisible(true);
			
			btnNewButton_2.setVisible(false);
			btnNewButton_3.setVisible(true);
			
		
			
		}
	});
	btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
	btnNewButton_1.setBounds(194, 410, 166, 62);
	contentPane.add(btnNewButton_1);
	
	JLabel lblNewLabel_61 = new JLabel("New label");
    Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
		Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
		lblNewLabel_61.setIcon(new ImageIcon(newImage11));
		lblNewLabel_61.setBounds(-20, 11, 357, 113);
    contentPane.add(lblNewLabel_61);
	

}	
}
