package com.davigueras.h2hibernate03.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity 
public class Person implements Serializable { 

	private static final long serialVersionUID = -4039042646116442668L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id; 
    private String name;  
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) 
    private Address address;  

    public Person() { 
    }  
    
    public long getId() { 
        return id; 
    }  

    protected void setId(long id) { 
        this.id = id; 
    } 
    
    public String getName() { 
        return name; 
    }  

    public void setName(String name) { 
        this.name = name; 
    }  
    
    public Address getAddress() { 
        return address; 
    }  

    public void setAddress(Address address) { 
        this.address = address; 
    }  

}
