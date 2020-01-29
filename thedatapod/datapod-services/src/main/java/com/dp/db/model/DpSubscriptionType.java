package com.dp.db.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;



/**
 * The Class DpSubscriptionType.
 */
@Entity
@Table(name = "subscription_type")
public class DpSubscriptionType implements java.io.Serializable {

	/** The Constant serialVersionUID. */
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
	
	
	/** The  domains. */
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "domain_id", nullable = false, referencedColumnName = "domain_id")
	private DpDomain domainId;
	
	/** The cost. */
	@Column(name = "cost")
	private Double cost;
	
	/** The data min usage. */
	@Column(name = "data_min_usage")
	private String dataMinUsage;
	
	/** The data max usage. */
	@Column(name = "data_max_usage")
	private String dataMaxUsage;

	/** The time min usage. */
	@Column(name = "time_min_usage")
	private String timeMinUsage;

	/** The time max usage. */
	@Column(name = "time_max_usage")
	private String timeMaxUsage;	
	
	/** The status. */
	@Column(name = "status")
	private String status;
	
	/** The creation date. */
	@Column(name = "creation_date")
	private Timestamp creationDate;

	/** The last modified date. */
	@Column(name = "last_modified_date")
	private Timestamp lastModifiedDate;
	
	/** The features. */
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "subscription_feature_rel", joinColumns = @JoinColumn(name = "subscription_type_id", referencedColumnName = "subscription_type_id"), inverseJoinColumns = @JoinColumn(name = "feature_id", referencedColumnName = "feature_id"))
	@OrderBy
	private List<DpSubscriptionFeature> features;

	/**
	 * Gets the domain id.
	 *
	 * @return the domain id
	 */
	
	public DpDomain getDomainId() {
		return domainId;
	}

	

	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	
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
	public String getDataMinUsage() {
		return dataMinUsage;
	}

	/**
	 * Sets the data min usage.
	 *
	 * @param dataMinUsage the new data min usage
	 */
	public void setDataMinUsage(String dataMinUsage) {
		this.dataMinUsage = dataMinUsage;
	}

	/**
	 * Gets the data max usage.
	 *
	 * @return the data max usage
	 */
	public String getDataMaxUsage() {
		return dataMaxUsage;
	}

	/**
	 * Sets the data max usage.
	 *
	 * @param dataMaxUsage the new data max usage
	 */
	public void setDataMaxUsage(String dataMaxUsage) {
		this.dataMaxUsage = dataMaxUsage;
	}

	/**
	 * Gets the time min usage.
	 *
	 * @return the time min usage
	 */
	public String getTimeMinUsage() {
		return timeMinUsage;
	}

	/**
	 * Sets the time min usage.
	 *
	 * @param timeMinUsage the new time min usage
	 */
	public void setTimeMinUsage(String timeMinUsage) {
		this.timeMinUsage = timeMinUsage;
	}

	/**
	 * Gets the time max usage.
	 *
	 * @return the time max usage
	 */
	public String getTimeMaxUsage() {
		return timeMaxUsage;
	}

	/**
	 * Sets the time max usage.
	 *
	 * @param timeMaxUsage the new time max usage
	 */
	public void setTimeMaxUsage(String timeMaxUsage) {
		this.timeMaxUsage = timeMaxUsage;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
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
	public Timestamp getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date.
	 *
	 * @param creationDate the new creation date
	 */
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the last modified date.
	 *
	 * @return the last modified date
	 */
	
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * Sets the last modified date.
	 *
	 * @param lastModifiedDate the new last modified date
	 */
	public void setLastModifiedDate(Timestamp lastModifiedDate) {
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

	/**
	 * Gets the features.
	 *
	 * @return the features
	 */
	
	public List<DpSubscriptionFeature> getFeatures() {
		return features;
	}

	/**
	 * Sets the features.
	 *
	 * @param features the new features
	 */
	public void setFeatures(List<DpSubscriptionFeature> features) {
		this.features = features;
	}

	/**
	 * Sets the domain id.
	 *
	 * @param domainId the new domain id
	 */
	public void setDomainId(DpDomain domainId) {
		this.domainId = domainId;
	}

	

}
