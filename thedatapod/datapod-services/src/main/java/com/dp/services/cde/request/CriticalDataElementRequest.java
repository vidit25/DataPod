/**
 * 
 */
package com.dp.services.cde.request;

import java.util.List;

/**
 * @author Data Pod
 *
 */
public class CriticalDataElementRequest {
	
	private List<Integer> dataElementIds;

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

}
