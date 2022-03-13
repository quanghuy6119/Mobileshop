package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Account;
import dao.ListAccountDao;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(urlPatterns = { "/RegisterController" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
		String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regex = "[a-zA-Z0-9_!@#$%^&*]+";
		
		
		String email = request.getParameter("email");
		String name = request.getParameter("userName");
		String password = request.getParameter("psw");
		String rpPassword = request.getParameter("psw-repeat");
		String address = request.getParameter("adress");
		String phone = request.getParameter("phone");
		
		ListAccountDao listAccountDao = new ListAccountDao();
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		
		if(!password.matches(regex) || !email.matches(regexMail)) {
			request.setAttribute("error", "invavlid syntax");
			dispatcher.forward(request, response);
			return;
		} else if (password.equals(rpPassword) == false) {
			request.setAttribute("error", "Password not same");
			dispatcher.forward(request, response);
			return;
		} else if (listAccountDao.checkAccountExist(email) ) {
			request.setAttribute("error", "Email account đã tồn tại");
			dispatcher.forward(request, response);
			return;
		}
		
		// luu du lieu bang bean
		Account acc = new Account(email,password,1,name,address,phone);
		// them account
		listAccountDao.addAccount(acc);
		response.sendRedirect("login.jsp");
		
		}catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
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
