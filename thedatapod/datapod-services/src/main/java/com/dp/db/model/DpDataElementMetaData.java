/**
 * 
 */
package com.dp.db.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Data Pod
 *
 */
@Entity
@Table(name = "dp_meta_data_cde",  catalog = "datapoddb")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DpDataElementMetaData implements java.io.Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meta_data_id")
	private Integer id;
	
		
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private DpAccount account;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "data_element_id", referencedColumnName = "data_element_id")
	private DpCriticalDataElement criticalDataElement;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	
	/**
	 * @return the criticalDataElement
	 */
	public DpCriticalDataElement getCriticalDataElement() {
		return criticalDataElement;
	}

	/**
	 * @param criticalDataElement the criticalDataElement to set
	 */
	public void setCriticalDataElement(DpCriticalDataElement criticalDataElement) {
		this.criticalDataElement = criticalDataElement;
	}

	/**
	 * @return the account
	 */
	public DpAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(DpAccount account) {
		this.account = account;
	}

	
	
	

}
