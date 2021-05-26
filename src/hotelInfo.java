import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.*;
import java.text.*;

public class hotelInfo extends JFrame {
	static String username;
	static String citynam = new String();
	static Date checkin;
	static Date checkout;
	static int noofrooms;
	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	private DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	

	/**
	 * Launch the application.
	 */

	
	private JTextField textField;
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hotelInfo window = new hotelInfo();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect;
	public void fillComboBox(){
		
		connect = sqliteconnect.dbconnector();

		try {
			String query = "select * from cities";
			PreparedStatement pst = connect.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				comboBox.addItem(rs.getString("city name"));
			}
			
			rs.close();
			pst.close();
		}
		catch(Exception ei){
			JOptionPane.showMessageDialog(null,"Exception caught:" + ei);
		}
	}

	/**
	 * Create the frame.
	 */
	
	public hotelInfo() {
		username = login.name;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseTheHotel = new JLabel("Choose the city from below:");
		lblChooseTheHotel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblChooseTheHotel.setBounds(169, 30, 292, 56);
		contentPane.add(lblChooseTheHotel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(194, 114, 213, 22);
		contentPane.add(comboBox);
		fillComboBox();
		
		
		JLabel lblCheckInDate = new JLabel("CHECK IN DATE");
		lblCheckInDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCheckInDate.setBounds(169, 198, 134, 16);
		contentPane.add(lblCheckInDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(315, 198, 100, 22);
		contentPane.add(dateChooser);

		
				
		
		
		
		JLabel lblCheckOutDate = new JLabel("CHECK OUT DATE");
		lblCheckOutDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCheckOutDate.setBounds(169, 276, 134, 16);
		contentPane.add(lblCheckOutDate);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(315, 270, 100, 22);
		contentPane.add(dateChooser_1);
		
		
		
		textField = new JTextField();
		textField.setBounds(312, 352, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNumberOfRooms = new JLabel("NUMBER OF ROOMS REQUIRED");
		lblNumberOfRooms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumberOfRooms.setBounds(81, 355, 222, 16);
		contentPane.add(lblNumberOfRooms);
		
		JButton btnCheckAvailability = new JButton("PROCEED");
		btnCheckAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					citynam = comboBox.getSelectedItem().toString();
					java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
					checkin = sqlDate;
					java.sql.Date sqlDate1 = new java.sql.Date(dateChooser_1.getDate().getTime());
					checkout = sqlDate1;
					noofrooms = Integer.parseInt(textField.getText());
							
				
		     

			        dispose();
			        
					hoteldisplay hd = new hoteldisplay();
					hd.setVisible(true);
				
				}
				catch(Exception ei){
					JOptionPane.showMessageDialog(null,"Exception caught:" + ei);
				}
				finally {
					  if (connect != null) {
					    try {
					      connect.close(); // <-- This is important
					    } catch (SQLException e) {
					    	JOptionPane.showMessageDialog(null,e);
					    }
					  }
					  
				}
				
			
			}
		});
		btnCheckAvailability.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCheckAvailability.setBounds(232, 517, 196, 25);
		contentPane.add(btnCheckAvailability);
	}
}
