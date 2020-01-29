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
 * The Class DpAccount.
 */
@Entity
@Table(name = "account")
public class DpAccount implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The account id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Integer accountId;

	/** The organization name. */
	@Column(name = "organization_name")
	private String organizationName;

	/** The organization description. */
	@Column(name = "organization_description")
	private String organizationDescription;

	/** The status. */
	@Column(name = "status")
	private String status;

	/** The phone. */
	@Column(name = "phone")
	private String phone;
	
	/** The address. */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address", referencedColumnName = "address_id")
	private DpContactInfo address;

	/** The creation date. */
	@Column(name = "creation_date")
	private Timestamp creationDate;
	
	/** The last modified date. */
	@Column(name = "last_modified_date")
	private Timestamp lastModifiedDate;

	/** The account number. */
	@Column(name = "account_num")
	private String accountNumber;
	
	/** The cost. */
	@Column(name = "calculated_cost")
	private Double cost;
	
	/** The subscription id. */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscription_id", referencedColumnName = "subscription_type_id")
	private DpSubscriptionType subscriptionId;

	/**
	 * Gets the account id.
	 *
	 * @return the account id
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * Sets the account id.
	 *
	 * @param accountId the new account id
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public DpContactInfo getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(DpContactInfo address) {
		this.address = address;
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
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	 * Gets the subscription id.
	 *
	 * @return the subscription id
	 */
	public DpSubscriptionType getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * Sets the subscription id.
	 *
	 * @param subscriptionId the new subscription id
	 */
	public void setSubscriptionId(DpSubscriptionType subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	
}
