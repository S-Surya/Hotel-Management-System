import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.*;
import java.awt.Font;

public class vijayawada extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vijayawada frame = new vijayawada();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect = null;
	public void fillComboBox(){
	

		try {
			String query = "select * from vijayawadahotels";
			PreparedStatement pst = connect.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				comboBox.addItem(rs.getString("name"));
			}
		}
		catch(Exception ei){
			JOptionPane.showMessageDialog(null,"Exception caught:" + ei);
		}
	}
	/**
	 * Create the frame.
	 */

	public vijayawada() {
		connect = sqliteconnect.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(255, 216, 113, 22);
		contentPane.add(comboBox);
		fillComboBox();
		
		JLabel lblNewLabel = new JLabel("Select the hotel from the following:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel.setBounds(179, 166, 300, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(269, 305, 97, 25);
		contentPane.add(btnSubmit);
	}
}
