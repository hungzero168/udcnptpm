package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Order;
import models.OrderDetail;

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
	
	public ArrayList<Order> getAllOrder(){
		ArrayList<Order> list=new ArrayList<Order>();
		PreparedStatement pr=null;
		ResultSet rs=null;
		try {
			pr=con.prepareStatement("select *from orders");
			rs=pr.executeQuery();
			while(rs.next()) {
				Order order=new Order(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(order);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<OrderDetail> findOrderDetailByCode(String code){
		ArrayList<OrderDetail> list=new ArrayList<OrderDetail>();
		PreparedStatement pr=null;
		ResultSet rs=null;
		try {
			pr=con.prepareStatement("select *from oderdetail where ordercode=?");
			pr.setString(1, code);
			rs=pr.executeQuery();
			while(rs.next()) {
				OrderDetail orderDetail=new OrderDetail(code, rs.getString(3), rs.getInt(4));
				list.add(orderDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
	
	public void updateOrderState(String ordercode, String username, int state) throws SQLException {
        String sql = "UPDATE orders SET state=? WHERE ordercode=? AND username=?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
        	statement.setInt(1, state);
            statement.setString(2, ordercode);
            statement.setString(3, username);
            statement.executeUpdate();
        }
    }
	public static void main(String[] args) {
		GioHangDAO demo=new GioHangDAO();
		System.out.println(demo.getAllOrder().get(3).getUsername());
	}
}
