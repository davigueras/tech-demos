package com.davigueras.h2hibernate05.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity 
public class Address implements Serializable {     
	
	private static final long serialVersionUID = 7245705272608280089L;

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private long id; 

    private String street; 
    private String postalCode;  
    
    @ManyToOne
    private Person person;

    public Address() { 
    }  

    public long getId() { 
        return id; 
    }  

    protected void setId(long id) { 
        this.id = id; 
    }  

    public String getStreet() { 
        return street; 
    }  

    public void setStreet(String street) { 
        this.street = street; 
    }  

    public String getPostalCode() { 
        return postalCode; 
    }  

    public void setPostalCode(String postalCode) { 
        this.postalCode = postalCode; 
    } 
    
    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }
}


