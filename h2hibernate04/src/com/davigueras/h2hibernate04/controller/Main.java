package com.davigueras.h2hibernate04.controller;

import org.hibernate.Session;

import com.davigueras.h2hibernate04.model.Address;
import com.davigueras.h2hibernate04.model.Coche;
import com.davigueras.h2hibernate04.model.Libro;
import com.davigueras.h2hibernate04.model.Person;

/* Este ejemplo muestra una clase basica mapeada con la base de datos mediante
 * hibernate basadi en anotaciones, Ademas hay dos objetos mapeados con una
 * relacion de uno a uno entre si, y con borrado en cascada y demas. A??ado 
 * tambien otra relacio uno a muchos */

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
	    person1.setAddress(address2);  
	    
	    
	    
	    
	    Libro libro1 = new Libro(); 
	    libro1.setTitulo("20000 leguas de viaje submarino");  

	    Libro libro2 = new Libro(); 
	    libro2.setTitulo("La maquina del tiempo");  

 
	    person1.addLibro(libro1); 
	    person1.addLibro(libro2);   
	    
	    
	    
	    Coche coche1 = new Coche(); 
	    coche1.setTitulo("Ferrari");  

	    Coche coche2 = new Coche(); 
	    coche2.setTitulo("Ford");  

 
	    person1.addCoche(coche1); 
	    person1.addCoche(coche2);   
	    
	
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
	
	    /*En la segunda sesion eliminamos el objeto person1, 
	    la direccion1 sera borrada en cascada*/ 
	    session = HibernateUtil.getSessionFactory().openSession(); 
	    session.beginTransaction();  
	
	    session.delete(person2);  
	
	    session.getTransaction().commit(); 
	    session.close(); 
	}
}