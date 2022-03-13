package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Cart;
import Model.Orders;
import Model.Product;
import connection.MSSQLJDBCConnection;

public class OrdersDao {
	Connection connect = MSSQLJDBCConnection.getJDBCConnection();
	public void insertOrder(Orders o, Cart c) {
		String sqlUpdateOrders = "INSERT INTO Orders Values(?,?,?,?,?)";
		String sqlOrderId = "SELECT MAX(order_id) AS MAX From Orders";
		String sqlInsertOdetail = "INSERT INTO Orders_detail Values(?,?,?,?)";
		int orderId = 0;
		try {
			PreparedStatement statement = connect.prepareStatement(sqlUpdateOrders);
			PreparedStatement statementId = connect.prepareStatement(sqlOrderId);
			PreparedStatement statementOdetail = connect.prepareStatement(sqlInsertOdetail);
			
			connect.setAutoCommit(false);
			//them orders
			statement.setString(1, o.getUserMail());
			statement.setInt(2, o.getStatus());
			statement.setDate(3, o.getOrderDate());
			statement.setString(4, o.getDiscount());
			statement.setString(5, o.getAddress());
			int rs = statement.executeUpdate();
			System.out.println(rs);
			statement.addBatch();
			
			//tim order id moi nhat
			ResultSet result = statementId.executeQuery();
			while (result.next()) {
				orderId = result.getInt("MAX");
			}
			
			// them ordersdeital
			for (Product x : c.getItems()) {
				 statementOdetail.setInt(1, orderId);
				 statementOdetail.setInt(2, x.getId());
				 statementOdetail.setInt(3, x.getNumber());
				 statementOdetail.setFloat(4, x.getPrice());
				 int rs1 = statementOdetail.executeUpdate();
				 System.out.println(rs1);
			}
			
			connect.commit();
			connect.setAutoCommit(true);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
