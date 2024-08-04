package customercontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BikeDAO;
import dao.CategoryDAO;
import dao.CategoryDetailDAO;
import models.Bike;
import models.Category;
import models.CategoryDetail;
import models.User;

/**
 * Servlet implementation class categoryDetail
 */
@WebServlet("/categoryDetail")
public class categoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session=request.getSession();
//		User user=(User)session.getAttribute("user");
//		if(user!=null) {};
		
		String code = request.getParameter("code");
		if(code != null && !code.isEmpty()) {
			CategoryDAO categorys = new CategoryDAO();
			Category category = null;
			
			CategoryDetailDAO detailDAO = new CategoryDetailDAO();
			CategoryDetail categoryDetail = null;
			
			BikeDAO bikeDAO = new BikeDAO();
			ArrayList<Bike> DSBike = null;
			
			try {
				category = categorys.getDetail(code);
				categoryDetail = detailDAO.getDetail(code);
				DSBike = bikeDAO.findAll(code);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("category", category);
			request.setAttribute("DSBike", DSBike);
			request.setAttribute("categoryDetail", categoryDetail);
			RequestDispatcher rd = request.getRequestDispatcher("/views/customer/category-detail.jsp");
			rd.forward(request, response);
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
