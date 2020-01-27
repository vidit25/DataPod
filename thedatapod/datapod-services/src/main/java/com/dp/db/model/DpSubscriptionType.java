package com.dp.db.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 * The Class DpSubscriptionType.
 */
@Entity
@Table(name = "subscription_type")
public class DpSubscriptionType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 795429387315508532L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_type_id")
	private Integer id;

	/** The name. */
	@Column(name = "name")
	private String name;
	
	/** The description. */
	@Column(name = "description")
	private String description;
	
	
	/** The sub domains. */
	private DpDomain domainId;
	
	/** The cost. */
	private Double cost;
	
	/** The data min usage. */
	private Integer dataMinUsage;
	
	/** The data max usage. */
	private Integer dataMaxUsage;

	/** The time min usage. */
	private Integer timeMinUsage;

	/** The time max usage. */
	private Integer timeMaxUsage;	
	
	/** The status. */
	private String status;
	
	/** The creation date. */
	private Timestamp creationDate;

	/** The last modified date. */
	private Timestamp lastModifiedDate;

	/**
	 * Gets the domain id.
	 *
	 * @return the domain id
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "domain_id", referencedColumnName = "domain_id")
	public DpDomain getDomainId() {
		return domainId;
	}

	/**
	 * Sets the domain id.
	 *
	 * @param domain_id the new domain id
	 */
	public void setDomain_id(DpDomain domainId) {
		this.domainId = domainId;
	}

	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	@Column(name = "cost")
	public Double getCost() {
		return cost;
	}

	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * Gets the data min usage.
	 *
	 * @return the data min usage
	 */
	@Column(name = "data_min_usage")
	public Integer getDataMinUsage() {
		return dataMinUsage;
	}

	/**
	 * Sets the data min usage.
	 *
	 * @param dataMinUsage the new data min usage
	 */
	public void setDataMinUsage(Integer dataMinUsage) {
		this.dataMinUsage = dataMinUsage;
	}

	/**
	 * Gets the data max usage.
	 *
	 * @return the data max usage
	 */
	@Column(name = "data_max_usage")
	public Integer getDataMaxUsage() {
		return dataMaxUsage;
	}

	/**
	 * Sets the data max usage.
	 *
	 * @param dataMaxUsage the new data max usage
	 */
	public void setData_max_usage(Integer dataMaxUsage) {
		this.dataMaxUsage = dataMaxUsage;
	}

	/**
	 * Gets the time min usage.
	 *
	 * @return the time min usage
	 */
	@Column(name = "time_min_usage")
	public Integer getTimeMinUsage() {
		return timeMinUsage;
	}

	/**
	 * Sets the time min usage.
	 *
	 * @param timeMinUsage the new time min usage
	 */
	public void setTime_min_usage(Integer timeMinUsage) {
		this.timeMinUsage = timeMinUsage;
	}

	/**
	 * Gets the time max usage.
	 *
	 * @return the time max usage
	 */
	@Column(name = "time_max_usage")
	public Integer getTimeMaxUsage() {
		return timeMaxUsage;
	}

	/**
	 * Sets the time max usage.
	 *
	 * @param timeMaxUsage the new time max usage
	 */
	public void setTime_max_usage(Integer timeMaxUsage) {
		this.timeMaxUsage = timeMaxUsage;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the creation date.
	 *
	 * @return the creation date
	 */
	@Column(name = "creation_date")
	public Timestamp getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creation_date the new creation date
	 */
	public void setCreation_date(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the last modified date.
	 *
	 * @return the last modified date
	 */
	@Column(name = "last_modified_date")
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * Sets the last modified date.
	 *
	 * @param last_modified_date the new last modified date
	 */
	public void setLast_modified_date(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	

}
