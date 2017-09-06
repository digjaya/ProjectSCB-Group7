import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Application_transaction extends Remote{
	public void Data_retrieval_call (String t) throws RemoteException;
}
