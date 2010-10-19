package com.example.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;

import com.example.test.testAction;

public class FileWrite 
{
	private Logger logger=Logger.getLogger(FileWrite.class);
	 public  void Write()
	  {
		
		  
		      try{
		    // Create file 
		    	  File file = new File ( "/tmp/bamboo.txt" );
		    	  if ( file.createNewFile () )
		    	  {
		    	       System.out.println ( "Make File Success." );
		    	  }
		      }catch (Exception e){//Catch exception if any
		          System.err.println("Error: " + e.getMessage());
		        }
	  }
	
}