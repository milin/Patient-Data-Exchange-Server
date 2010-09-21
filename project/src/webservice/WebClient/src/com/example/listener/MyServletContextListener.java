package com.example.listener;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;




public class MyServletContextListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent event){
			System.out.println("contextInitialized() method is invoked.");
			try{
				ServletContext servletContext=event.getServletContext(); 
				String email=servletContext.getInitParameter("email");
				//Emailer emailer=new Emailer(email);
				//servletContext.setAttribute("emailer", emailer);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
	}


	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed() method is invoked.");
		
		}
	}