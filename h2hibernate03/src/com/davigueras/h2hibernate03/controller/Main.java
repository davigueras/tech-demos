package com.davigueras.h2hibernate03.controller;

import org.hibernate.Session;

import com.davigueras.h2hibernate03.model.Person;
import com.davigueras.h2hibernate03.model.Address;

/* Este ejemplo muestra una clase basica mapeada con la base de datos mediante
 * hibernate basadi en anotaciones, Ademas hay dos objetos mapeados con una
 * relacion de uno a uno unidireccional (solo persona ve la relacion), y con 
 * borrado en cascada y demas. */

public class Main {
	
	public static void main(String[] args) {
		
	    Person person1 = new Person(); 
	    person1.setName("Persona que sera borrada");  
	
	    Person person2 = new Person(); 
	    person2.setName("Persona que permanecera");  
	
	    Address address1 = new Address(); 
	    address1.setStreet("Calle 1"); 
	    address1.setPostalCode("12345");  
	
	    Address address2 = new Address(); 
	    address2.setStreet("Calle 2"); 
	    address2.setPostalCode("54321");  
	
	    person1.setAddress(address1); 
	    person2.setAddress(address2);  
	
	    Session session = HibernateUtil.getSessionFactory().openSession();   
	
	    /*Esta direccion se agrega para comprobar que las persons tomen el mismo 
	    identificador que las direcciones*/ 
	    Address d = new Address(); 
	    d.setStreet("Calle de Prueba de identificadores"); 
	    d.setPostalCode("21345");   
	
	    /*En la primer sesion a la base de datos almacenamos los dos objetos Person 
	    los objetos Direccion se almacenaran en cascada*/ 
	    session.beginTransaction();  
	
	    session.persist(d); 
	    session.persist(person1); 
	    session.persist(person2);  
	
	    session.getTransaction().commit(); 
	    session.close();   
	
	    /*En la segunda sesion eliminamos el objeto person2, 
	    la direccion1 sera borrada en cascada*/ 
	    session = HibernateUtil.getSessionFactory().openSession(); 
	    session.beginTransaction();  
	
	    session.delete(person2);  
	
	    session.getTransaction().commit(); 
	    session.close(); 
	}
}