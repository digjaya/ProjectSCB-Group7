

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainRegistry {

	public static void main(String[] args) throws AccessException, RemoteException {
		System.setSecurityManager(new SecurityManager());
		// TODO Auto-generated method stub
		
	Registry registry = LocateRegistry.createRegistry(5614);
		Token tokencall = new Token();
		registry.rebind("scb", tokencall);
		Registry registry1 = LocateRegistry.createRegistry(56026);
		Jdbc_retrieval jr=new Jdbc_retrieval();
		registry1.rebind("scb1", jr);
		//System.out.println();


	}

}
