package com.datapad.page.cde.model;

import java.io.Serializable;

import com.datapad.base.models.GenericModel;
import com.fasterxml.jackson.annotation.JsonInclude;


public class CriticalDataElementModel extends GenericModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5030946195498688528L;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private int id;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object response;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
	
	
}
