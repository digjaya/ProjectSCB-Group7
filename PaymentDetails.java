
public class PaymentDetails {
	/**
	 * 
	 */
	private String name;
	private String cardnumber;
	private String expirydate;
	private String cvv;
	private long amount;
	private String transactionid ;
	public PaymentDetails(String name, String cardnumber, String expirydate,
			String cvv, long amount, String transactionid) {
		super();
		this.name = name;
		this.cardnumber = cardnumber;
		this.expirydate = expirydate;
		this.cvv = cvv;
		this.amount = amount;
		this.transactionid = transactionid;
	}
	
	public PaymentDetails() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	
}
