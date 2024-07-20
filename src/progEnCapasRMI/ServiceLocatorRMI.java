package progEnCapasRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServiceLocatorRMI {
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 1099;
	
	public static Object lookup(String objRemoteName) {
		try {
			Registry registry = LocateRegistry.getRegistry(SERVER_IP, SERVER_PORT);
			return registry.lookup(objRemoteName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
