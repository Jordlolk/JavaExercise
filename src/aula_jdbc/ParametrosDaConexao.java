package aula_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Pedro Alex
 */
public class ParametrosDaConexao {
	private static Connection conn;
	private static String jdbcURL = "jdbc:mysql://localhost:3306/mercado";
	private static String user = "root";
	private static String password = "root";

	public static String getJdbcURL() {
		return jdbcURL;
	}
	public static String getUser() {
		return user;
	}
	public static String getPassword() {
		return password;
	}
	public static Connection getConnectionBD(){
		try {
			if(conn == null){
				conn = DriverManager.getConnection(jdbcURL, user, password);
				return conn;
			} else{
				return conn;
			}
		} catch (SQLException error){
			error.printStackTrace();
			return null;
		}
	}
}
