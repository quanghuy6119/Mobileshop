package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Product;
import connection.MSSQLJDBCConnection;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet(urlPatterns = {"/check"})
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection connect = MSSQLJDBCConnection.getJDBCConnection();
		List<Model.Product> list = new ArrayList<>();
		try {
			Statement statement = connect.createStatement();
			String sql = "SELECT * FROM Products;";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				String des = rs.getString("product_des");
				float price = rs.getFloat("product_price");
				String type = rs.getString("product_type");
				String brand = rs.getString("product_brand");
				String source = rs.getString("product_img_source");
				
				Product newProduct = new Product(id,name,des,price,type,brand,source);
				list.add(newProduct);
			}
			HttpSession session = request.getSession();
			session.setAttribute("product", list);	
			response.sendRedirect("index.jsp?page=1");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
