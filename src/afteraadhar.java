import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class afteraadhar extends JFrame {

	private JPanel contentPane;
	private JTextField txtYourBookingIs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afteraadhar frame = new afteraadhar();
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
	private JLabel lblYourBookingId;
	private JLabel label;
	public afteraadhar() {
		connect = sqliteconnect.dbconnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewMyBookings = new JButton("View My Bookings");
		btnViewMyBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				mybookings mb = new mybookings();
				mb.setVisible(true);
				
			}
		});
		btnViewMyBookings.setBounds(236, 143, 154, 25);
		contentPane.add(btnViewMyBookings);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setBounds(263, 254, 97, 25);
		contentPane.add(btnExit);
		
		txtYourBookingIs = new JTextField();
		txtYourBookingIs.setFont(new Font("Tahoma", Font.ITALIC, 18));
		txtYourBookingIs.setText("YOUR BOOKING IS SUCCESSFULL");
		txtYourBookingIs.setBounds(183, 52, 288, 22);
		contentPane.add(txtYourBookingIs);
		txtYourBookingIs.setColumns(10);
		
		lblYourBookingId = new JLabel("your booking id number is:");
		lblYourBookingId.setBounds(135, 92, 173, 16);
		contentPane.add(lblYourBookingId);
		
		label = new JLabel("New label");
		label.setBounds(334, 92, 56, 16);
		contentPane.add(label);
		

//		try {
//		
//			String query = "select bookingid from pastuserbook where cityname = ? and hotel = ? and username = ? and aadharnumber = ? and cin = ? and cout = ? and noofrooms = ?";
//			PreparedStatement ps = connect.prepareStatement(query);
//			ps.setString(1,hotelInfo.citynam);
//			ps.setString(2,hoteldisplay.hname);
//			ps.setString(3,hotelInfo.username);
//			ps.setString(4,afterbook.aadhar);
//			ps.setDate(5,hotelInfo.checkin);
//			ps.setDate(6,hotelInfo.checkout);
//			ps.setString(7,Integer.toString(hotelInfo.noofrooms));
//
//			ResultSet r = ps.executeQuery();
//			
//			String pr;
//			
//			while(r.next()) {
//				pr = r.getString(1);
//				label.setText(pr);
//				JOptionPane.showMessageDialog(null,pr);
//			}
//			r.close();
//			ps.close();
//		}
//		catch(Exception e1) {
//			JOptionPane.showMessageDialog(null,e1);
//		}
//		finally {
//			if (connect != null) {
//			    try {
//			      connect.close(); // <-- This is important
//			    } catch (SQLException e6) {
//			    	JOptionPane.showMessageDialog(null,e6);
//			    }
//			  }
//		}
//		


	}
}
