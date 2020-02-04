package com.dp.services.cde.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.db.model.DpCriticalDataElement;
import com.dp.db.repository.CriticalDataElementRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class CriticalDataElementTools.
 */
@Transactional
@Service("criticalDataElementTools")
public class CriticalDataElementTools {

	@Autowired
	private CriticalDataElementRepository criticalDataElementRepository;
	
	
	
	/**
	 * 
	 * @param subDomainIds
	 * @return
	 */
	public List<DpCriticalDataElement> getCriticalDataElementBySubDomain( List<Integer> subDomainIds) throws GenericDaoException {
		List<DpCriticalDataElement> criticalDataElements = criticalDataElementRepository.getCDEBySubDomain(subDomainIds);
		return criticalDataElements;
	}



	
	
	
	

}
