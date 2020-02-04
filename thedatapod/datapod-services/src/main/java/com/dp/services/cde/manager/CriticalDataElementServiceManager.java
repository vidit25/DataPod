package com.dp.services.cde.manager;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dp.db.model.DpCriticalDataElement;
import com.dp.services.cde.tools.CriticalDataElementTools;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class CriticalDataElementServiceManager.
 */
@Service("criticalDataElementServiceManager")
public class CriticalDataElementServiceManager {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private CriticalDataElementTools criticalDataElementTools;
	
	
	
	/**
	 * 
	 * @param subDomainIds
	 * @return
	 */
	public List<DpCriticalDataElement> getCriticalDataElementBySubDomain( List<Integer> subDomainIds) throws GenericDaoException {
		List<DpCriticalDataElement> criticalDataElements = criticalDataElementTools.getCriticalDataElementBySubDomain(subDomainIds);
		return criticalDataElements;
	}
	
	
}
