import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.text.*;

public class hoteldisplay extends JFrame {
	static String hname;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
	private int availablerooms;
	private int availablerooms1;
	private int availablerooms2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hoteldisplay frame = new hoteldisplay();
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
	public hoteldisplay() {
		connect = sqliteconnect.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 755);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(29, 52, 269, 99);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(29, 268, 269, 104);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("New label");
		label.setBounds(29, 547, 269, 104);
		contentPane.add(label);
		
		if(hotelInfo.citynam.equals("hyderabad")){
			lblNewLabel.setText("Taj Krishna");
			lblNewLabel_1.setText("Park Hyath");
			label.setText("Great Mayor");
		}
		else if(hotelInfo.citynam.equals("mumbai")) {
			lblNewLabel.setText("Taj Mahal Palace");
			lblNewLabel_1.setText("The Oberoi");
			label.setText("The Regis");
		}
		else if(hotelInfo.citynam.equals("banglore")) {
			lblNewLabel.setText("Vivantha Whitefield");
			lblNewLabel_1.setText("Gateway Field");
			label.setText("Taj West End");
		}
		
		JLabel lblAverageUserRating = new JLabel("AVERAGE USER RATING");
		lblAverageUserRating.setBounds(33, 245, 149, 16);
		contentPane.add(lblAverageUserRating);
		
		JLabel lblAverageUserRatingno = new JLabel("AVERAGE USER RATING");
		lblAverageUserRatingno.setBounds(33, 28, 149, 22);
		contentPane.add(lblAverageUserRatingno);
		
		JLabel label_2 = new JLabel("AVERAGE USER RATING");
		label_2.setBounds(29, 515, 149, 16);
		contentPane.add(label_2);
		
		JLabel lblPrice = new JLabel("PRICE:");
		lblPrice.setBounds(535, 130, 44, 16);
		contentPane.add(lblPrice);
		
		JLabel lblPrice_2 = new JLabel("PRICE:");
		lblPrice_2.setBounds(535, 349, 44, 16);
		contentPane.add(lblPrice_2);
		
		JLabel lblPrice_1 = new JLabel("PRICE:");
		lblPrice_1.setBounds(535, 632, 44, 16);
		contentPane.add(lblPrice_1);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(591, 349, 56, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setBounds(591, 632, 56, 16);
		contentPane.add(label_6);
		
		JLabel lblTotalCost = new JLabel("TOTAL COST:");
		lblTotalCost.setBounds(494, 159, 81, 16);
		contentPane.add(lblTotalCost);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(591, 159, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel label_3 = new JLabel("TOTAL COST:");
		label_3.setBounds(494, 375, 81, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(591, 375, 56, 16);
		contentPane.add(label_4);
		
		JLabel label_7 = new JLabel("TOTAL COST:");
		label_7.setBounds(494, 661, 81, 16);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setBounds(591, 661, 56, 16);
		contentPane.add(label_8);
		
		JLabel lblAmen = new JLabel("AMENITIES:");
		lblAmen.setBounds(409, 34, 87, 16);
		contentPane.add(lblAmen);
		
		JLabel lblNewLabel_4 = new JLabel("Complimentary Breakfast,Wifi,Swimming pool");
		lblNewLabel_4.setBounds(494, 31, 276, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_9 = new JLabel("AMENITIES:");
		label_9.setBounds(409, 245, 87, 16);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("AMENITIES:");
		label_10.setBounds(409, 515, 87, 16);
		contentPane.add(label_10);
		
		JLabel lblComplimentaryBreakfastwifi = new JLabel("Complimentary Breakfast,Wifi");
		lblComplimentaryBreakfastwifi.setBounds(494, 245, 276, 16);
		contentPane.add(lblComplimentaryBreakfastwifi);
		
		JLabel lblWifi = new JLabel("Wifi");
		lblWifi.setBounds(494, 515, 276, 16);
		contentPane.add(lblWifi);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(194, 245, 71, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(194, 31, 56, 16);
		contentPane.add(lblNewLabel_6);
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(591, 130, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(194, 439, 56, 16);
		contentPane.add(label_1);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setBounds(194, 515, 71, 16);
		contentPane.add(label_11);
		
		try {
		
			String query = "select price from hotelrooms where cityname = ? and hotelname = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1,hotelInfo.citynam);
			ps.setString(2,lblNewLabel.getText());
			ResultSet r = ps.executeQuery();
			//JOptionPane.showMessageDialog(null,lblNewLabel.getText());
			String pr;
			while(r.next()) {
				pr = r.getString(1);
				lblNewLabel_3.setText(Integer.toString(Integer.parseInt(pr)*hotelInfo.noofrooms));
				lblNewLabel_2.setText(pr);
			}
			r.close();
			ps.close();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
		try {
			String query = "select price from hotelrooms where cityname = ? and hotelname = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1,hotelInfo.citynam);
			ps.setString(2,lblNewLabel_1.getText());
			ResultSet r = ps.executeQuery();
			String p;
			while(r.next()) {
				p = r.getString(1);
				label_4.setText(Integer.toString(Integer.parseInt(p)*hotelInfo.noofrooms));
				label_5.setText(p);
			}
			r.close();
			ps.close();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
		try {
			String query = "select price from hotelrooms where cityname = ? and hotelname = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1,hotelInfo.citynam);
			ps.setString(2,label.getText());
			ResultSet r = ps.executeQuery();
			String p;
			while(r.next()) {
				p = r.getString(1);
				label_8.setText(Integer.toString(Integer.parseInt(p)*hotelInfo.noofrooms));
				label_6.setText(p);
			}
			r.close();
			ps.close();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
	
		
		JButton btnNewButton = new JButton("CHECK AVAILABILITY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select noofrooms,cin,cout from pastuserbook where hotel=? and cityname = ?";
					PreparedStatement ps = connect.prepareStatement(query);
					ps.setString(1,lblNewLabel.getText());
					ps.setString(2,hotelInfo.citynam);
					
					ResultSet r2 = ps.executeQuery();
					int sum2 = 0;
					int n2;
					while(r2.next()) {
						n2 = r2.getInt(1);
						java.sql.Date sqlDate = new java.sql.Date(df.parse(r2.getString(2)).getTime());
						Date datein = sqlDate;
						java.sql.Date sqlDate1 = new java.sql.Date(df.parse(r2.getString(3)).getTime());
						Date dateout = sqlDate1;
						if((hotelInfo.checkin.before(dateout) && hotelInfo.checkin.after(datein)) || (hotelInfo.checkout.before(dateout) && hotelInfo.checkout.after(datein))){
							sum2+=n2;
						}
					}
					ps.close();
					r2.close();
					
					String query1 = "select noofrooms from hotelrooms where hotelname=? and cityname = ?";
					PreparedStatement ps1 = connect.prepareStatement(query1);
					ps1.setString(1,lblNewLabel.getText());
					ps1.setString(2,hotelInfo.citynam);
					
					int totalrooms2;
					ResultSet r = ps1.executeQuery();
				//	System.out.println(r.getString(1));
					totalrooms2 = Integer.parseInt(r.getString(1));
				//	System.out.println(totalrooms2 + " " + sum2);
					
					availablerooms2 = totalrooms2-sum2;
					
					textField.setText("Available rooms: "+Integer.toString(availablerooms2));
					ps1.close();
					r.close();
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null,e);
					}
			}
		});
		btnNewButton.setBounds(363, 89, 164, 25);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("CHECK AVAILABILITY");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select noofrooms,cin,cout from pastuserbook where hotel=? and cityname = ?";
					PreparedStatement ps = connect.prepareStatement(query);
					ps.setString(1,lblNewLabel_1.getText());
					ps.setString(2,hotelInfo.citynam);
					
					ResultSet r2 = ps.executeQuery();
					int sum2 = 0;
					int n2;
					while(r2.next()) {
						n2 = r2.getInt(1);
						java.sql.Date sqlDate = new java.sql.Date(df.parse(r2.getString(2)).getTime());
						Date datein = sqlDate;
						java.sql.Date sqlDate1 = new java.sql.Date(df.parse(r2.getString(3)).getTime());
						Date dateout = sqlDate1;
						if((hotelInfo.checkin.before(dateout) && hotelInfo.checkin.after(datein)) || (hotelInfo.checkout.before(dateout) && hotelInfo.checkout.after(datein))){
							sum2+=n2;
						}
					}
					ps.close();
					r2.close();
					
					String query1 = "select noofrooms from hotelrooms where hotelname=? and cityname = ?";
					PreparedStatement ps1 = connect.prepareStatement(query1);
					ps1.setString(1,lblNewLabel_1.getText());
					ps1.setString(2,hotelInfo.citynam);
					
					int totalrooms2;
					ResultSet r4 = ps1.executeQuery();
				//	System.out.println(r4.getString(1));
					totalrooms2 = Integer.parseInt(r4.getString(1));
				//	System.out.println(totalrooms2 + " " + sum2);
					
					availablerooms1 = totalrooms2-sum2;
					
					textField_1.setText("Available rooms: "+Integer.toString(availablerooms1));
					ps1.close();
					r4.close();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
			}
		});
		button.setBounds(363, 308, 164, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("CHECK AVAILABILITY");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "select noofrooms,cin,cout from pastuserbook where hotel=? and cityname = ?";
					PreparedStatement ps = connect.prepareStatement(query);
					ps.setString(1,label.getText());
					ps.setString(2,hotelInfo.citynam);
					
					ResultSet r = ps.executeQuery();
					int sum = 0;
					int n;
					while(r.next()) {
						n = r.getInt(1);
						java.sql.Date sqlDate = new java.sql.Date(df.parse(r.getString(2)).getTime());
						Date datein = sqlDate;
						java.sql.Date sqlDate1 = new java.sql.Date(df.parse(r.getString(3)).getTime());
						Date dateout = sqlDate1;
						if((hotelInfo.checkin.before(dateout) && hotelInfo.checkin.after(datein)) || (hotelInfo.checkout.before(dateout) && hotelInfo.checkout.after(datein))){
							sum+=n;
						}
					}
					ps.close();
					r.close();
					
					String query1 = "select noofrooms from hotelrooms where hotelname=? and cityname = ?";
					PreparedStatement ps1 = connect.prepareStatement(query1);
					ps1.setString(1,label.getText());
					ps1.setString(2,hotelInfo.citynam);
					
					int totalrooms;
					ResultSet r1 = ps1.executeQuery();
				//	System.out.println(r1.getString(1));
					totalrooms = Integer.parseInt(r1.getString(1));
				//	System.out.println(totalrooms + " " + sum);
					
					availablerooms = totalrooms-sum;
					
					textField_2.setText("Available rooms: "+Integer.toString(availablerooms));
					ps1.close();
					r1.close();
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null,e);
					}
			}
		});
		button_1.setBounds(363, 587, 164, 25);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(391, 127, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(391, 346, 116, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(391, 629, 116, 22);
		contentPane.add(textField_2);
		
		JButton btnBook = new JButton("PROCEED");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hotelInfo.noofrooms <= availablerooms2) {
					try {
						hname = lblNewLabel.getText();
						dispose();
						afterbook af = new afterbook();
						af.setVisible(true);
					}
					catch(Exception e3) {
						JOptionPane.showMessageDialog(null,e3);
					}
					finally {
						
						if (connect != null) {
						    try {
						      connect.close(); // <-- This is important
						    } catch (SQLException e4) {
						    	JOptionPane.showMessageDialog(null,e4);
						    }
						  }
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Required number of rooms not available");
				}
				
				
				
			}
		});
		btnBook.setBounds(554, 89, 97, 25);
		contentPane.add(btnBook);
		
		JButton btnProceed = new JButton("PROCEED");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(hotelInfo.noofrooms <= availablerooms1) {
					try {
						hname  = lblNewLabel_1.getText();
						dispose();
						afterbook af = new afterbook();
						af.setVisible(true);
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
				else {
					JOptionPane.showMessageDialog(null,"Required number of rooms not available");
				}
			}
		});
		btnProceed.setBounds(554, 308, 97, 25);
		contentPane.add(btnProceed);
		
		JButton btnProceed_1 = new JButton("PROCEED");
		btnProceed_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(hotelInfo.noofrooms <= availablerooms) {
					try {
						hname  = label.getText();
						dispose();
						afterbook af = new afterbook();
						af.setVisible(true);
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
					}
					finally {
						
						if (connect != null) {
						    try {
						      connect.close(); // <-- This is important
						    } catch (SQLException e2) {
						    	JOptionPane.showMessageDialog(null,e2);
						    }
						  }
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Required number of rooms not available");
				}
			}
		});
		btnProceed_1.setBounds(554, 587, 97, 25);
		contentPane.add(btnProceed_1);

		
	
	
	
	
	}
	}

