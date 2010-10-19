package com.example.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceLocator {

	private InitialContext initialContext;
	private Map cache;

	private static ServiceLocator _instance;

	static {
		try {
			_instance = new ServiceLocator();
		} catch (ServiceLocatorException se) {
			System.err.println(se);
			se.printStackTrace(System.err);
		}
	}

	private ServiceLocator() throws ServiceLocatorException {
		try {
			initialContext = new InitialContext();
			cache = Collections.synchronizedMap(new HashMap());
		} catch (NamingException ne) {
			throw new ServiceLocatorException(ne);
		} catch (Exception e) {
			throw new ServiceLocatorException(e);
		}
	}

	static public ServiceLocator getInstance() {
		return _instance;
	}

	public DataSource getDataSource(String dataSourceName)
			throws ServiceLocatorException {
		DataSource dataSource = null;
		try {
			if (cache.containsKey(dataSourceName)) {
				dataSource = (DataSource) cache.get(dataSourceName);
			} else {
				dataSource = (DataSource) initialContext.lookup(dataSourceName);
				cache.put(dataSourceName, dataSource);
			}
		} catch (NamingException nex) {
			throw new ServiceLocatorException(nex);
		} catch (Exception ex) {
			throw new ServiceLocatorException(ex);
		}
		return dataSource;
	}

}
