package progEnCapasRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//public class ServerRMI {
//
//	public static void main(String[] args) throws Exception {
//		FacadeRemotoImple f = new FacadeRemotoImple();
//		Registry registry = LocateRegistry.getRegistry(1099);
//		
//		registry.rebind("FacadeRemoto", f);
//
//	}
//}

public class ServerRMI {

    public static void main(String[] args) {
        try {
            FacadeRemotoImple f = new FacadeRemotoImple();
            Registry registry;
            try {
                registry = LocateRegistry.getRegistry(1099);
                registry.list(); // Esto lanzará una excepción si no hay un registro en ejecución
            } catch (Exception e) {
                registry = LocateRegistry.createRegistry(1099);
            }
            registry.rebind("FacadeRemoto", f);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}