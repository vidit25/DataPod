package com.dp.services.cde.tools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.db.model.DpCriticalDataElement;
import com.dp.db.model.DpMetaColumnname;
import com.dp.db.model.DpMetaTablename;
import com.dp.db.repository.CriticalDataElementRepository;
import com.dp.db.repository.ModelRepository;
import com.dp.db.repository.UserSubscriptionRepository;
import com.dp.services.exception.GenericDaoException;

/**
 * The Class CriticalDataElementTools.
 */
@Transactional
@Service("criticalDataElementTools")
public class CriticalDataElementTools {

	@Autowired
	private CriticalDataElementRepository criticalDataElementRepository;
	
	@Autowired
	private ModelRepository modelRepository;
	
	
	
	
	
	/**
	 * 
	 * @param subDomainIds
	 * @return
	 */
	public List<DpCriticalDataElement> getCriticalDataElementBySubDomain( List<Integer> subDomainIds) throws GenericDaoException {
		List<DpCriticalDataElement> criticalDataElements = criticalDataElementRepository.getCDEBySubDomain(subDomainIds);
		return criticalDataElements;
	}

	/**
	 * @param metaTableName
	 * @return
	 */
	public DpMetaTablename saveTableName(DpMetaTablename metaTableName) {
		if (null != metaTableName) {
			metaTableName = modelRepository.save(metaTableName);
		}
		return metaTableName;
	}
	
	/**
	 * @param metaColumnName
	 * @return
	 */
	public DpMetaColumnname saveColumnName(DpMetaColumnname metaColumnName) {
		if (null != metaColumnName) {
			metaColumnName = modelRepository.save(metaColumnName);
		}
		return metaColumnName;
	}
	
	
	/**
	 * @param metaColumnName
	 * @return
	 */
	public DpMetaColumnname saveUserSubscription(DpMetaColumnname metaColumnName) {
		if (null != metaColumnName) {
			metaColumnName = modelRepository.save(metaColumnName);
		}
		return metaColumnName;
	}
}
