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
 * @created 18-Apr-2014 1:05:53 PM1
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Ship.findByFlag", query = "SELECT s FROM Ship s WHERE s.flag = :flag"),
		@NamedQuery(name = "Ship.countUsage", query = "SELECT COUNT(a) FROM Arrival a, Ship s WHERE s.id = :id AND a.ship = s"),
		@NamedQuery(name = "Ship.findByName", query = "SELECT s FROM Ship s WHERE s.name = :name") })
public class Ship implements Serializable {

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

	private static final long serialVersionUID = -8849836658792950881L;

	private double capacity;

	private int code;

	private int crewQuantity;

	private String flag;

	private int manufactoringYear;

	@Column(columnDefinition = "TEXT")
	private String name;

	public Ship() {
		super();
	}

	public Ship(double capacity, int code, int crewQuantity, String flag,
			int manufactoringYear, String name) {
		super();
		this.capacity = capacity;
		this.code = code;
		this.crewQuantity = crewQuantity;
		this.flag = flag;
		this.manufactoringYear = manufactoringYear;
		this.name = name;
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

	@Override
	public String toString() {
		return "Ship [jpaid=" + getId() + ", capacity=" + capacity + ", code="
				+ code + ", crewQuantity=" + crewQuantity + ", flag=" + flag
				+ ", manufactoringYear=" + manufactoringYear + ", name=" + name
				+ "]";
	}

	public String toStringConsola() {
		return "Nombre:            " + name + "\n" + "Bandera:           "
				+ flag + "\n" + "Codigo:            " + code + "\n"
				+ "Año Manufactura:   " + manufactoringYear + "\n"
				+ "Cant. Tripulacion: " + crewQuantity + "\n"
				+ "Capacidad:         " + capacity;
	}

}