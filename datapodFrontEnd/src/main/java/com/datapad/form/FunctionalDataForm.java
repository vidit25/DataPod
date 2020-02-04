/**
 * 
 */
package com.datapad.form;

import java.util.List;

/**
 * @author Data Pod
 *
 */
public class FunctionalDataForm {
	
	/** The sub domain ids. */
	private List<Integer> subDomainIds;
	
	
	/** The domain id. */
	private Integer domainId;
	
	private List<Integer> dataElementIds;

	private List<Integer> sourceDataElementIds;


	/**
	 * @return the subDomainIds
	 */
	public List<Integer> getSubDomainIds() {
		return subDomainIds;
	}


	/**
	 * @param subDomainIds the subDomainIds to set
	 */
	public void setSubDomainIds(List<Integer> subDomainIds) {
		this.subDomainIds = subDomainIds;
	}


	/**
	 * @return the domainId
	 */
	public Integer getDomainId() {
		return domainId;
	}


	/**
	 * @param domainId the domainId to set
	 */
	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}


	/**
	 * @return the dataElementIds
	 */
	public List<Integer> getDataElementIds() {
		return dataElementIds;
	}


	/**
	 * @param dataElementIds the dataElementIds to set
	 */
	public void setDataElementIds(List<Integer> dataElementIds) {
		this.dataElementIds = dataElementIds;
	}


	/**
	 * @return the sourcecDataElementIds
	 */
	public List<Integer> getSourceDataElementIds() {
		return sourceDataElementIds;
	}


	/**
	 * @param sourcecDataElementIds the sourcecDataElementIds to set
	 */
	public void setSourceDataElementIds(List<Integer> sourceDataElementIds) {
		this.sourceDataElementIds = sourceDataElementIds;
	}
	

}
