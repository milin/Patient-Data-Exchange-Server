//package com.example.test;
//
//import java.io.UnsupportedEncodingException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//import sun.misc.BASE64Encoder;
//
////import com.omb.onlineclub.test.OneWayEncrypt;
//
//public class OneWayEncrypt {
//	  private static OneWayEncrypt instance;
//
//	  private OneWayEncrypt()
//	  {
//	  }
//
//	  public synchronized String encrypt(String plaintext) //throws SystemUnavailableException
//	  {
//	    MessageDigest md = null;
//	    try
//	    {
//	      md = MessageDigest.getInstance("SHA"); //step 2
//	    }
//	    catch(NoSuchAlgorithmException e)
//	    {
//	      //throw new SystemUnavailableException(e.getMessage());
//	    }
//	    try
//	    {
//	      md.update(plaintext.getBytes("UTF-8")); //step 3
//	    }
//	    catch(UnsupportedEncodingException e)
//	    {
//	      //throw new SystemUnavailableException(e.getMessage());
//	    }
//
//	    byte raw[] = md.digest(); //step 4
//	    String hash = (new BASE64Encoder()).encode(raw); //step 5
//	    return hash; //step 6
//	  }
//	  
//	  public static synchronized OneWayEncrypt getInstance() //step 1
//	  {
//	    if(instance == null)
//	    {
//	       instance = new OneWayEncrypt(); 
//	    } 
//	    return instance;
//	  }
//	}
