import java.awt.BorderLayout;
import javax.swing.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Updateuser extends JFrame {

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
					Updateuser frame = new Updateuser();
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
	public Updateuser() {
		connect = sqliteconnect.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourUsername = new JLabel("Enter Your Username:");
		lblEnterYourUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnterYourUsername.setBounds(137, 228, 198, 31);
		contentPane.add(lblEnterYourUsername);
		
		JLabel lblEnterNewPassword = new JLabel("Enter New Password:");
		lblEnterNewPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnterNewPassword.setBounds(137, 290, 198, 16);
		contentPane.add(lblEnterNewPassword);
		
		textField = new JTextField();
		textField.setBounds(347, 233, 198, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(347, 288, 198, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update hotel set username = '"+textField.getText()+"',password = '"+textField_1.getText()+"' where username = '"+textField.getText()+"' ";
					PreparedStatement pst = connect.prepareStatement(query);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null,"Data Updated Successfully");
					
					pst.close();
				}
				catch(Exception ei){
					JOptionPane.showMessageDialog(null,"Exception caught:" + ei);
				}
			}
		});
		btnUpdate.setBounds(263, 369, 97, 25);
		contentPane.add(btnUpdate);
	}

}
