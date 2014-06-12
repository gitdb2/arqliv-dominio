package uy.edu.ort.arqliv.obligatorio.dominio;

import java.io.Serializable;
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

@Entity
@NamedQueries({
	@NamedQuery(name = "Departure.findDepartureUsingContainerListForDate", 
			query = "SELECT d FROM Departure d, Container c WHERE "
					+ " d.departureDate = :departureDate "
					+ " AND c IN (:containerList) "
					+ " AND c MEMBER OF d.containers ")
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
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Ship ship;
	
	@ManyToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Container> containers;

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

}
