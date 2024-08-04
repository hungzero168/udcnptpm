package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GioHangDAO {
	Connection con;

	public GioHangDAO(Connection con) {
		super();
		this.con = con;
	}

	public GioHangDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xedapphodb", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public String findGiobyState(String username, String state) {
	    String query = "SELECT ordercode FROM orders WHERE username = ? AND state = ?";
	    try (PreparedStatement ps = con.prepareStatement(query)) {
	        ps.setString(1, username);
	        ps.setString(2, state);
	        
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return rs.getString("ordercode");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}


	
	
	public void insertOrder(String ordercode, String username, String state) throws SQLException {
        PreparedStatement pr = con.prepareStatement("INSERT INTO orders (ordercode, username, state) VALUES (?, ?, ?)");
        pr.setString(1, ordercode);
        pr.setString(2, username);
        pr.setString(3, state);
        pr.executeUpdate();
        
    }
	
	public void insertOrderDetail(String ordercode, String bikecode, int amount) throws SQLException {
        String sql = "INSERT INTO oderdetail (ordercode, bikecode, amount) VALUES (?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, ordercode);
            statement.setString(2, bikecode);
            statement.setInt(3, amount);
            statement.executeUpdate();
        }
    }
}
