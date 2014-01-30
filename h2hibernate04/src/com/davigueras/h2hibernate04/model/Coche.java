package com.davigueras.h2hibernate04.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Coche implements Serializable
{
	private static final long serialVersionUID = 3081163845440197211L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String titulo;

    @ManyToOne // para permitirle descubrir su poseedor
    private Person persona; // necesita sus setters i getters

    public Coche()
    {
    }

    public long getId()
    {
        return id;
    }

    protected void setId(long id)
    {
        this.id = id;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public Person getPersona()
    {
        return persona;
    }

    public void setPersona(Person persona)
    {
        this.persona = persona;
    }
}