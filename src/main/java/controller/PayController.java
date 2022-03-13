package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cart;
import Model.Orders;
import dao.OrdersDao;

/**
 * Servlet implementation class PayController
 */
@WebServlet(urlPatterns = { "/PayController" })
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("cart") == null) {
				response.sendRedirect("list.jsp");
				return;
			}
			OrdersDao dao = new OrdersDao();
			Cart c = (Cart) session.getAttribute("cart");	
			String userName = request.getParameter("name");
			String address = request.getParameter("address");
			long millis=System.currentTimeMillis();
			Orders d = new Orders(1,new java.sql.Date(millis),address,userName,"");
			dao.insertOrder(d,c);
			response.sendRedirect("index.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
