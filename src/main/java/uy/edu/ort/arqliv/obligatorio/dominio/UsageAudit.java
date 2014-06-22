package uy.edu.ort.arqliv.obligatorio.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Clase que encapsula y representa la informacion necesaria para  auditoria y profiling
 * @author mauricio
 *
 */
@Entity
@Table(name = UsageAudit.tableName)
@NamedQueries({
	@NamedQuery(name = "UsageAudit.avgServiceTime", 
		query = "SELECT NEW uy.edu.ort.arqliv.obligatorio.dominio.Pair(u.service, AVG(u.actionNanoSeconds))"
		+ " FROM UsageAudit u "
		+ " WHERE DATE(u.actionDate) = DATE(:dateFilter) "
		+ " GROUP BY u.service "),
			
	@NamedQuery(name = "UsageAudit.minServiceTime", 
		query = "SELECT DISTINCT NEW uy.edu.ort.arqliv.obligatorio.dominio.Pair(u.service, u.actionNanoSeconds) "
		+ " FROM UsageAudit u"
		+ " WHERE DATE(u.actionDate) = DATE(:dateFilter) "
		+ " AND u.actionNanoSeconds "
		+ " = (SELECT MIN(p.actionNanoSeconds) "
		+ "    FROM UsageAudit p WHERE DATE(p.actionDate) = DATE(:dateFilter))"),
			
	@NamedQuery(name = "UsageAudit.maxServiceTime", 
		query = "SELECT DISTINCT NEW uy.edu.ort.arqliv.obligatorio.dominio.Pair(u.service, u.actionNanoSeconds) "
		+ " FROM UsageAudit u"
		+ " WHERE DATE(u.actionDate) = DATE(:dateFilter) "
		+ " AND u.actionNanoSeconds "
		+ " = (SELECT MAX(p.actionNanoSeconds) "
		+ "    FROM UsageAudit p WHERE DATE(p.actionDate) = DATE(:dateFilter))")
})
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
	private Date actionDate;
	
	@Column
	private long actionNanoSeconds;
	
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

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public long getActionNanoSeconds() {
		return actionNanoSeconds;
	}

	public void setActionNanoSeconds(long actionNanoSeconds) {
		this.actionNanoSeconds = actionNanoSeconds;
	}

}

