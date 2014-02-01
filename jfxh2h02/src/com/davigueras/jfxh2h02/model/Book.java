package com.davigueras.jfxh2h02.model;

public class Book {
	
	private int id;
	private String title;
	private Author author;
	private Publisher publisher;
	private String genre;
	
	public Book() {
		
	}
	
	public Book(int id, String title, Author author, Publisher publisher, String genre) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
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
	}
	public String getAuthorName() {
		return author.getName();
	}	
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
