package com.example.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Online;
import com.example.model.Provider;
import com.example.model.ProviderStaff;
import com.example.persistence.HibernateUtil;

/**
 * Listener that keeps track of the number of sessions that the Web application
 * is currently using and has ever used in its life cycle.
 */

public class SessionCounter implements HttpSessionAttributeListener  {

	private static Logger logger=Logger.getLogger(SessionCounter.class);

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {

		logger.debug("@ Line: 91 @@@@@@@@@@@@ Add Session Attribute : " + arg0.getName() + " : " + arg0.getValue());

		logger.debug("_------------------HttpSessionAttributeListener---------------------------__" );


		if (arg0.getName().equals("User")) {
			ProviderStaff providerStaffSession = (ProviderStaff) arg0.getValue();
			logger.debug("_---------------------HttpSessionAttributeListener-------------------------__" +providerStaffSession.getContactName());
			//Provider provider = (Provider) ;
			//if (provider.getId() != 0l) {
			// session = HibernateUtil.getSessionFactory().getCurrentSession();
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			ProviderStaff providerStaff=(ProviderStaff) session.get(ProviderStaff.class, providerStaffSession.getId());
			Provider provider=(Provider) session.get(Provider.class, providerStaff.getProvider().getId());
			Online online = new Online();
			Date createdOn = new Date();
			logger.debug("_---------------------usercreatedOncreatedOncreatedOncreatedOncreatedOncreatedOn------------------------__" +createdOn);
			provider.setStatusOnline(1);
			online.setProviderStaff(providerStaff);
			online.setOnlineTime(createdOn);
			online.setProvider(provider);
			session.save(provider);
			session.save(online);
			logger.debug("_---------------------user--ssss----------------------__" +provider.getName());
			tx.commit();	
			//}		
		}
	}


	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {		

		logger.debug("@ Line: 119 @@@@@@@@@@@@ Remove Session Attribute : " + arg0.getName() + " : " + arg0.getValue());
	
	//	logger.debug("_-----------------------out-----99------------------__" +providerStaffSession.getName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			if (arg0.getName().equals("User")) {
				ProviderStaff providerStaffSession = (ProviderStaff) arg0.getValue();
				Provider provider=(Provider) session.get(Provider.class, providerStaffSession.getProvider().getId());
				
				logger.debug("_-----------------------out-----99------00000000000000000000------------__" +provider.getName());
				//Provider provider = (Provider) arg0.getValue();		
				logger.debug("_-----------------------out-----100------00000000000000000000------------__" +provider.getId());
				//String strQuery ="select on from Online on where ou.providerId="+provider.getId();
				//logger.debug("_-----------------------out-----101------00000000000000000000----strQuery--------__" +strQuery);
				//String strQuery = "select on from Online on where on.provider.id=:userId";
				String strQuery ="from Online o where o.provider.id=:providerId and  o.offlineTime =Null)";
				//List country = session.createQuery("from Country c").list();
				//Query query = session.createQuery(strQuery);
				//String strQuery = "select ou from OnlineUser ou where ou.user.id=:userId";
				//Query query = session.createQuery(strQuery);
				
				Query query = session.createQuery(strQuery);
				query.setLong("providerId", provider.getId());
				//List<OnlineUser> onlineUsers = query.list();
				//Query query = session.createQuery("select on from Online");
				//logger.debug("_-----------------------out-----102------00000000000000000000------------__" +provider1.getName());
				//query.setLong("providerId", provider.getId());
				//Query query = session.createQuery("from Online on");
				logger.debug("_-----------------------out-----103------00000000000000000000------------__" +provider.getName());
				List<Online> onlines = query.list();
				logger.debug("_-----------------------setLong()------00000000000000000000------------__" +onlines.size());
				
				logger.debug("@ Line: 133 @@@@@@@@@@@@ Remove Session Attribute00000000000000000 : " + arg0.getName() + " : " + arg0.getValue());
				for (Online online : onlines) {	
					online.setOfflineTime(new Date());
					//session.delete(online);
					logger.debug("@ Line: 136 @@@@@@@@@@@@ Remove Session Attribute000000000000000 : " + arg0.getName() + " : " + arg0.getValue());
				}
				provider.setStatusOnline(0);
				tx.commit();				
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug(e.getStackTrace().toString());
			logger.debug(e); 
			tx.rollback();
		} finally {
			session.close();
		}	
	}


	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		logger.debug("@ Line: 153 @@@@@@@@@@@@ Replace Session Attribute : " + arg0.getName() + " : " + arg0.getValue());
		Provider provider1 = (Provider) arg0.getValue();
		if (arg0.getName().equals("User")) {
			Provider sesProvider = (Provider) arg0.getValue();
			//logger.debug("_---------------------user-------------------------__" +provider.getName());
			//Provider provider = (Provider) ;
			//if (provider.getId() != 0l) {
			// session = HibernateUtil.getSessionFactory().getCurrentSession();
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Provider provider=(Provider) session.get(Provider.class, sesProvider.getId());
			Online online = new Online();
			Date createdOn = new Date();
			
			provider.setStatusOnline(1);
			online.setOnlineTime(createdOn);
			online.setProvider(provider);
			session.save(provider);
			session.save(online);
			logger.debug("_---------------------usercreatedOncreatedOncreatedOncreatedOncreatedOncreatedOn------------------------__" +createdOn);
			tx.commit();	
			//}		
		}
	}
}
