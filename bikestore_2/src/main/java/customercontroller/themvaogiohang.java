package customercontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GioHangDAO;
import models.User;

/**
 * Servlet implementation class themvaogiohang
 */
@WebServlet("/themvaogiohang")
public class themvaogiohang extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public themvaogiohang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		//check cart
		
		User user=(User)session.getAttribute("user");
		
		String bikeCode = request.getParameter("bikeCode");
		int quantity = Integer.parseInt(request.getParameter("sp_soluong"));
		String categorycode =request.getParameter("categorycode");
		String state = "1";
		
		
		if (bikeCode == null) {
			 request.getSession().setAttribute("errorMessageCart", "Vui lòng chọn màu sản phẩm và mã sản phẩm hợp lệ.");
		        response.sendRedirect(request.getContextPath() + "/categoryDetail?code=" + categorycode);
		} else {
//			System.out.println(bikeCode);
//			System.out.println(quantity);
//			System.out.println(categorycode);
			
			GioHangDAO gioHangDAO = new GioHangDAO();
			String maDon = gioHangDAO.findGiobyState(user.getUsername(), state );
			try {
				if(bikeCode != null) {
					if (maDon != null) {
						gioHangDAO.insertOrderDetail(maDon, bikeCode, quantity);
					} else {
						Random random = new Random();
						int randomNumber = 1000000 + random.nextInt(9000000);
						String ordercode = "OD" + randomNumber;
						
						gioHangDAO.insertOrder(ordercode, user.getUsername(), state);
						gioHangDAO.insertOrderDetail(ordercode, bikeCode, quantity);
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect(request.getContextPath()+"/giohang");
			
//			request.getSession().setAttribute("sucssMessageCart", "Thêm vào giỏ hàng thành công.");
//	        response.sendRedirect(request.getContextPath() + "/categoryDetail?code=" + categorycode);
//			response.sendRedirect(request.);
		}
	}

}
