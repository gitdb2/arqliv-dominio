package uy.edu.ort.arqliv.obligatorio.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

/**
 * @author rodrigo
 * @version 1.0
 * @created 18-Apr-2014 1:05:53 PM
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Container.findByModel", query = "SELECT c FROM Container c WHERE c.model = :model"),
		@NamedQuery(name = "Container.countUsage", 
				query = "SELECT COUNT(a) FROM Arrival a, Container c WHERE c.id = :id AND c  MEMBER OF a.containers ") })
public class Container implements Serializable {

	private static final long serialVersionUID = 6715169840103633823L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(columnDefinition = "TEXT")
	private String brand;

	private double capacity;

	private int code;

	@Column(columnDefinition = "TEXT")
	private String model;

	public Container() {
		super();
	}
	public Container(String brand, double capacity, int code, String model) {
		super();
		this.brand = brand;
		this.capacity = capacity;
		this.code = code;
		this.model = model;
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

	@Override
	public String toString() {
		return "Container [id=" + id + ", version=" + version + ", brand="
				+ brand + ", capacity=" + capacity + ", code=" + code
				+ ", model=" + model + "]";
	}

	public String toStringConsola() {
		return    "Codigo:           " + code  + "\n" 
				+ "Marca:            " + brand + "\n" 
				+ "Modelo:           " + model + "\n"
				+ "Capacidad:        " + capacity;
	}


}