package com.dp.services.subscription.request;

import java.util.List;



/**
 * Domain Request Object.
 * 
 * @author theDatapod
 *
 */
public class DomainRequest {
	
	/** The id. */
	private Integer id;

	/** The name. */
	private String name;
	
	/** The description. */
	private String description;	

	/** The status. */
	private String status;
	
	/** The sub domain ids. */
	private List<Integer> subDomainIds;

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
	 * Gets the sub domain ids.
	 *
	 * @return the sub domain ids
	 */
	public List<Integer> getSubDomainIds() {
		return subDomainIds;
	}

	/**
	 * Sets the sub domain ids.
	 *
	 * @param subDomainIds the new sub domain ids
	 */
	public void setSubDomainIds(List<Integer> subDomainIds) {
		this.subDomainIds = subDomainIds;
	}
	
}
