import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class TokenSend {
	
	public void Hello(String t) throws RemoteException{
		String abcd;
		abcd = t;
	System.setSecurityManager(new SecurityManager());
	Registry registry22 = LocateRegistry.getRegistry("192.168.1.103", 7010);
	Application_transaction bank22 = null;
	try {
		bank22 = (Application_transaction)(registry22.lookup("scb2"));
	} catch (NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    bank22.Data_retrieval_call(abcd);
	}
}
