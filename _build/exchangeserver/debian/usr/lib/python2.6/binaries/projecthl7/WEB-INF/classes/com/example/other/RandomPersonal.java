package com.example.other;

import java.util.Random;

import org.apache.log4j.Logger;




public class RandomPersonal {
	private static Logger logger = Logger.getLogger(RandomPersonal.class);
	
	public String username(){
		StringBuffer xxx = new StringBuffer();
		Random random = new Random(); 
		String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//char xxx=c.charAt(random.nextInt(100));
		 StringBuffer username = new StringBuffer();
		
		while (username.length() < 8) {
			username.append(c.charAt(random.nextInt(52)));
		}
		return username.toString();
	}	
	
	public String password(){
		StringBuffer xxx = new StringBuffer();
		Random random = new Random(); 
		String p= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer password = new StringBuffer();
		while (password.length() < 10) {
			password.append(p.charAt(random.nextInt(62)));
		}
		return password.toString();
	}
}
