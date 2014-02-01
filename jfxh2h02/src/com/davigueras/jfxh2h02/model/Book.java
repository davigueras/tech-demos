package com.davigueras.jfxh2h02.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	@ManyToOne
	private Author author;
	@ManyToOne
	private Publisher publisher;
	private String genre;
	
	public Book() {
	}
	
	public Book(String title, Author author, Publisher publisher, String genre) {
		this.title = title;
		this.author = author;
		this.author.addBook(this);
		this.publisher = publisher;
		this.publisher.addBook(this);
		this.genre = genre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
		this.author.addBook(this);
	}
	public String getAuthorName() {
		return author.getName();
	}	
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
		this.publisher.addBook(this);
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
