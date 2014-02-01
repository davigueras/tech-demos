package com.davigueras.jfxh2h02.model;

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
public class Author {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String country;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="author") // Bidireccional
    private List<Book> books = new ArrayList<Book>(); 

	public Author() {
	}
	
	public Author(String name, String country) {
		this.name = name;
		this.country = country;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public void addBook(Book book) {
		this.books.add(book);
	}

}
