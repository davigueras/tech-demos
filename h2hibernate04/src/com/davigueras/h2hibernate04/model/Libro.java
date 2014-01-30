package com.davigueras.h2hibernate04.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Libro implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String titulo;

    public Libro()
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
}