package controller;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Cart;
import Model.Product;
import dao.ListProductDao;

/**
 * Servlet implementation class AddtoCartController
 */
@WebServlet(urlPatterns = {"/addToCart"})
public class AddtoCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddtoCartController() {
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
			Object acc = session.getAttribute("user");
			if(acc == null) {
				response.sendRedirect("login.jsp");
				return;
			}
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			if(action != null && action.equalsIgnoreCase("add")) {
				if(session.getAttribute("cart") == null) {
					session.setAttribute("cart", new Cart());
				}
				Model.Product p = new ListProductDao().getProduct(id);
				Cart c = (Cart) session.getAttribute("cart");
				c.add(new Product(p.getId(),p.getName(),p.getDescription(),p.getPrice(),p.getType(),p.getBrand(),1,p.getSourceImg()));
			}else if(action != null && action.equalsIgnoreCase("delete")){
				int idProduct = Integer.parseInt(id);
				Cart c = (Cart) session.getAttribute("cart");	
				c.remove(idProduct);
			}else if(action != null && action.equalsIgnoreCase("sub")){
				Model.Product p = new ListProductDao().getProduct(id);
				Cart c = (Cart) session.getAttribute("cart");	
				c.sub(p);
			}
			
			response.sendRedirect("list.jsp");
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/list.jsp");
//			dispatcher.forward(request, response);
		}catch(Exception ex) {
			response.getWriter().println(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
