package com.example.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Online;
import com.example.persistence.HibernateUtil;

public class MySessionListener implements HttpSessionListener {

    public MySessionListener() {
    }

    public void sessionCreated(HttpSessionEvent sessionEvent) {

        // Get the session that was created
    HttpSession session2 = sessionEvent.getSession();

        // Store something in the session, and log a message
        try {
        	
        	
          //  System.out.println("[MySessionListener] Session created: "+session);
            
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            
			Online online=new Online();
			online.setOnlineTime(new Date());
		//	online.setProviderName();
			/*LoginSystem login=new LoginSystem();
			login.setHospitalUserName("username");
			login.setLoginDate(new Date());*/
			session.save(online);
			//tx.co
           // session.setAttribute("foo", "bar");
        } catch (Exception e) {
            System.out.println("[MySessionListener] Error setting session attribute: " + e.getMessage());
        }
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent) {

        // Get the session that was invalidated
        HttpSession session = sessionEvent.getSession();

        // Log a message
        System.out.println("[MySessionListener] Session invalidated: "+session);
        System.out.println("[MySessionListener] Value of foo is: " + session.getAttribute("foo"));
    }
}


