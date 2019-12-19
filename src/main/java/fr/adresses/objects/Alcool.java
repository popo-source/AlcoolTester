package fr.adresses.objects;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Alcool {
	private final StringProperty alcoolName;
	private final DoubleProperty degree;
	private final DoubleProperty quantity;
	
	 public Alcool() {
	        this(null, 0.0);
	    }
	 
	public Alcool(String alcoolName, Double degree) {
		this.alcoolName = new SimpleStringProperty(alcoolName);
		this.degree = new SimpleDoubleProperty(degree);
		this.quantity = new SimpleDoubleProperty(0);
		
	}

	
	public String getAlcoolName() {
		return alcoolName.get();
	}
	public void setAlcoolName(String alcoolName) {
	    this.alcoolName.set(alcoolName);
	}
	public StringProperty alcoolNameProperty() {
		return alcoolName;
	}

	
	public double getDegree() {
		return degree.get();
	}
	public void setDegree(double degree) {
	    this.degree.set(degree);
	}
	public DoubleProperty degreeProperty() {
		return degree;
	}
	
	
	public double getQuantity() {
		return quantity.get();
	}
	public void setQuantity(double dose) {
	    this.quantity.set(dose);
	}    
	public DoubleProperty quantityProperty() {
		return quantity;
	}
	
	
}
