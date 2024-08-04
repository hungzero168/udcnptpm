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

    public static void main(String[] args) {
        BikeDAO demo = new BikeDAO();
        try {
            ArrayList<Bike> bike = demo.findAll("CT01");
            for (Bike bk : bike) {
                System.out.println(bk.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
