import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface TokenGenerationInterface extends Remote {
	public  String tok(String t_id,String cc,String cvv,String expiry_date,String name,Long amount)throws RemoteException, SQLException;
}
