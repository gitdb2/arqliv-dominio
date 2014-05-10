package uy.edu.ort.arqliv.obligatorio.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends PersistentEntity implements Serializable {

	private static final long serialVersionUID = 7360229243848231987L;
	
	@Column(columnDefinition="TEXT")
	private String name;

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
