package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectionFactory {

	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/cadastro";
	private static String USER = "root";
	private static String PASSWORD = "";

	public static Connection getConnection() {

		try {

			Class.forName(DRIVER);

			return DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {

			throw new RuntimeException("Erro ao conectar!" + e);
		}
	}

	public static void closeConnection(Connection con) {

		if (con != null) {

			try {

				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt) {

		closeConnection(con);

		if (stmt != null) {

			try {

				stmt.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

		closeConnection(con, stmt);

		if (rs != null) {

			try {

				rs.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}
