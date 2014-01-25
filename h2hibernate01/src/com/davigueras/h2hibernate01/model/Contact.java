package com.davigueras.h2hibernate01.model;

import java.io.Serializable;

public class Contact implements Serializable {
	
	private static final long serialVersionUID = 4067741303617298672L;
	
	private long id;
    private String name;
    private String email;
    private String telephone;

    public Contact() {
    }

    public Contact(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
}