import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TransactionID {
    public static void main(String[] args) {

        TransactionID test1 = new TransactionID();

        test1.doMethod();

    }

    public int getCount() {

        int count = 0;
        try {
            if ( !new File("C:\\Users\\digja\\Documents\\Count.txt").exists())
                return 1;
            else {
                BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\digja\\Documents\\Count.txt")));
                String s = br.readLine();
                count = Integer.parseInt(s);
                br.close();
            }                
        } catch(Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void putCount(int count) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\digja\\Documents\\Count.txt")));
            bw.write(Integer.toString(count));
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String doMethod() { 
        Integer count = getCount(); 
        String s3;
    	Date date = new Date();
    	SimpleDateFormat dt1 = new SimpleDateFormat("ddMMyy");
    	String s1 = dt1.format(date);
    	s3=s1+count.toString();
        //System.out.println("You are running this program " + count + " number of times");
        count++;
        putCount(count); 
        return s3;
    }
}
	