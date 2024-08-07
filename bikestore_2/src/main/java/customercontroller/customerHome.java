package customercontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale.Category;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BikeDAO;
import dao.CategoryDAO;
import models.Bike;

/**
 * Servlet implementation class customerHome
 */
@WebServlet("/customerHome")
public class customerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    CategoryDAO cDAO = new CategoryDAO();
//	    BikeDAO demo = new BikeDAO();
//	    request.setAttribute("demo", demo); 
//	    ArrayList<models.Category> categories = null;
//	    try {
//	        categories = cDAO.findAll();
////	        bikes = bDAO.
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//
//	    request.setAttribute("categories", categories);
////	    request.setAttribute("bikes", bikes);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/views/customer/customer-home.jsp");
	    dispatcher.forward(request, response);
	}

//	https://xedap.vn/wp-content/uploads/2023/07/2024_FastroadADV2_HeliosOrange.jpg

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
