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
 * The Class DpSubscriptionType.
 */
@Entity
@Table(name = "user_subscription")
public class DpUserSubscription implements java.io.Serializable {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 879119753459362184L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_id")
	private Integer id;

	/** The organization name. */
	@Column(name = "organization_name")
	private String organizationName;
	
	/** The organization description. */
	@Column(name = "organization_desc")
	private String organizationDescription;
	
	/** The email. */
	@Column(name = "email")
	private String email;
	
	/** The phone. */
	@Column(name = "phone")
	private String phone;
	
	/** The status. */
	@Column(name = "status")
	private String status;
	
	/** The creation date. */
	@Column(name = "creation_date")
	private Timestamp creationDate;

	/** The last modified date. */
	@Column(name = "last_modified_date")
	private Timestamp lastModifiedDate;
	
	/** The subscription type. */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscription_type_id", referencedColumnName = "subscription_type_id")
	private DpSubscriptionType subscriptionType;
	
	/** The address. */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address", referencedColumnName = "address_id")
	private DpContactInfo address;

	
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
	 * Gets the subscription type.
	 *
	 * @return the subscription type
	 */
	public DpSubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	/**
	 * Sets the subscription type.
	 *
	 * @param subscriptionType the new subscription type
	 */
	public void setSubscriptionType(DpSubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
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

	
	
}
