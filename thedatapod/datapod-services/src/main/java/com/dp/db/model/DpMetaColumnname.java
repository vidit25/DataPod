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
@Table(name = "dp_meta_columnname",  catalog = "datapoddb")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DpMetaColumnname extends DpModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5813903443499845887L;

	@Column(name = "columnname")
	private String columnName;
	
	@ManyToOne
	@JoinColumn(name = "tablename_id", referencedColumnName = "id")
	private DpMetaTablename tableName;

	/**
	 * 
	 */
	public DpMetaColumnname() { }
	
	/**
	 * @param columnName
	 * @param table
	 */
	public DpMetaColumnname(String columnName,DpMetaTablename table) {
		this.setColumnName(columnName);
		this.setTableName(table);
	}
	
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public DpMetaTablename getTableName() {
		return tableName;
	}

	public void setTableName(DpMetaTablename tableName) {
		this.tableName = tableName;
	}

}
