import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class afterbook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String aadhar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afterbook frame = new afterbook();
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
	Connection connect;
	public afterbook() {
		connect = sqliteconnect.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadharNumber = new JLabel("AADHAR NUMBER:");
		lblAadharNumber.setBounds(180, 185, 123, 16);
		contentPane.add(lblAadharNumber);
		
		textField = new JTextField();
		textField.setBounds(301, 182, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnProceed = new JButton("BOOK");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "insert into pastuserbook (cityname,cin,cout,noofrooms,username,hotel,aadharnumber) values (?,?,?,?,?,?,?)";
					PreparedStatement ps = connect.prepareStatement(query);
					ps.setString(1,hotelInfo.citynam);
					ps.setString(2,hoteldisplay.df.format(hotelInfo.checkin));
					ps.setString(3,hoteldisplay.df.format(hotelInfo.checkout));
					ps.setString(4,Integer.toString(hotelInfo.noofrooms));
					ps.setString(5,hotelInfo.username);
					ps.setString(6,hoteldisplay.hname);
					ps.setString(7,textField.getText());
					ps.execute();
					aadhar=textField.getText();
					//JOptionPane.showMessageDialog(null,hotelInfo.username);
					ps.close();
					dispose();
					afteraadhar ar = new afteraadhar();
					ar.setVisible(true);
				}
				catch(Exception e5) {
					JOptionPane.showMessageDialog(null,e5);
				}
				finally {
					
					if (connect != null) {
					    try {
					      connect.close(); // <-- This is important
					    } catch (SQLException e6) {
					    	JOptionPane.showMessageDialog(null,e6);
					    }
					  }
				}
			}
		});
		btnProceed.setBounds(259, 247, 97, 25);
		contentPane.add(btnProceed);
	}
}
