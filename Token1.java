

import java.sql.SQLException;

public class Token1 {
	
	String name;
	String expiry_date;
	String cvv;
	String cc;
	String acc;
	Long amount;
	String t_id;
	
	
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Token1(String name, String expiry_date, String cvv, String cc,String acc,String t_id) {
		
		this.name = name;
		this.expiry_date = expiry_date;
		this.cvv = cvv;
		this.cc = cc;
		this.acc=acc;
		this.t_id=t_id;
	}
	 
	public Token1() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getAcc() {
		return acc;
	}
	public void setAcc(String acc) {
		this.acc = acc;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public Long getAmount() {
		return amount;
	}
	void fn1() throws Exception
	{
		//System.out.println(name);
		//String str=new String();
		//str.concat(cc);
		//Object t_id;
		Jdbc t=new Jdbc(cc,acc,name,expiry_date,cvv,amount,t_id);
	    t.h2();
	}
	
    
	

}
