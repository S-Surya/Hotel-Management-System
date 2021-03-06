import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing;
import java.lang.*;
public class login{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conne = null;
	private JTextField textField;
	private JPasswordField passwordField;
	public login() {
		initialize();
		conne = sqliteconnect.dbconnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 928, 711);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(505, 160, 225, 49);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(350, 160, 116, 49);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(350, 271, 98, 49);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select * from hotel where username=? and password = ?";
					PreparedStatement ps = conne.prepareStatement(query);
					ps.setString(1,textField.getText());
					ps.setString(2,passwordField.getText());
					
					ResultSet r = ps.executeQuery();
					int count = 0;
					while(r.next()) {
						count++;
					}
					if(count == 1) {
						JOptionPane.showMessageDialog(null,"You are welcome buddy!!");
					}
					else{
						JOptionPane.showMessageDialog(null,"Sorry, recheck the username and password you entered:!");
					}
					r.close();
					ps.close();
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnLogin.setBounds(439, 421, 124, 41);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(505, 271, 225, 49);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		ImageIcon img  = new ImageIcon(this.getClass().getResource("/user-icon.png"));
		label.setIcon(img);
		label.setBounds(131, 103, 188, 394);
		frame.getContentPane().add(label);
	}
}
