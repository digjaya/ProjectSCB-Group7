

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;


public class Encryption {
	 // password for encryption
	Cipher cipher;
	static String input;
	  final static String strPassword = "password12345678";
	  // put this as key in AES
	  
	  static SecretKeySpec key = new SecretKeySpec(strPassword.getBytes(), "AES");
	 
	  public String enc(String h) throws Exception{
		  
		  input=h;
		  
	 
	     // Parameter specific algorithm
	    AlgorithmParameterSpec paramSpec = new IvParameterSpec(strPassword.getBytes()); 
	    //Whatever you want to encrypt/decrypt
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	 
	    // You can use ENCRYPT_MODE (ENCRYPTunderscoreMODE)  or DECRYPT_MODE (DECRYPT underscore MODE) 
	    cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec); 
	 
	    // encrypt data 
	     byte[] encrypted = cipher.doFinal(input.getBytes());
	 
	     // encode data using standard encoder
	     String output =  new BASE64Encoder().encode(encrypted);
	 
	 
	     return output;
	 
	      }
	 
	 }


