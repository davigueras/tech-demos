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
    
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) // uno a uno unidireccioal
    private Address address;  
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) // uno a mucho unidireccional, solo person lo ve
    private List<Libro> libros = new ArrayList<Libro>();
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="persona") // uno amuchos bidireccional, coche ve su propietario
    private List<Coche> coches = new ArrayList<Coche>();

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
    
    public List getLibros() 
    { 
        return libros; 
    }  

    public void setLibros(List libros) 
    { 
        this.libros = libros; 
    }  

    public void addLibro(Libro libro) 
    { 
        this.libros.add(libro); 
    } 
    
    public List getCoches() 
    { 
        return coches; 
    }  

    public void setCoches(List coches) 
    { 
        this.coches = coches; 
    }  

    
    public void addCoche(Coche coche)
    {
        this.coches.add(coche);
    }
}
