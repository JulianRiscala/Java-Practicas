package Networking;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ObjetoServerRMI {

	public static void main(String[] args) throws Exception {
		ObtejoRemotoImple obj = new ObtejoRemotoImple();
		Registry registry = LocateRegistry.getRegistry(1099);
		
		registry.rebind("OBJRemoto", obj);

	}

}
