package JDBC_Excepciones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsoExcepcion {

	public static void main(String[] args) {
	
		// parametros de la conexion
		String usr = "usr_prueba";
		String pwd = "asasas";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://Julian;databaseName=Ejemplo-DB;encrypt=true;trustServerCertificate=true";
		Scanner in = new Scanner(System.in);
		String input;

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try { 
			// PARTE 1
			//Levanto el driver
			Class.forName(driver);
			
			//establrzo la conexion
//			con = DriverManager.getConnection(url,usr,pwd);
			con = UConnection.getConnection();
			
			//PARTE 2
			System.out.println("Ingrese una opcion: ");
			input = in.nextLine();
			switch(input) {
			case "1":
				ejemploSelect(pstm,rs,con);
				break;
			case "2":
				ejemploInsert(pstm,rs,con);
				break;
			default:
				System.out.println("No llega");
				break;
			}

		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally {
			
			try {
				// PARTE 3
				
				//Cierro todos los recursos en orden inverso al que fueron adquiridos
				if (rs!=null) rs.close();
				if (pstm!=null) pstm.close();
				if (con!=null) con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	
	public static void ejemploSelect (PreparedStatement pstm, ResultSet rs, Connection con) {
		try {
			String sql = "SELECT * From Persona";
			
			//Preparo la sentencia que voy a ejecutar
			pstm = con.prepareStatement(sql);
			
			//Ejecuto la sentencia y obtengo los resultados en rs
			rs = pstm.executeQuery();
			
			// Itero los resultados
			while(rs.next()) {
				System.out.print("Codigo: " + rs.getString("Codigo"));
				System.out.print(" | Nombre: " + rs.getString("Nombre"));
				System.out.print(" | Apellido: " + rs.getString("Apellido"));
				System.out.println(" | Edad: " + rs.getInt("Edad"));
				
			}
		} catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	public static void ejemploInsert(PreparedStatement pstm, ResultSet rs, Connection con) {
		try {
			Scanner in = new Scanner(System.in);
			String sql = "INSERT INTO Usuario(PersonaID,Codigo,Nick,ClaseID)";
			sql += " VALUES(?,?,?,?) ";
			
			//Seteo el autocommit en false
			con.setAutoCommit(false);
			
			pstm = con.prepareStatement(sql);
			//seteamos los valores.
			System.out.println("Ingrese el ID de la persona: ");
			pstm.setInt(1, Integer.parseInt((in.nextLine())));
			System.out.println("Ingrese el codigo de la persona: ");
			pstm.setString(2, in.nextLine());
			System.out.println("Ingrese el nick de la persona: ");
			pstm.setString(3, in.nextLine());
			System.out.println("Ingrese la clase (en numero) de la persona: ");
			pstm.setInt(4, Integer.parseInt(in.nextLine()));
			
			int rtdo = pstm.executeUpdate();
			
			//Con con.commit() seria todo ok.
			if (rtdo == 1) con.commit(); else throw new RuntimeException("No se pudo insertar la fila");
		} catch(Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally {
			try {
				//Este es el rollback por las dudas
				if (con != null) con.rollback();
				if (pstm!= null) pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		//Una vez cp,,oteada la transaccion, los cambios seran permanntes.
	}
	
}
