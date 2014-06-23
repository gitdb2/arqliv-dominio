package uy.edu.ort.arqliv.obligatorio.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Implementacion de un arribo
 * 
 * @author rodrigo
 * @version 1.0
 * @created 18-Apr-2014 1:05:53 PM
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Arrival.arrivalsByMonth", query = "SELECT a FROM Arrival a WHERE month(a.arrivalDate) = :month"),

		@NamedQuery(name = "Arrival.arrivalsByMonthByShip", query = "SELECT a FROM Arrival a "
				+ "WHERE month(a.arrivalDate) = :month " + "AND a.ship.id = :shipId"),

		@NamedQuery(name = "Arrival.findArrivalUsingContainerForDate", query = "SELECT a FROM Arrival a, Container c WHERE c.id = :id AND c  MEMBER OF a.containers AND a.arrivalDate= :arrivalDate"),

		@NamedQuery(name = "Arrival.findArrivalUsingContainerListForDate", query = "SELECT a FROM Arrival a, Container c WHERE "
				+ "    a.arrivalDate = :arrivalDate " + "AND c IN (:containerList) " + " AND c MEMBER OF a.containers "),

		@NamedQuery(name = "Arrival.findArrivalByShipByDateByPort", query = "SELECT a FROM Arrival a "
				+ "WHERE a.ship.id = :shipId " + "AND a.shipOrigin = :somePort "
				+ "AND DATE(a.arrivalDate) <= DATE(:someDate)") })
public class Arrival implements Serializable {

	private static final long serialVersionUID = 5165938205482285921L;

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

	@Temporal(TemporalType.DATE)
	private Date arrivalDate;

	@Column(columnDefinition = "TEXT")
	private String containersDescriptions;

	@Column(columnDefinition = "TEXT")
	private String shipOrigin;

	@OneToOne(cascade = CascadeType.MERGE)
	private Ship ship;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Container> containers;

	private double shipCapacityThatDay;

	private double shipTransportedWeightThatDay;

	public Arrival() {
		super();
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

	public double getShipCapacityThatDay() {
		return shipCapacityThatDay;
	}

	public void setShipCapacityThatDay(double shipCapacityThatDay) {
		this.shipCapacityThatDay = shipCapacityThatDay;
	}

	public double getShipTransportedWeightThatDay() {
		return shipTransportedWeightThatDay;
	}

	public void setShipTransportedWeightThatDay(double shipTransportedWeightThatDay) {
		this.shipTransportedWeightThatDay = shipTransportedWeightThatDay;
	}

	@Override
	public String toString() {
		return "Arrival [id=" + id + ", version=" + version + ", arrivalDate=" + arrivalDate
				+ ", containersDescriptions=" + containersDescriptions + ", shipOrigin=" + shipOrigin + ", ship="
				+ ship + ", containers=" + containers + ", shipCapacityThatDay=" + shipCapacityThatDay
				+ ", shipTransportedWeightThatDay=" + shipTransportedWeightThatDay + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + ((containers == null) ? 0 : containers.hashCode());
		result = prime * result + ((containersDescriptions == null) ? 0 : containersDescriptions.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ship == null) ? 0 : ship.hashCode());
		long temp;
		temp = Double.doubleToLongBits(shipCapacityThatDay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((shipOrigin == null) ? 0 : shipOrigin.hashCode());
		temp = Double.doubleToLongBits(shipTransportedWeightThatDay);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arrival other = (Arrival) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		return true;
	}

	public List<Long> getContainersIdList() {
		List<Long> ret = new ArrayList<Long>();
		if (containers != null) {
			for (Container container : containers) {
				ret.add(container.getId());
			}
		}
		return ret;
	}

}