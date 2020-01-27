package com.dp.db.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * The Class DpDomain.
 */
@Entity
@Table(name = "domains", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) }, catalog = "datapoddb")
public class DpDomain implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1139650240704762839L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "domain_id")
	private Integer id;

	/** The name. */
	@Column(name = "name")
	private String name;
	
	/** The description. */
	@Column(name = "description")
	private String description;
	
	/** The sub domains. */
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "domains_sub_domain_rel", joinColumns = @JoinColumn(name = "domain_id", referencedColumnName = "domain_id"), inverseJoinColumns = @JoinColumn(name = "sub_domain_id", referencedColumnName = "sub_domain_id"))
	@OrderBy
	private List<DpSubDomain> subDomains;
	
	/** The status. */
	@Column(name = "status")
	private String status;
	
	
	
	
	
	
	/**
	 * Gets the sub domains.
	 *
	 * @return the sub domains
	 */
	public List<DpSubDomain> getSubDomains() {
		return subDomains;
	}

	/**
	 * Sets the sub domains.
	 *
	 * @param subDomains the new sub domains
	 */
	public void setSubDomains(List<DpSubDomain> subDomains) {
		this.subDomains = subDomains;
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
