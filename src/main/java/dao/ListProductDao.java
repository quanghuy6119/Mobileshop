package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.WhileStatement;

import Model.Product;
import connection.MSSQLJDBCConnection;

public class ListProductDao {
	Connection connect = MSSQLJDBCConnection.getJDBCConnection();

	public List<Product> search(String x) {
		String str = x.replace(" ", "");
		int length = str.length();
		String sql = "SELECT * FROM Products WHERE LEFT(REPLACE(product_name,' ',''),?) = ?";
		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, length);
			statement.setString(2, str);

			List<Product> list = new ArrayList<>();
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				String des = rs.getString("product_des");
				float price = rs.getFloat("product_price");
				String type = rs.getString("product_type");
				String brand = rs.getString("product_brand");
				String source = rs.getString("product_img_source");
				Product newProduct = new Product(id, name, des, price, type, brand, source);
				list.add(newProduct);
			}
			
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Product getProduct(String x) {
		int i = Integer.parseInt(x);
		String sql = "SELECT * FROM Products Where product_id = ?";
		try {

			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setInt(1, i);

			Product product = null;
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				String des = rs.getString("product_des");
				float price = rs.getFloat("product_price");
				String type = rs.getString("product_type");
				String brand = rs.getString("product_brand");
				String source = rs.getString("product_img_source");
				product = new Product(id, name, des, price, type, brand, source);
			}
			return product;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		return null;
	}
	
	
}
