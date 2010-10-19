package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.persistence.HibernateUtil;

public class MyServletContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent event){
		System.out.println("contextInitialized() method is invoked.");
	//	Util.servletContext = event.getServletContext();
	}
	
	public void contextDestroyed(ServletContextEvent event){
		System.out.println("contextDestroyed() method is invoked.");
		HibernateUtil.shutdown();
	}
	
}
