
import java.sql.*;
class  Jdbc {

	private String a;
	 private String b;
  
public Jdbc() {
		super();
	}

public Jdbc(String a, String b) {
		super();
		this.a = a;
		this.b = b;
	}

public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

public  void h2(String a, String b)
{	
	
try{
	//System.out.println("gfghcjhgh");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","system","root");
String str="insert into test values(?,?)";
String ss="commit";
PreparedStatement stmt=con.prepareStatement(str);
stmt.setString(1,a);
stmt.setString(2,b);

PreparedStatement stmt1=con.prepareStatement(ss);

ResultSet rs=stmt.executeQuery();
ResultSet rs1=stmt1.executeQuery();

con.close();

}catch(Exception e){ System.out.println(e);}



}
}

		
	