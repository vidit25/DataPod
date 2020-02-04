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
public class SubscrptionTypeMetaModel extends GenericModel implements Serializable {
	
	
//	"name":"Advanced Plan",
//	"description":"Advanced Plan",
//	"domainId":1,
//	"cost":2500.00,
//	"dataMinUsage":"100GB",
//	"dataMaxUsage":"200GB",
//	"timeMinUsage":"10 day",
//	"timeMaxUsage":"70 days",
//	"features":[
//		{
//			"name":"Feature3",
//			"description":"Feature3 desc"
//		},
//		{
//			"name":"Feature4",
//			"description":"Feature4 desc"
//		}
//	]
	
	private int id;
	
	private String name;
	
	private String description;
	
	private String domainId;
	
	private String cost;
	
	private String dataMinUsage;
	
	private String dataMaxUsage;
	
	private String timeMinUsage;
	
	private String timeMaxUsage;
	
	private Object response;
	
	private Object features;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDataMinUsage() {
		return dataMinUsage;
	}

	public void setDataMinUsage(String dataMinUsage) {
		this.dataMinUsage = dataMinUsage;
	}

	public String getDataMaxUsage() {
		return dataMaxUsage;
	}

	public void setDataMaxUsage(String dataMaxUsage) {
		this.dataMaxUsage = dataMaxUsage;
	}

	public String getTimeMinUsage() {
		return timeMinUsage;
	}

	public void setTimeMinUsage(String timeMinUsage) {
		this.timeMinUsage = timeMinUsage;
	}

	public String getTimeMaxUsage() {
		return timeMaxUsage;
	}

	public void setTimeMaxUsage(String timeMaxUsage) {
		this.timeMaxUsage = timeMaxUsage;
	}

	public Object getFeatures() {
		return features;
	}

	public void setFeatures(Object features) {
		this.features = features;
	}

}
