

import java.sql.*;

class  Jdbc{

	private String credit_card;
	 private String name;
	private String expiry_date;
     private String cvv;
     String acc;
     String b;
     Long amount;
     String t_id;

 	private String credit_card1;
 	 private String name1;
 	private String expiry_date1;
      private String cvv1;
      String acc1;
      String b1;
      Long amount1;
      String t_id1;
      String enc;
      
     Encryption e=new Encryption();
     
    
      public Jdbc(String credit_card,String acc, String name, String expiry_date,String cvv,Long amount,String t_id) throws Exception {
	
		this.credit_card = credit_card;
		this.name = name;
		this.expiry_date = expiry_date;
		this.cvv = cvv;
		this.acc=acc;
		this.amount=amount;
		this.t_id=t_id;
		enc=e.enc(acc);
		
		
		//b=credit_card.substring(13,16);
		 //System.out.println(b);
	}
     
public  void h2()
{	
	
try{
	//System.out.println("gfghcjhgh");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","system","root");
String str="insert into t values(?,?,?,?,?,?,?)";
String ss="commit";
PreparedStatement stmt=con.prepareStatement(str);
stmt.setString(1,name);
stmt.setString(2,cvv);
stmt.setString(3,expiry_date);
stmt.setString(4,enc);
stmt.setString(5,credit_card);
stmt.setString(6,t_id);
stmt.setFloat(7,amount);

PreparedStatement stmt1=con.prepareStatement(ss);

//System.out.println("kill");

ResultSet rs=stmt.executeQuery();
ResultSet rs1=stmt1.executeQuery();

//System.out.println(rs.getRow());
/*if (!rs.next() ) {
    System.out.println("no data");
} 
while(rs.next()){
System.out.println(rs.getString("credit_card"));




}
//System.out.println(c);
*/
con.close();

}catch(Exception e){ System.out.println(e);}



}
void h3()
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","system","root");
		String str="select * from t where credit_card like '%"+b+"'";
		PreparedStatement stmt=con.prepareStatement(str);
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
		/*System.out.println(acc1);
		System.out.println(amount1);
		System.out.println(name1);
		System.out.println(t_id1);
		System.out.println(expiry_date1);
		System.out.println(cvv1);
		*/
		con.close();
		

		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}
}

		
	