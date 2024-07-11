package progEnCapas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import JDBC_Excepciones.UConnection;

public class PersonaDAOsqlServerImple extends PersonaDAO {
	// Aca van metodos donde las querys estan preparadas para usar solamente por sql server. Toda la funcionabilidad es igual.
	
	public String queryBuscarUltimaPersona() { //Entonces en cada implémentador tendriamos algo asi, para cada DAO existente.
		String sql = "SELECT ID, Codigo, Nombre, Apellido, Edad, Email, "
				+ "Password FROM Personas ORDER BY ID DESC";
		return sql;
	}
	
	public Collection<PersonaDTO> buscarTodosSQLServer(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = UConnection.getConnection();
			
			String sql = "SELECT ID, Codigo, Nombre, Apellido, Edad, Email, Password FROM Personas"; /* ESTA ES LA UNICA LINEA QUE DEBE CAMBIAR ENTRE BASE DE DATOS */
			
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
}
