/**
 * 
 */
package com.datapad.form;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author DataPod
 *
 */
public class SubscriptionForm {
	
	/** The id. */
	private Integer id;

	/** The organization name. */
	private String organizationName;
	
	/** The organization description. */
	private String organizationDescription;
	
	/** The email. */
	private String email;
	
	/** The phone. */
	private String phone;
	
	/** The status. */
	private String status;
	
	/** The creation date. */
	private Timestamp creationDate;

	/** The last modified date. */
	private Timestamp lastModifiedDate;
	
	/** The subscription type id. */
	private Integer subscriptionTypeId;
	
	/** The sub domain ids. */
	private List<Integer> subDomainIds;
	
	/** The domain id. */
	private Integer domainId;
	
	/** The addressLineOne. */
	private String addressLineOne;
	
	/** The addressLineTwo. */
	private String addressLineTwo;
	
	/** The city. */
	private String city;
	
	/** The state. */
	private String state;	
	
	/** The country. */
	private String country;
	
	/** The pin code. */
	private String pinCode;

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
	 * Gets the organization name.
	 *
	 * @return the organization name
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * Sets the organization name.
	 *
	 * @param organizationName the new organization name
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * Gets the organization description.
	 *
	 * @return the organization description
	 */
	public String getOrganizationDescription() {
		return organizationDescription;
	}

	/**
	 * Sets the organization description.
	 *
	 * @param organizationDescription the new organization description
	 */
	public void setOrganizationDescription(String organizationDescription) {
		this.organizationDescription = organizationDescription;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * Gets the subscription type id.
	 *
	 * @return the subscription type id
	 */
	public Integer getSubscriptionTypeId() {
		return subscriptionTypeId;
	}

	/**
	 * Sets the subscription type id.
	 *
	 * @param subscriptionTypeId the new subscription type id
	 */
	public void setSubscriptionTypeId(Integer subscriptionTypeId) {
		this.subscriptionTypeId = subscriptionTypeId;
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
	 * @return the addressLineOne
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}

	/**
	 * @param addressLineOne the addressLineOne to set
	 */
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	/**
	 * @return the addressLineTwo
	 */
	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	/**
	 * @param addressLineTwo the addressLineTwo to set
	 */
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}


	
	
}
