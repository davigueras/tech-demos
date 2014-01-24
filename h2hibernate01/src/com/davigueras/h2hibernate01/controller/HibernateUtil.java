package com.davigueras.h2hibernate01.controller;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	
	static { // Bloque de inicializacion estatico
	    try { 
	        Configuration configuration = new Configuration();
	        configuration.configure();
	        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();  
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    } catch (HibernateException he) { 
	        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
	        throw new ExceptionInInitializerError(he); 
	    } 
	}
	
	public static SessionFactory getSessionFactory() { 
	    return sessionFactory;
	} 
}
