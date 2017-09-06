import java.rmi.Remote;
import java.rmi.RemoteException;


public interface BankInter extends Remote {
		
	void add(String a)throws RemoteException;
}
