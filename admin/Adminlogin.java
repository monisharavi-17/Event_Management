package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static String secretKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlogin frame = new Adminlogin();
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
	public Adminlogin() {
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
		 setExtendedState(MAXIMIZED_BOTH);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 25));
		lblNewLabel.setBounds(187, 159, 266, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER USERNAME");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setBounds(47, 239, 190, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER PASSWORD");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_2.setBounds(47, 321, 178, 23);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(418, 240, 139, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(418, 322, 139, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("GET KEY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = textField_1.getText();
				if (username.equals("admin") && password.equals("root"))
				{
					secretKey = Authenticator.generateSecretKey();
					System.out.println(secretKey);
					JOptionPane.showMessageDialog(btnNewButton,secretKey);

					//String secretKey = "k1";
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Invalid Username or Password");
				}
			}
		});
		btnNewButton.setBounds(653, 321, 106, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		JLabel lblNewLabel_2_1 = new JLabel("ENTER GOOGLE AUTH CODE");
		lblNewLabel_2_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(47, 389, 315, 23);
		contentPane.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(418, 384, 139, 28);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastCode = null;
				while (true) {
				    String code = Authenticator.getTOTPCode("JRYCHSCSRU5ZDY4ERZXIFX2CJFL7GBUP");
				    System.out.println(code);
				    String lastcode = textField_2.getText();
				    System.out.println(lastcode+" "+code);
				    System.out.println(code.equals(lastcode));
				    if (code.equals(lastcode))
				    {
				    	JOptionPane.showMessageDialog(btnNewButton, "Login Successful");
				    	setVisible(false);
				    	new AdminPage().setVisible(true);
				        break;
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(btnNewButton_1, "Login Unsuccessful");
				    }
				    lastCode = code;
				    try {
				        Thread.sleep(1000);
				    } catch (InterruptedException e1) {};
				}
			}
		});
		btnNewButton_1.setBounds(259, 489, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_61 = new JLabel("New label");
	     Image img11 = new ImageIcon(this.getClass().getResource("/logo5.png")).getImage();
			Image newImage11 = img11.getScaledInstance(375, 212, Image.SCALE_DEFAULT);
			lblNewLabel_61.setIcon(new ImageIcon(newImage11));
			lblNewLabel_61.setBounds(-20, 11, 357, 113);
	     contentPane.add(lblNewLabel_61);
	}
}
