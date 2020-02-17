package com.app.jdbc;

import java.sql.*;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceLocator {

	private static Context envContext = null;s
	private static ConcurrentMap<String, Object> cache;

	// Ensure that ServiceLocator cannot be publicly constructed
	private ServiceLocator() {
	}

	static {
		try {
			Hashtable<String, String> env = new Hashtable<String, String>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			envContext = new InitialContext(env);
			// envContext = (Context)ctx.lookup("java:/comp/env");
			cache = new ConcurrentHashMap<String, Object>();
		} catch (NamingException ne) {
			// logger.error("Error while creating Initial Context : ", ne);
		}
	}

	public static DataSource getDataSource(String datasourceName) throws WFMTRuntimeException {
		if (!cache.containsKey(datasourceName)) {
			DataSource dataSource = null;
			synchronized (ServiceLocator.class) {
				// Get the Datasource from context
				try {
					dataSource = (DataSource) envContext.lookup(datasourceName);
				} catch (NamingException ne) {
					// logger.error("Error while looking up datasource : " +
					// datasourceName, ne);
					throw new WFMTRuntimeException("Error while looking up datasource : " + datasourceName, ne);
				}
			}
			// update DataSource in cache
			// since cache is a ConcurrentMap, any new values added are safely
			// published
			cache.put(datasourceName, dataSource);
		}
		return (DataSource) cache.get(datasourceName);
	}
}
