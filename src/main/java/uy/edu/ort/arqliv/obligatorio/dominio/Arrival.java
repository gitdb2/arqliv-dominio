package uy.edu.ort.arqliv.obligatorio.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rodrigo
 * @version 1.0
 * @created 18-Apr-2014 1:05:53 PM
 */
@Entity
public class Arrival implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5165938205482285921L;

	@Id
	private int jpaid;
	
	private Date arrivalDate;
	private String containersDescriptions;
	private String shipOrigin;
	private Ship ship;
	
	private List<Container> containers;

	public Arrival() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getJpaid() {
		return jpaid;
	}

	public void setJpaid(int jpaid) {
		this.jpaid = jpaid;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getContainersDescriptions() {
		return containersDescriptions;
	}

	public void setContainersDescriptions(String containersDescriptions) {
		this.containersDescriptions = containersDescriptions;
	}

	public String getShipOrigin() {
		return shipOrigin;
	}

	public void setShipOrigin(String shipOrigin) {
		this.shipOrigin = shipOrigin;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}






}