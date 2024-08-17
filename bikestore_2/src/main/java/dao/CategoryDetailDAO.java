package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Bike;
import models.Category;
import models.CategoryDetail;

public class CategoryDetailDAO {
	Connection con;
	
	public CategoryDetailDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xedapphodb", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public ArrayList<Bike> findByCategoryCode(String categoryCode) throws SQLException {
		Statement st = null;
		ArrayList<Bike> listAll = new ArrayList<>();
		ResultSet rs = null;
		if (con != null) {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM categorydetail WHERE categorycode = ?");
			while (rs.next()) {
				Bike bike = new Bike();
				listAll.add(bike);
			}
		}
		return listAll;
	}
	
	public CategoryDetail getDetail(String categorycode) throws SQLException {
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("select * from categorydetail where categorycode=?");
		stmt.setString(1, categorycode);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			CategoryDetail categoryDetail = new CategoryDetail(rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
					rs.getString(9), rs.getString(10));
			rs.close();
			return categoryDetail;
		} else {
			return null;
		}
	}
}
