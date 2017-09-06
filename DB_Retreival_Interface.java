

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DB_Retreival_Interface extends Remote {
	public void  Db_retrieve(String tt) throws RemoteException;
}
