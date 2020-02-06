/**
 * 
 */
package com.dp.db.model;

import java.io.Serializable;

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
@Table(name = "dp_meta_tablename",  catalog = "datapoddb")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DpMetaTablename  extends DpModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2066136069309064179L;

	@Column(name = "tablename")
	private String tablename;
	
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private DpAccount account;

	
	
	/**
	 * 
	 */
	public DpMetaTablename() { }
	
	/**
	 * @param tableName
	 * @param account
	 */
	public DpMetaTablename(String tableName,DpAccount account) {
		this.setTablename(tableName);
		this.setAccount(account);
	}
	/**
	 * @return
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * @param tablename
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * @return
	 */
	public DpAccount getAccount() {
		return account;
	}

	/**
	 * @param account
	 */
	public void setAccount(DpAccount account) {
		this.account = account;
	}

	
	
	

}
