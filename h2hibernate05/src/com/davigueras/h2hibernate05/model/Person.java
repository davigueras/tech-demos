package com.davigueras.h2hibernate05.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Person implements Serializable { 

	private static final long serialVersionUID = -4039042646116442668L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id; 
    private String name;  
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="person") // uno amuchos bidireccional, address ve su propietario
    private List<Address> addresses = new ArrayList<Address>(); 

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
    
    public List<Address> getAddress() { 
        return addresses; 
    }  

    public void setAddress(List<Address> addresses) { 
        this.addresses = addresses; 
    }  

    public void addAddress(Address address) 
    { 
        this.addresses.add(address); 
    } 
    

}
