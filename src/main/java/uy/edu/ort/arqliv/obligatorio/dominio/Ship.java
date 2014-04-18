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
public class Ship implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8849836658792950881L;

	@Id
	private int jpaid;

	private double capacity;
	private int code;
	private int crewQuantity;
	private String flag;

	private int manufactoringYear;
	private String name;
	
	public Ship() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getJpaid() {
		return jpaid;
	}

	public void setJpaid(int jpaid) {
		this.jpaid = jpaid;
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

	public int getCrewQuantity() {
		return crewQuantity;
	}

	public void setCrewQuantity(int crewQuantity) {
		this.crewQuantity = crewQuantity;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getManufactoringYear() {
		return manufactoringYear;
	}

	public void setManufactoringYear(int manufactoringYear) {
		this.manufactoringYear = manufactoringYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}