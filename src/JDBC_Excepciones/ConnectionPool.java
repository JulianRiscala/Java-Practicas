package JDBC_Excepciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.util.Vector;

public class ConnectionPool {
	private Vector<Connection> libres;
	private Vector<Connection> usadas;
	
	private String url;
	private String driver;
	private String usr;
	private String pwd;
	
	private int minsize;
	private int maxsize;
	private int steep;
	
	private static ConnectionPool pool = null;
	
	//El constructor es privado. La unica manera de acceder a una instancia de ConnectionPool sera a travez del metodo estático getPool.
	private ConnectionPool() { 
		try {
			ResourceBundle rb = ResourceBundle.getBundle("connectionpool");
			
			//Obtengo los parametros de la conexion.
			url = rb.getString("url");
			driver = rb.getString("driver");
			usr = rb.getString("usr");
			pwd = rb.getString("pwd");
			
			//Levanto el driver
			Class.forName(driver);
			
			//Obtengo los parametros del pool
			minsize = Integer.parseInt(rb.getString("minsize"));
			maxsize = Integer.parseInt(rb.getString("maxsize"));
			steep = Integer.parseInt(rb.getString("steep"));
			
			libres = new Vector<Connection>();
			usadas = new Vector<Connection>();
			
			//Instancio las primeras n conexiones
			_instanciar(minsize);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public String toString() {
		return "libres: " + libres.size() + ", usadas: " + usadas.size();
	}
	
	//El metodo getPool isntancia al pool invocando al constructor dentro del cual estableciamos la cantidad inicial de conexiones.
	// Dado quie puede haber varios hilos compitiendo por obtener el pool, resulta que el metodo getPool tambien tiene que ser sincronizado
	public synchronized static ConnectionPool getPool() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}
	
	public synchronized Connection getConnection() {
		if (libres.size() == 0) {
			if ( !_crearMasConexiones() ) {
				throw new RuntimeException("No hay conexiones disponibles");
			}
		}
		Connection con = libres.remove(0);
		usadas.add(con);
		return con;
	}
	// Comenzamos preguntando "Si se acabaron las conexiones libres y no podemos crear nuevas conexiones" entonces tiramos una excepcion indicando al cliente que no podra obtener lo que busca.
	// Si este no es el caso, tomamos la primera conexionm del vector "libres", la pasamos al vector "usadas" y retornamos la referencia al llamado
	
	private boolean _crearMasConexiones() {
		int actuales = libres.size() + usadas.size();
		int n = Math.min(maxsize - actuales,steep);
		
		if (n > 0) {
			System.out.println("Creando " + n + " conexiones nuevas...");
			_instanciar (n);
		}
		return n > 0 ;
	}

	//El metodo privado _instanciar que recibe el parametro n, instancia n conexiones y las agrega al vector de conexiones libres.
	private void _instanciar(int n) {
		try {
			Connection con;
			for (int i = 0; i < n; i++) {
				con = DriverManager.getConnection(url, usr, pwd);
				con.setAutoCommit(false);
				libres.add(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//El metodo releaseConnection, recibimos la conexion que el cliente (el hilo) quiere devolver. Removemos del vector de conexiones usadas y la agregamos al vector de conexiones libres.
	// Si la conexion no existe en el vector de conexiones usadas, será porque se trata de un error.
	public synchronized void  releaseConnection(Connection con) {
		boolean ok = usadas.remove(con);
		if (ok) {
			libres.add(con);
		} 
		else {
			throw new RuntimeException("Me devuelve una conexion que no es mia...");
		}
	}
	
	
	//Por último, veremos que el metodo close cierra todas las conexiones abiertas.
	public synchronized void close() {
		try {
			//Cierro todas las conexiones libres
			for (Connection con: libres) {
				con.close();
			}
			
			//Cierro todas las conexiones usadas
			for (Connection con: usadas) {
				con.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//En la clase PersonaDAO se ve como implementar el pool de conexiones.
}


