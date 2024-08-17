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
import dao.GioHangDAO;
import models.Bike;
import models.Category;
import models.CategoryDetail;
import models.OrderDetail;
import models.User;

/**
 * Servlet implementation class giohang
 */
@WebServlet("/giohang")
public class giohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		if (user == null) {
	        // Set an attribute to show the login message or redirect to a login page
	        request.setAttribute("loginMessage", "Vui lòng đăng nhập để xem giỏ hàng.");
	        // Forward to a login page or error page
	        RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
	        rd.forward(request, response);
	        return; // Exit the method
	    }
		
		
		GioHangDAO gioHangDAO=new GioHangDAO();
		String ordercode=gioHangDAO.findGiobyState(user.getUsername(),"1");
		ArrayList<OrderDetail> orderDetails=gioHangDAO.findOrderDetailByCode(ordercode);
		
		request.setAttribute("ordercode", ordercode);
		
		float tong=0;
		for(int i=0;i<orderDetails.size();i++) {
			int soluong=orderDetails.get(i).getAmount();
			
			CategoryDAO categoryDAO=new CategoryDAO();
			Category category=null;
			BikeDAO bikeDAO=new BikeDAO();
			Bike bike=bikeDAO.getBikeByCode(orderDetails.get(i).getBikecode());
			try {
				category= categoryDAO.getDetail(bike.getCategorycode());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			float gia=category.getPrice();
			tong =tong+(gia*soluong);
		}
		String formattedNumber = String.format("%,.2f", tong); 
		request.setAttribute("tong", formattedNumber);
		
		request.setAttribute("orderDetails",orderDetails);
		RequestDispatcher rd = request.getRequestDispatcher("/views/customer/gio-hang.jsp");
	    rd.forward(request, response);
		
//		response.sendRedirect("views/customer/gio-hang.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		
		
//		CategoryDAO categorys = new CategoryDAO();
//		Category category = null;
//		
//		CategoryDetailDAO detailDAO = new CategoryDetailDAO();
//		CategoryDetail categoryDetail = null;
//		
//		BikeDAO bikeDAO = new BikeDAO();
//		ArrayList<Bike> DSBike = null;
//		
////		try {
////			
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//		request.setAttribute("category", category);
////		RequestDispatcher rd = request.getRequestDispatcher("/views/customer/category-detail.jsp");
////		rd.forward(request, response);
//		
		
		
	}

}
