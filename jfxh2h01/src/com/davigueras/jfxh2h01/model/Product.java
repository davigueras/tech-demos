package com.davigueras.jfxh2h01.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

@Entity 
public class Product implements Serializable {

	private static final long serialVersionUID = 4930748095081778436L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String ref;
	private String name;
	
	private String issueDate; // String por ahora a falta de aclarar la mejor forma de representar una fecha.
	
	private double cost;
	private int productionMinutes;
	
    public Product() { 
    }  
	
	public Product(String ref, String name, String issueDate, double cost, int productionMinutes) {
		this.ref = ref;
		this.name = name;
		this.issueDate = issueDate;
		this.cost = cost;
		this.productionMinutes = productionMinutes;
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getProductionMinutes() {
		return this.productionMinutes;
	}

	public void setProductionMinutes(int productionMinutes) {
		this.productionMinutes = productionMinutes;
	}

}
