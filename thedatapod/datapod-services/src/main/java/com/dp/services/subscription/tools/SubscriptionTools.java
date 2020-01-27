package com.dp.services.subscription.tools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.db.model.DpDomain;
import com.dp.db.model.DpSubDomain;
import com.dp.db.repository.DomainRepository;
import com.dp.db.repository.SubDomainRepository;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.constants.Domain;
import com.dp.services.constants.Error;
import com.dp.utils.ResourceBundleHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class SubscriptionTools.
 */
@Transactional
@Service("subscriptionTools")
public class SubscriptionTools {
	
	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


	/** The domain repository. */
	@Autowired
	private DomainRepository domainRepository;

	
	/** The sub domain repository. */
	@Autowired
	private SubDomainRepository subDomainRepository;
	
	/** The resource bundle helper component. */
	@Autowired
	private ResourceBundleHelper resourceBundleHelperComponent;

	
	
	/**
	 * Creates the domain.
	 *
	 * @param pDomain the domain
	 * @return the dp domain
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpDomain createDomain(DpDomain pDomain) throws GenericDaoException {
			if (pDomain == null) {
				LOGGER.error("createDomain: DOMAIN_BAD_REQUEST");
				throw new GenericDaoException(Error.DOMAIN_BAD_REQUEST.getCode(), 
						Error.DOMAIN_BAD_REQUEST.getLabel(), Error.DOMAIN_BAD_REQUEST.getValue());
			}
			pDomain.setStatus(Domain.ACTIVE.getValue());
			DpDomain updatedDomain = domainRepository.save(pDomain);
			// fetch the domain
			return updatedDomain;
		
	}
	
	/**
	 * Update domain.
	 *
	 * @param pDomain the domain
	 * @return the dp domain
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpDomain updateDomain(DpDomain pDomain) throws GenericDaoException {
		if (pDomain == null) {
			LOGGER.error("updateDomain: DOMAIN_BAD_REQUEST");
			throw new GenericDaoException(Error.DOMAIN_BAD_REQUEST.getCode(), 
					Error.DOMAIN_BAD_REQUEST.getLabel(), Error.DOMAIN_BAD_REQUEST.getValue());
		} else if (pDomain.getId() == null) {
			LOGGER.error("updateDomain: DOMAIN_ID_MISSING");
			throw new GenericDaoException(Error.DOMAIN_ID_MISSING.getCode(), 
					Error.DOMAIN_ID_MISSING.getLabel(), Error.DOMAIN_ID_MISSING.getValue());
		}
		DpDomain domain = domainRepository.getOne(pDomain.getId().intValue());
		if (domain != null) {
			DpDomain updatedDomain = domainRepository.save(pDomain);
			// fetch the domain
			return updatedDomain;
		} else {
			LOGGER.error("updateDomain: DOMAIN_NOT_FOUND");
			throw new GenericDaoException(Error.DOMAIN_NOT_FOUND.getCode(), 
					Error.DOMAIN_NOT_FOUND.getLabel(), Error.DOMAIN_NOT_FOUND.getValue());
		}
	}
	
	/**
	 * Creates the sub domain.
	 *
	 * @param pSubDomain the sub domain
	 * @return the dp sub domain
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpSubDomain createSubDomain(DpSubDomain pSubDomain) throws GenericDaoException {
		if (pSubDomain == null) {
			LOGGER.error("createSubDomain: DOMAIN_BAD_REQUEST");
			throw new GenericDaoException(Error.DOMAIN_BAD_REQUEST.getCode(), 
					Error.DOMAIN_BAD_REQUEST.getLabel(), Error.DOMAIN_BAD_REQUEST.getValue());
		}
		pSubDomain.setStatus(Domain.ACTIVE.getValue());
		DpSubDomain updatedSubDomain = subDomainRepository.save(pSubDomain);
		// fetch the domain
		return updatedSubDomain;
	
	}

	/**
	 * Update sub domain.
	 *
	 * @param pSubDomain the sub domain
	 * @return the dp sub domain
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpSubDomain updateSubDomain(DpSubDomain pSubDomain) throws GenericDaoException {
		if (pSubDomain == null) {
			LOGGER.error("updateSubDomain: DOMAIN_BAD_REQUEST");
			throw new GenericDaoException(Error.DOMAIN_BAD_REQUEST.getCode(), 
					Error.DOMAIN_BAD_REQUEST.getLabel(), Error.DOMAIN_BAD_REQUEST.getValue());
		} else if (pSubDomain.getId() == null) {
			LOGGER.error("updateSubDomain: DOMAIN_ID_MISSING");
			throw new GenericDaoException(Error.DOMAIN_ID_MISSING.getCode(), 
					Error.DOMAIN_ID_MISSING.getLabel(), Error.DOMAIN_ID_MISSING.getValue());
		}
		DpSubDomain domain = subDomainRepository.getOne(pSubDomain.getId().intValue());
		if (domain != null) {
			DpSubDomain updatedDomain = subDomainRepository.save(pSubDomain);
			// fetch the sub domain
			return updatedDomain;
		} else {
			LOGGER.error("updateSubDomain: DOMAIN_NOT_FOUND");
			throw new GenericDaoException(Error.DOMAIN_NOT_FOUND.getCode(), 
					Error.DOMAIN_NOT_FOUND.getLabel(), Error.DOMAIN_NOT_FOUND.getValue());
		}
	}
	
	/**
	 * Link sub domain.
	 *
	 * @param pDomain the domain
	 * @param pSubDomain the sub domain
	 * @return the dp domain
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpDomain linkSubDomain(DpDomain pDomain, DpSubDomain pSubDomain) throws GenericDaoException {
		if (pDomain == null) {
			LOGGER.error("updateDomain: DOMAIN_BAD_REQUEST");
			throw new GenericDaoException(Error.DOMAIN_BAD_REQUEST.getCode(), 
					Error.DOMAIN_BAD_REQUEST.getLabel(), Error.DOMAIN_BAD_REQUEST.getValue());
		} else if (pDomain.getId() == null) {
			LOGGER.error("updateDomain: DOMAIN_ID_MISSING");
			throw new GenericDaoException(Error.DOMAIN_ID_MISSING.getCode(), 
					Error.DOMAIN_ID_MISSING.getLabel(), Error.DOMAIN_ID_MISSING.getValue());
		}
		DpDomain domain = domainRepository.getOne(pDomain.getId().intValue());
		if (domain != null) {
			DpSubDomain subDomain = null;
			if (pSubDomain.getId() != null) {
				subDomain = subDomainRepository.getOne(pSubDomain.getId().intValue());
			} 
			if (subDomain == null) {
				subDomain = createSubDomain(pSubDomain);
			}
			List<DpSubDomain> subDomains = domain.getSubDomains();
			if (subDomains == null) {
				subDomains = new ArrayList<DpSubDomain>();
			}
			if (subDomain != null && !subDomains.contains(subDomain)) {
				subDomains.add(subDomain);
				domain.setSubDomains(subDomains);
				domainRepository.save(domain);
			}
			// fetch the domain
			return domain;
		} else {
			LOGGER.error("updateDomain: DOMAIN_NOT_FOUND");
			throw new GenericDaoException(Error.DOMAIN_NOT_FOUND.getCode(), 
					Error.DOMAIN_NOT_FOUND.getLabel(), Error.DOMAIN_NOT_FOUND.getValue());
		}
	}
	
	public DpDomain getDomain(int pId) throws GenericDaoException {
		return domainRepository.getOne(pId);
	}
	
	public DpSubDomain getSubDomain(int pId) throws GenericDaoException {
		return subDomainRepository.getOne(pId);
	}
	


	
}
