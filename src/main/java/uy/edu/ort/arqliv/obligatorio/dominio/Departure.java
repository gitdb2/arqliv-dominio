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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@NamedQueries({
	@NamedQuery(name = "Departure.findDepartureUsingContainerListForDate", 
			query = "SELECT d FROM Departure d, Container c WHERE "
					+ " d.departureDate = :departureDate "
					+ " AND c IN (:containerList) "
					+ " AND c MEMBER OF d.containers "),
					
	@NamedQuery(name = "Departure.isArrivalDeparted", 
			query = "SELECT COUNT(d) FROM Departure d WHERE d.arrival.id=:id "),
			
	@NamedQuery(name = "Departure.isArrivalDepartedDifferentDeparture", 
			query = "SELECT COUNT(d) FROM Departure d WHERE d.arrival.id=:id AND d.id <> :departureId"),
			
	@NamedQuery(name = "Departure.departuresByMonth", 
			query = "SELECT d FROM Departure d WHERE month(d.departureDate) = :month"),
			
	@NamedQuery(name = "Departure.isContainerAvailableForDeparture", 
			query = "SELECT COUNT(*) FROM Arrival a , Container c "
					+ " WHERE a.arrivalDate <= :departureDate "
					+ " AND c.id = :id "
					+ " AND c MEMBER OF a.containers "
					+ " AND a NOT IN (SELECT d.arrival FROM Departure d) "
					),
			
	@NamedQuery(name = "Departure.departuresByMonthByShip", query = "SELECT d FROM Departure d "
			+ "WHERE month(d.departureDate) = :month " + "AND d.ship.id = :shipId")
})
public class Departure implements Serializable {

	private static final long serialVersionUID = 4859636640296701809L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;
	
    @Column(columnDefinition="TEXT")
	private String shipDestination;
	
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	
	@Column(columnDefinition="TEXT")
	private String containersDescriptions;
	
	//@ManyToOne(cascade=CascadeType.MERGE)
	@ManyToOne
	private Ship ship;
	
//	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Container> containers;
	
	
	private double shipTransportedWeightThatDay;

	private double shipCapacityThatDay;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Arrival arrival;

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

	public String getShipDestination() {
		return shipDestination;
	}

	public void setShipDestination(String shipDestination) {
		this.shipDestination = shipDestination;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getContainersDescriptions() {
		return containersDescriptions;
	}

	public void setContainersDescriptions(String containersDescriptions) {
		this.containersDescriptions = containersDescriptions;
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
	
	public double getShipTransportedWeightThatDay() {
		return shipTransportedWeightThatDay;
	}

	public void setShipTransportedWeightThatDay(double shipTransportedWeightThatDay) {
		this.shipTransportedWeightThatDay = shipTransportedWeightThatDay;
	}

	
	
	public double getShipCapacityThatDay() {
		return shipCapacityThatDay;
	}

	public void setShipCapacityThatDay(double shipCapacityThatDay) {
		this.shipCapacityThatDay = shipCapacityThatDay;
	}

	public Arrival getArrival() {
		return arrival;
	}

	public void setArrival(Arrival arrival) {
		this.arrival = arrival;
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
