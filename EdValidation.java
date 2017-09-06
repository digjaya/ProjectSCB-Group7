

import java.text.SimpleDateFormat;
import java.util.Date;

public class EdValidation {
	public int isDatevalid (String expirydate) throws Exception{

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
	    simpleDateFormat.setLenient(false);
	    Date expiry = simpleDateFormat.parse(expirydate);
	    boolean expired = expiry.before(new Date());
	    if (expired == true)
	    {
	       return 0;
	    }
	    else
	    {
	    	return 1;
	    }
}
}