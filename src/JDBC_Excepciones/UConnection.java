package JDBC_Excepciones;
import java.sql.*;
import java.util.*;

public class UConnection {

	private static Connection con = null;
	
	public static Connection getConnection() {
		try {
			if (con == null) {
				//Con esto determinamos cuando finalize el programa
				Runtime.getRuntime().addShutdownHook(new MiShDwnHook());
				
				ResourceBundle rb = ResourceBundle.getBundle("jdbc");
				String driver = rb.getString("driver");
				String url = rb.getString("url");
				String pwd = rb.getString("pwd");
				String usr = rb.getString("usr");
				
				Class.forName(driver);
				con = DriverManager.getConnection(url,usr,pwd);
			}
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error al crear la conexion",e);
		}
	}
	
	static class MiShDwnHook extends Thread{
		//Justo antes de finalizar el programa la JVM invocara a este metodo donde podemos cerrar la conexion
		
		public void run() {
			try {
				Connection con = UConnection.getConnection();
				con.close();
			}
			catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
}
