import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import com.toedter.calendar.*;
public class Newuser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newuser frame = new Newuser();
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
	Connection connect = null;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public Newuser() {
		//code which connects to the database
		connect = sqliteconnect.dbconnector();
		//end of the connection code.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblUsername.setBounds(189, 129, 94, 22);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblPassword.setBounds(189, 176, 94, 22);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(295, 243, 169, 68);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(295, 329, 169, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save and go back");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into hotel (username,password,name,dateofbirth,address,emailid) values (?,?,?,?,?,?)";
					PreparedStatement pst = connect.prepareStatement(query);
					pst.setString(1,textField_3.getText());
					pst.setString(2,textField_2.getText());
					pst.setString(3,textField_4.getText());
					pst.setString(4,textField_1.getText());
					pst.setString(5,textField.getText());
					pst.setString(6,textField_5.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Saved Successfully");
					
					pst.close();
					connect.close();
					dispose();
				}
				catch(Exception ei){
					JOptionPane.showMessageDialog(null,"Exception caught:" + ei);
				}
				finally {
					if (connect != null) {
					    try {
					      connect.close(); // <-- This is important
					    } catch (SQLException e1) {
					    	JOptionPane.showMessageDialog(null,e1);
					    }
					  }
				
				}
			}
		});
		btnSave.setBounds(251, 410, 182, 25);
		contentPane.add(btnSave);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblName.setBounds(196, 56, 56, 16);
		contentPane.add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(295, 178, 169, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("date of birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblDateOfBirth.setBounds(178, 330, 105, 16);
		contentPane.add(lblDateOfBirth);
		
		textField_3 = new JTextField();
		textField_3.setBounds(295, 131, 169, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblAddress.setBounds(185, 244, 89, 16);
		contentPane.add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setBounds(295, 55, 169, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblEmailId.setBounds(189, 90, 85, 22);
		contentPane.add(lblEmailId);
		
		textField_5 = new JTextField();
		textField_5.setBounds(295, 90, 169, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}
}
