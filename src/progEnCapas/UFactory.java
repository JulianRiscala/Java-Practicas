package progEnCapas;

import java.util.*;

public class UFactory {
	private static Hashtable<String,Object> instancias = new Hashtable<String,Object>();
	
	static {
        instancias = new Hashtable<String, Object>();
    }
	
	@SuppressWarnings("deprecation")
	public static Object GetInstancia(String objName) {
		try {
			//Verifico si existe un objeto relacionado a objName en la hashtable
			Object obj = instancias.get(objName);
			
			if ( obj == null) {
				ResourceBundle rb = ResourceBundle.getBundle("factory");
				String sClassname = rb.getString(objName);
				obj = Class.forName(sClassname).newInstance();
				
				//Agrego el objeto a la hashtable
				instancias.put(objName, obj);
			}
			
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
