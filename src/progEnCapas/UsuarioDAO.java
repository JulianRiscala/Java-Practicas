package progEnCapas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import JDBC_Excepciones.UConnection;

//La pasamos a una clase abstracta para (si es necesario) usarla con varias clases de datos
public abstract class UsuarioDAO {
	
	public abstract Collection<UsuarioDTO> BuscarXPersonaSQLServer(int PersonaID);
	//Con las clases abstractas, va a haber cambios en el facade.
	
	public Collection<UsuarioDTO> BuscarXPersona(int PersonaID){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = UConnection.getConnection();
			
			String sql = "SELECT ID, PersonaID, Codigo, Nick, ClaseID FROM Usuarios WHERE PersonaID = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, PersonaID);
			
			rs = pstm.executeQuery();
			
			Vector<UsuarioDTO> colUsuario = new Vector<UsuarioDTO>();
			UsuarioDTO Usuario = null;
			
			while (rs.next() ) {
				Usuario = new UsuarioDTO();
				
				Usuario.setID(rs.getInt("ID"));
				Usuario.setPersonaID(rs.getInt("PersonaID"));
				Usuario.setCodigo(rs.getString("Codigo"));
				Usuario.setNick(rs.getString("Nick"));
				Usuario.setClaseID(rs.getInt("ClaseID"));
				
				colUsuario.add(Usuario);
			}
			
			return colUsuario;
			
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
