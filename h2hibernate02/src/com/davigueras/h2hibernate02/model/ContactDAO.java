package com.davigueras.h2hibernate02.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.davigueras.h2hibernate02.controller.HibernateUtil;

public class ContactDAO {
	
	private Session session;
	private Transaction transaction;

	private void startOperation() throws HibernateException	{
	    session = HibernateUtil.getSessionFactory().openSession();
	    transaction = session.beginTransaction();
	}
	
	private void handleException(HibernateException he) throws HibernateException {
	    transaction.rollback();
	    throw new HibernateException("Ocurri?? un error en la capa de acceso a datos", he);
	}
	
	public long saveContact(Contact contact) { 
	    long id = 0;  

	    try { 
	        startOperation(); 
	        id = (Long) session.save(contact); 
	        transaction.commit(); 
	    } catch (HibernateException he) { 
	        handleException(he);
	        throw he; 
	    } finally { 
	        session.close(); 
	    }  
	    return id; 
	}
	
	public void updateContact(Contact contact) throws HibernateException { 
	    try { 
	        startOperation(); 
	        session.update(contact); 
	        transaction.commit(); 
	    } catch (HibernateException he) { 
	        handleException(he); 
	        throw he; 
	    } finally { 
	        session.close(); 
	    } 
	}
	
	public void deleteContacto(Contact contact) throws HibernateException { 
	    try { 
	        startOperation(); 
	        session.delete(contact); 
	        transaction.commit(); 
	    } catch (HibernateException he) { 
	        handleException(he); 
	        throw he; 
	    } finally { 
	        session.close(); 
	    } 
	}
	
	public Contact getContact(long idContact) throws HibernateException { 
	    Contact contact = null;  

	    try { 
	        startOperation(); 
	        contact = (Contact) session.get(Contact.class, idContact); 
	    } finally { 
	        session.close(); 
	    }  
	    return contact; 
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getContactsList() throws HibernateException { 
	    List<Contact> contactsList = null;  
	    
	    try { 
	        startOperation(); 
	        contactsList = session.createQuery("from Contact").list(); // Esta query es creada en HQL (hibernate query language)
	    } finally { 
	        session.close(); 
	    }  

	    return contactsList; 
	}
}
