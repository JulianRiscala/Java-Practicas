package progEnCapas;
import JDBC_Excepciones.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;


//La pasamos a una clase abstracta para (si es necesario) usarla con varias clases de datos
public abstract class PersonaDAO {
	
	//Los metodos que deban ser "Multi base de datos" seran abstractos y seran resueltos en las sub clses
	public abstract Collection<PersonaDTO> buscarTodosSQLServer();
	
	//Al ver que las implementaciones son identicas y lo unico que cambian son las querys, podemos sobreescribir el metodo de cada clase implementadora y solo tomar un query para c/u
	protected abstract String queryBuscarUltimaPersona();
	
	public Collection<PersonaDTO> BuscarUltimaPersona(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = UConnection.getConnection();
			
			String sql = queryBuscarUltimaPersona();
			
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			Vector<PersonaDTO> colPersona = new Vector<PersonaDTO>();
			PersonaDTO Persona = null;
			
			while (rs.next() ) {
				Persona = new PersonaDTO();
				
				Persona.setID(rs.getInt("ID"));
				Persona.setCodigo(rs.getString("Codigo"));
				Persona.setNombre(rs.getString("Nombre"));
				Persona.setEdad(rs.getInt("Edad"));
				Persona.setEmail(rs.getString("Email"));
				Persona.setPassword(rs.getString("Password"));
				
				colPersona.add(Persona);
			}
			
			return colPersona;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if ( rs != null ) rs.close();
				if ( pstm != null ) pstm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
	
	//Este metodo es aplicable (Creo) que en todas las bases de datos, al menos en SQL Server.
	public Collection<PersonaDTO> buscarTodos(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			//con = UConnection.getConnection();
			//Implementamos el connectionPool reemplazando la instancia de la variable con. Y el finally devuelve la conexion para usarla en otro hilo que lo requiera
			con = ConnectionPool.getPool().getConnection();
			
			String sql = "SELECT ID, Codigo, Nombre, Apellido, Edad, Email, Password FROM Personas";
			
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			Vector<PersonaDTO> colPersona = new Vector<PersonaDTO>();
			PersonaDTO Persona = null;
			
			while (rs.next() ) {
				Persona = new PersonaDTO();
				
				Persona.setID(rs.getInt("ID"));
				Persona.setCodigo(rs.getString("Codigo"));
				Persona.setNombre(rs.getString("Nombre"));
				Persona.setApellido(rs.getString("Apellido"));
				Persona.setEdad(rs.getInt("Edad"));
				Persona.setEmail(rs.getString("Email"));
				Persona.setPassword(rs.getString("Password"));
				
				colPersona.add(Persona);
			}
			
			return colPersona;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if ( rs != null ) rs.close();
				if ( pstm != null ) pstm.close();
				
				//Devuelvo la conexion al pool
				if (con != null ) {
					ConnectionPool.getPool().releaseConnection(con);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
}
