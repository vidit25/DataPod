package com.dp.services.subscription.request;



/**
 * Domain Request Object.
 * 
 * @author theDatapod
 *
 */
public class SubDomainRequest {
	
	/** The domain id. */
	private Integer domainId;
	
	/** The sub domain id. */
	private Integer id;

	/** The name. */
	private String name;
	
	/** The description. */
	private String description;	

	/** The status. */
	private String status;

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
	 * Gets the sub domain id.
	 *
	 * @return the sub domain id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the sub domain id.
	 *
	 * @param subDomainId the new sub domain id
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
	
}
