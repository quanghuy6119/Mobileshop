package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Account;
import connection.MSSQLJDBCConnection;

public class ListAccountDao {
	Connection connect = MSSQLJDBCConnection.getJDBCConnection();

	public boolean checkAccountExist(String x) {
		String sql = "SELECT user_mail FROM Account WHERE user_mail = ?";
		int count = 0;

		try {
			PreparedStatement statement = connect.prepareStatement(sql);
			statement.setString(1, x);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				count++;
			}
			if (count != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addAccount(Account account) {
		String sql = "INSERT INTO Account Values (?,?,1,?,?,?)";
		try {
			PreparedStatement st = connect.prepareStatement(sql);
			st.setString(1, account.getUser());
			st.setString(2, account.getPasswordUser());
			st.setString(3, account.getName());
			st.setString(4, account.getAddres());
			st.setString(5, account.getPhone());

			int rs = st.executeUpdate();
			System.out.println(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Account searchAccount(String email, String password) {
		String sql = "SELECT * FROM Account WHERE user_mail = ? AND password = ?";
		try {
			PreparedStatement st = connect.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, password);

			ResultSet rs = st.executeQuery();
			Account account = null;
			while (rs.next()) {
				String user = rs.getString("user_mail");
				String pw = rs.getString("password");
				int role = rs.getInt("account_role");
				String name = rs.getString("user_name");
				String address = rs.getString("user_address");
				String phone = rs.getString("user_phone");
				
				account = new Account(user,pw,role,name,address,phone);
			}
				
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
