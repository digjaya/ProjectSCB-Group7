

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PaymentDetails abc = new PaymentDetails();
		int valid1 = 0,valid2 = 0;
		String name=request.getParameter("name");
		abc.setName(name);
		String cardnumber1=request.getParameter("cardnumber");
		String cardnumber = cardnumber1.replaceAll("\\s+","");
		CcValidation a = new CcValidation();
		boolean x = a.isValid(cardnumber);
		if(x==true){
			valid1=1;
			abc.setCardnumber(cardnumber);
		}
		else if (x==false)
			valid1=0;
		//System.out.println(valid1);
		
		String expirydate1=request.getParameter("expirydate");
		//System.out.println(expirydate1);
		String expirydate = expirydate1.replaceAll("\\s+","");
		//System.out.println(expirydate);
		EdValidation b = new EdValidation();
		try {
			valid2=b.isDatevalid(expirydate);  //calling the function for validation
			if(valid2==1)
			abc.setExpirydate(expirydate);
			else
				System.out.println("Error on date validation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in date");
			//e.printStackTrace();
		}
		//System.out.println(valid2);
		
		
		String cvv=request.getParameter("cvv");
		abc.setCvv(cvv);
		
		String amount1 = request.getParameter("amount");
		long amount;
		amount = Long.parseLong(amount1);
		abc.setAmount(amount);
		
		TransactionID c = new TransactionID();
		String tid = c.doMethod();
		
		abc.setTransactionid(tid);
		String abcd = null;
		if((valid1==1) && (valid2==1))
		{
		System.setSecurityManager(new SecurityManager());
		Registry registry = LocateRegistry.getRegistry("192.168.1.102", 5614); //IP Address And Port from Server
		TokenGenerationInterface bank = null;
		try {
			bank = (TokenGenerationInterface)(registry.lookup("scb"));
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			abcd = bank.tok(abc.getTransactionid(),abc.getCardnumber(), abc.getCvv(), abc.getExpirydate(), abc.getName(), abc.getAmount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(abcd);
		
		}
		Jdbc hello = new Jdbc();
		hello.h2(tid, abcd);
				
		
		Registry registry = LocateRegistry.getRegistry("192.168.1.101", 8016);
		BankInter bank = null;
		try {
			bank = (BankInter)(registry.lookup("scb2"));
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bank.add(abcd);
		
	}

	}
		

