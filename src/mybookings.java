import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class mybookings extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mybookings frame = new mybookings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connect;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JButton btnExit;
	private JButton btnGoBack;
	/**
	 * Create the frame.
	 */
	public mybookings() {
		connect = sqliteconnect.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(278, 58, 701, 455);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			String query="select * from pastuserbook where username =?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1,login.name);
			ResultSet rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		catch(Exception e5) {
				JOptionPane.showMessageDialog(null,e5);
			}
		
		btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query = "delete from pastuserbook where bookingid = '"+textField.getText()+"' and username = '"+login.name+"' ";
					PreparedStatement ps = connect.prepareStatement(query);
					ps.execute();
					JOptionPane.showMessageDialog(null,"you have successfully cancelled");
					ps.close();
					
					String query1="select * from pastuserbook where username =?";
					PreparedStatement ps1 = connect.prepareStatement(query1);
					ps1.setString(1,login.name);
					ResultSet rs1=ps1.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs1));
					ps1.close();
					rs1.close();
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
		btnNewButton_1.setBounds(87, 336, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblEnterBookingId = new JLabel("Enter Booking ID:");
		lblEnterBookingId.setBounds(23, 237, 99, 16);
		contentPane.add(lblEnterBookingId);
		
		textField = new JTextField();
		textField.setBounds(129, 236, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(87, 399, 97, 25);
		contentPane.add(btnExit);
		
		btnGoBack = new JButton("go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				viewmybook vb = new viewmybook();
				vb.setVisible(true);
			}
		});
		btnGoBack.setBounds(87, 461, 97, 25);
		contentPane.add(btnGoBack);
	}
}
