package com.dp.services.subscription.request;

import java.util.List;





/**
 * The Class SubscriptionTypeRequest.
 */
public class SubscriptionTypeRequest {
	
	/** The id. */
	private Integer id;

	/** The name. */
	private String name;
	
	/** The description. */
	private String description;	

	/** The status. */
	private String status;
	
	/** The domain id. */
	private Integer domainId;
	
	/** The cost. */
	private Double cost;
	
	/** The data min usage. */
	private String dataMinUsage;
	
	/** The data max usage. */
	private String dataMaxUsage;

	/** The time min usage. */
	private String timeMinUsage;

	/** The time max usage. */
	private String timeMaxUsage;		
	
	/** The features. */
	private List<FeatureRequest> features;
	


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
	 * Gets the domain id.
	 *
	 * @return the domain id
	 */
	public Integer getDomainId() {
		return domainId;
	}

	/**
	 * Sets the domain id.
	 *
	 * @param domainId the new domain id
	 */
	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
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
	 * Gets the features.
	 *
	 * @return the features
	 */
	public List<FeatureRequest> getFeatures() {
		return features;
	}

	/**
	 * Sets the features.
	 *
	 * @param features the new features
	 */
	public void setFeatures(List<FeatureRequest> features) {
		this.features = features;
	}

	
	
}
