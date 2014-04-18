package uy.edu.ort.arqliv.obligatorio.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rodrigo
 * @version 1.0
 * @created 18-Apr-2014 1:05:53 PM
 */
@Entity
public class Container implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6715169840103633823L;

	@Id
	private int jpaid;

	private String brand;
	private double capacity;
	private int code;

	private String model;

	public Container() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getJpaid() {
		return jpaid;
	}

	public void setJpaid(int jpaid) {
		this.jpaid = jpaid;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}