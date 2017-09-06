

public class CcValidation {

	public boolean isValid (String cardnumber){
		if(cardnumber.isEmpty())
			return false;
		else
		{
	    int sum = 0;
	    boolean alternate = false;
	    for (int i = cardnumber.length() - 1; i >= 0; i--) {
	        int n = Integer.parseInt(cardnumber.substring(i, i + 1));
	        if (alternate) {
	            n *= 2;
	            if (n > 9) {
	                n = (n % 10) + 1;
	            }
	        }
	        sum += n;
	        alternate = !alternate;
	    }
	    return (sum % 10 == 0);
		}
/*	    if(sum % 10 == 0)
	    	return 1;      // return if the answer is true or false
	    else
	    	return 0;*/
	}
}
