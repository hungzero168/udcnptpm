package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Bike;

public class BikeDAO {
    Connection con;

    public BikeDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xedapphodb", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public ArrayList<Bike> findAll(String code) throws SQLException {
        PreparedStatement ps = null;
        ArrayList<Bike> listAll = new ArrayList<>();
        ResultSet rs = null;
        if (con != null) {
            String query = "SELECT * FROM bike WHERE categorycode = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bike bk = new Bike(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
                listAll.add(bk);
            }
        }
        return listAll;
    }
    
    public Bike getBikeByCategoryCode(String categorycode) {
    	PreparedStatement pr=null;
    	ResultSet rs=null;
    	if(con!=null) {
    		try {
				pr=con.prepareStatement("select *from bike where categorycode=?");
				pr.setString(1, categorycode);
				rs=pr.executeQuery();
				while(rs.next()) {
					Bike bk = new Bike(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
					return bk;
				}
			} catch (SQLException e) {
				return new Bike();
			}
    	}
    	return new Bike();
    }
    
    public Bike getBikeByCode(String code) {
    	PreparedStatement pr=null;
    	ResultSet rs=null;
    	if(con!=null) {
    		try {
				pr=con.prepareStatement("select *from bike where bikecode=?");
				pr.setString(1,code);
				rs=pr.executeQuery();
				while(rs.next()) {
					Bike bk = new Bike(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
					return bk;
				}
			} catch (SQLException e) {
				return new Bike();
			}
    	}
    	return new Bike();
    }
    

    public static void main(String[] args) {
        BikeDAO demo = new BikeDAO();
        Bike bike=demo.getBikeByCategoryCode("CT01");
        System.out.println(bike.getColor());
    }
}
