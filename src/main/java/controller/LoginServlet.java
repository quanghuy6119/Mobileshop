package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Account;
import dao.ListAccountDao;

@WebServlet(urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			// xoa bo session hien tai
			request.getSession(true).invalidate();

			// bieu thuc regex
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";

			String userID = request.getParameter("username");
			String password = request.getParameter("password");
			String check = request.getParameter("remember");

			
			//khoi tao bien session
			HttpSession session = request.getSession();

//			doan nay tuong duong voi catch bat exception null
//			if(userID == null || password == null) {
//				response.sendRedirect("login.jsp");
//			};
			
			
			// KIEM TRA CO DUNG CU PHAP
			if(!password.matches(regex) || !userID.matches(regexMail)) {
				session.setAttribute("error", "invavlid syntax");
				response.sendRedirect("login.jsp");
				return;
			}
			
			// luu du lieu bang bean
			Account acc = new Account();

			// LAY THONG TIN CONTEXT TU WEB.XML
			String adminID = getServletContext().getInitParameter("username");
			String adminPassword = getServletContext().getInitParameter("password");
			
			ListAccountDao listAccountDao = new ListAccountDao();
			//Kiem tra ID user va password
			if (userID != null && userID.equalsIgnoreCase(adminID)
					&& password.equals(adminPassword)) {
				
				acc.setUser(userID);
				acc.setPasswordUser(password);
				session.setAttribute("user", acc);	
				session.setAttribute("admin", "admin");	

				// set cookie neu nhan remember
				if (check!=null && check.equals("remember")) {
					Cookie cookie = new Cookie("rememberID", adminID);
					Cookie cookie2 = new Cookie("rememberPass", adminPassword);
					cookie.setMaxAge(120);
					cookie2.setMaxAge(120);
					response.addCookie(cookie);
					response.addCookie(cookie2);
				}

				response.sendRedirect("admin.jsp");
				
			} else if(userID != null &&  listAccountDao.searchAccount(userID,password) != null){
				acc = listAccountDao.searchAccount(userID,password);
				session.setAttribute("user", acc);	
				
				// set cookie neu nhan remember
				if (check!=null && check.equals("remember")) {
					Cookie cookie = new Cookie("rememberID", userID);
					Cookie cookie2 = new Cookie("rememberPass",password);
					cookie.setMaxAge(120);
					cookie2.setMaxAge(120);
					response.addCookie(cookie);
					response.addCookie(cookie2);
				}

				response.sendRedirect("list.jsp");		
				
			} else {
				session.setAttribute("error", "Username or password is invalid");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			response.getWriter().println(ex);
		}

	}
}