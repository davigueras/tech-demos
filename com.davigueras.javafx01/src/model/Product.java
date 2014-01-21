package model;

import java.sql.Date;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
	private SimpleIntegerProperty id;
	private SimpleStringProperty ref;
	private SimpleStringProperty name;
	
	private SimpleStringProperty issueDate; // String por ahora a falta de aclarar la mejor forma de representar una fecha.
	
	private SimpleDoubleProperty cost;
	private SimpleIntegerProperty productionMinutes;
	
	public Product(int id, String ref, String name, String issueDate, double cost, int productionMinutes) {
		this.id = new SimpleIntegerProperty(id);
		this.ref = new SimpleStringProperty(ref);
		this.name = new SimpleStringProperty(name);
		this.issueDate = new SimpleStringProperty(issueDate);
		this.cost = new SimpleDoubleProperty(cost);
		this.productionMinutes = new SimpleIntegerProperty(productionMinutes);
	}

	public int getId() {
		return this.id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public String getRef() {
		return this.ref.get();
	}

	public void setRef(String ref) {
		this.ref.set(ref);
	}

	public String getName() {
		return this.name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getIssueDate() {
		return this.issueDate.get();
	}

	public void setIssueDate(String issueDate) {
		this.issueDate.set(issueDate);
	}

	public double getCost() {
		return this.cost.get();
	}

	public void setCost(double cost) {
		this.cost.set(cost);
	}

	public int getProductionMinutes() {
		return this.productionMinutes.get();
	}

	public void setProductionMinutes(int productionMinutes) {
		this.productionMinutes.set(productionMinutes);
	}
	

}
