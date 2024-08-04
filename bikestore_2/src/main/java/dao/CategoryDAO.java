package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customercontroller.categoryDetail;
import models.Bike;
import models.Category;
import models.CategoryDetail;

public class CategoryDAO {
	Connection con;

	public CategoryDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xedapphodb", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<Category> findAll() throws SQLException {
		Statement st = null;
		ArrayList<Category> listAll = new ArrayList<>();
		ResultSet rs = null;
		if (con != null) {
			st = con.createStatement();
			rs = st.executeQuery("select *from category");
			while (rs.next()) {
				Category category = new Category(rs.getString(1), rs.getString(2), rs.getFloat(3));
				listAll.add(category);
			}
		}
		return listAll;
	}

	

	public void insert(Category category) {
		String sql = "insert into category(categorycode,name,price) values (?,?,?)";
		if (con != null) {
			try {
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setString(1, category.getCode());
				pr.setString(2, category.getName());
				pr.setFloat(3, category.getPrice());
				pr.executeUpdate();
				pr.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateCategory(Category category) {
		String sql = "update category set name=?,price=? where categorycode=?";
		if (con != null) {
			try {
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setString(1, category.getName());
				pr.setFloat(2, category.getPrice());
				pr.setString(3, category.getCode());
				pr.executeUpdate();
				pr.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteCategory(String categorycode) {
		String sql = "delete from category where categorycode=?";
		if (con != null) {
			try {
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setString(1, categorycode);
				pr.executeUpdate();
				pr.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public Category getDetail(String categorycode) throws SQLException {
		PreparedStatement stmt = null;
		stmt = con.prepareStatement("select * from category where categorycode=?");
		stmt.setString(1, categorycode);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			Category c = new Category(rs.getString(1), rs.getString(2), rs.getFloat(3));
			return c;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		CategoryDAO demo = new CategoryDAO();
//		Category category=new Category("CT214", "XE DAP 5266", 100);
//		demo.deleteCategory("CT214");
		
	}
}
