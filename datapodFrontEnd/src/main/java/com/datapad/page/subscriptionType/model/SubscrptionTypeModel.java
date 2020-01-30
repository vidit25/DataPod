/**
 * 
 */
package com.datapad.page.subscriptionType.model;

import java.io.Serializable;

import com.datapad.base.models.GenericModel;

/**
 * @author DataPod
 *
 */
public class SubscrptionTypeModel extends GenericModel implements Serializable {
	
	private int id;
	
	private String name;
	
	private Object response;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

}
