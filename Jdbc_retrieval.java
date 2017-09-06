

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Jdbc_retrieval extends UnicastRemoteObject implements DB_Retreival_Interface {
	protected Jdbc_retrieval() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String credit_card1;
 private String name1;
private String expiry_date1;
 private String cvv1;
 String acc1;
 String b1;
 Long amount1;
 String t_id1;
 String tt;
 String dec;

public void Db_retrieve(String tt) throws RemoteException
	{ 
	Decryption d=new Decryption();
	//Decryption1 d1 = new Decryption1();
	this.tt=tt;
	//System.out.println(tt);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","system","root");
			//String str = "select * from cus";
			String str="select * from t where token like ?";
			PreparedStatement stmt=con.prepareStatement(str);
			stmt.setString(1,tt);
			ResultSet rs=stmt.executeQuery();
			//System.out.println(rs.getRow());
			if (rs==null) {
			    System.out.println("no data");
			} 
			while(rs.next()){
			acc1=rs.getString("credit_card");
			amount1=rs.getLong("amount");
			t_id1=rs.getString("transaction_id");
			name1=rs.getString("name");
			cvv1=rs.getString("cvv");
			expiry_date1=rs.getString("expiry_date");




			}
			dec=d.dec(acc1);
			System.out.println("decrypted value credit card number " +dec);
			//System.out.println("credit card" +acc1);
			System.out.println("Transaction amount " + amount1);
			System.out.println("Name " + name1);
			System.out.println("Transaction ID " + t_id1);
			System.out.println("Expiry date " +expiry_date1);
			System.out.println("CVV Code" +cvv1);
			
			//System.out.println();
			
			con.close();
			

			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		//return new Jdbc_retrieval();
		
	}

}
