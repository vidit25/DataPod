package com.datapad.page.domains.model;

import java.util.List;

import com.datapad.base.models.GenericModel;

public class DomainModel extends GenericModel {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private List<DomainModel> response;
	
	private List<DomainModel> subDomains;
	
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

	public List<DomainModel> getSubDomains() {
		return subDomains;
	}

	public void setSubDomains(List<DomainModel> subDomains) {
		this.subDomains = subDomains;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<DomainModel> getResponse() {
		return response;
	}

	public void setResponse(List<DomainModel> response) {
		this.response = response;
	}
	
	
}
