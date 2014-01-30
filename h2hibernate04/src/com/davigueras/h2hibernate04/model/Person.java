package com.davigueras.h2hibernate04.model;

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
import javax.persistence.OneToOne;

@Entity 
public class Person implements Serializable { 

	private static final long serialVersionUID = -4039042646116442668L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id; 
    private String name;  
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) // uno a mucho unidireccional, solo person lo ve
    private List<Address> addresses = new ArrayList<Address>(); 
    
    
    //@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="persona") // uno amuchos bidireccional, coche ve su propietario
    //private List<Coche> coches = new ArrayList<Coche>();

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
    
    public List getAddress() { 
        return addresses; 
    }  

    public void setAddress(List addresses) { 
        this.addresses = addresses; 
    }  

    public void addAddress(Address address) 
    { 
        this.addresses.add(address); 
    } 
    

}
