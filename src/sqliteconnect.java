import java.sql.*;
import javax.swing.*;
public class sqliteconnect {
	Connection conn = null;
	public static Connection dbconnector(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\A Busy Jet\\Desktop\\database.db");
			//JOptionPane.showMessageDialog(null,"connection successfull");
			return conn;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}

}
