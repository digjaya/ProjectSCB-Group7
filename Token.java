
import java.lang.Character.Subset;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.*;
public class Token extends UnicastRemoteObject implements TokenGenerationInterface {
	protected Token() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cc;
	String r1="xxxxxxxxxxxxx";
	String h;
	String name;
	String expiry_date;
	String cvv;
	long  amount;
	String t_id;
	Random randomGenerator = new Random();
	 int a=0;
	 String b;
	 char c1[]=new char[3];
	 int x=13;
	 char alpi[]=new char[13];
	 String ss;
	   
     int randomInt ;
     int randomInt2 ;

	public  String tok(String t_id,String cc,String cvv,String expiry_date,String name,Long amount) {

		this.cc=cc;	
		this.name=name;
		this.expiry_date=expiry_date;
		this.cvv=cvv;
		this.amount=amount;
		this.t_id=t_id;
		
		

		char[][]alp={
				{'1','7','9','3','5','4','6','8','2','0'},
				{'2','5','8','7','4','3','9','6','0','1'},
				{'5','2','7','3','0','1','4','8','9','6'},
				{'9','5','1','2','6','3','0','4','7','8'},
				{'1','4','7','8','9','6','3','2','5','0'},
				{'3','1','0','2','7','6','8','4','5','9'},
				{'0','1','4','6','3','9','7','8','2','5'},
				{'7','5','3','9','1','0','6','4','2','8'},
				{'9','8','5','2','3','6','7','4','1','0'},
				{'0','2','3','1','6','8','7','4','9','5'} 
		};
		
	      /*while(cc.charAt(a)!=('\0'))
{  
	  randomInt = randomGenerator.nextInt(10);
      randomInt2 = randomGenerator.nextInt(10);
	//System.out.println(randomInt);
	    //  System.out.println(randomInt2);
	      
	      alpi[a]=alp[randomInt][randomInt2];
a++;
//System.out.println(alpi[a]);
	      if(a==13)
	    	  break;
	     
}*/
		for(int k=0;k<=12;k++)
		{
			 randomInt = randomGenerator.nextInt(10);
		      randomInt2 = randomGenerator.nextInt(10);
		      alpi[k]=alp[randomInt][randomInt2];
		}
		
		
 b=new String(alpi);
/* for(int i=0;cc.charAt(x)!=('\0');i++)
 {
	 c1[i]=cc.charAt(x);
	 //System.out.println(c1);
 x++;
 if(x==16)
	 break;
 }*/
 /*for(int i=13;i<=15;i++)
 {
	 c1[i]=cc.charAt(x);
 }*/
 
 ss=cc.substring(13,16);
 String xd=new String(ss);

 String r=b.concat(xd);
 //System.out.println(r);
 Token1 c=new Token1();
 c.setCc(r);
 c.setCvv(cvv);
 c.setExpiry_date(expiry_date);
 c.setName(name);
 c.setAcc(cc);
 c.setAmount(amount);
 c.setT_id(t_id);
  try {
	c.fn1();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
h=r1.concat(xd);
//System.out.println(r);

return r;
	 
 
 
 
 

	}

}
