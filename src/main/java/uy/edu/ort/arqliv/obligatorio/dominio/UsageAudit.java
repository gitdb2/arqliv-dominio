package uy.edu.ort.arqliv.obligatorio.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = UsageAudit.tableName)
public class UsageAudit implements Serializable {
	
	private static final long serialVersionUID = -9006694511706750323L;
	
	public final static String tableName = "usage_audit";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private Long version;
	
	@Column(columnDefinition = "TEXT")
	private String user;
	
	@Column(columnDefinition = "TEXT")
	private String service;
	
	@Column(columnDefinition = "TEXT")
	private String action;
	
	@Column(columnDefinition = "TEXT")
	private String parameters;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date actionStartTime;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date actionEndTime;

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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public Date getActionStartTime() {
		return actionStartTime;
	}

	public void setActionStartTime(Date actionStartTime) {
		this.actionStartTime = actionStartTime;
	}

	public Date getActionEndTime() {
		return actionEndTime;
	}

	public void setActionEndTime(Date actionEndTime) {
		this.actionEndTime = actionEndTime;
	}

}
