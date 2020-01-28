package com.dp.services.subscription.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
import com.dp.utils.DpUtils;
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
		DpDomain domain = getDomain(pDomain.getId().intValue());
		if (domain != null && domain.getId() != null) {
			String status = pDomain.getStatus();
			if (DpUtils.isEmptyString(pDomain.getStatus())) {
				status = domain.getStatus();
			}
			List<DpSubDomain> subDomains = domain.getSubDomains();
			BeanUtils.copyProperties(pDomain, domain);
			domain.setStatus(status);
			if (subDomains != null && !subDomains.isEmpty()) {
				domain.setSubDomains(subDomains);
			}
			DpDomain updatedDomain = domainRepository.save(domain);
			// fetch the domain
			return updatedDomain;
		} else {
			LOGGER.error("updateDomain: DOMAIN_NOT_FOUND");
			throw new GenericDaoException(Error.DOMAIN_NOT_FOUND.getCode(), 
					Error.DOMAIN_NOT_FOUND.getLabel(), Error.DOMAIN_NOT_FOUND.getValue());
		}
	}
	
	public List<DpDomain> getAllDomains() throws GenericDaoException {
		List<DpDomain> domains = null;
		domains = domainRepository.findAll();
		return domains;
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
		DpSubDomain domain = getSubDomain(pSubDomain.getId().intValue());
		if (domain != null && domain.getId() != null) {
			String status = pSubDomain.getStatus();
			if (DpUtils.isEmptyString(pSubDomain.getStatus())) {
				status = domain.getStatus();
			}
			BeanUtils.copyProperties(pSubDomain, domain);
			domain.setStatus(status);
			DpSubDomain updatedDomain = subDomainRepository.save(domain);
			// fetch the sub domain
			return updatedDomain;
		} else {
			LOGGER.error("updateSubDomain: DOMAIN_NOT_FOUND");
			throw new GenericDaoException(Error.DOMAIN_NOT_FOUND.getCode(), 
					Error.DOMAIN_NOT_FOUND.getLabel(), Error.DOMAIN_NOT_FOUND.getValue());
		}
	}
	
	public void linkSubDomainToDomain(DpSubDomain pSubDomain, Integer pDomainId) throws GenericDaoException {
		if (pDomainId != null) {
			DpDomain domain = getDomain(pDomainId.intValue());
			if (domain != null) {
				List<DpSubDomain> subDomains = domain.getSubDomains();
				if (subDomains == null) {
					subDomains = new ArrayList<DpSubDomain>();
				}
				if (!subDomains.contains(pSubDomain)) {
					subDomains.add(pSubDomain);
					domain.setSubDomains(subDomains);
					domainRepository.save(domain);
				}
			}
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
		if (pDomain.getId() == null) {
			LOGGER.error("updateDomain: DOMAIN_ID_MISSING");
			throw new GenericDaoException(Error.DOMAIN_ID_MISSING.getCode(), 
					Error.DOMAIN_ID_MISSING.getLabel(), Error.DOMAIN_ID_MISSING.getValue());
		}
		if (pDomain != null) {
			List<DpSubDomain> subDomains = pDomain.getSubDomains();
			if (subDomains == null) {
				subDomains = new ArrayList<DpSubDomain>();
			}
			if (pSubDomain != null && !subDomains.contains(pSubDomain)) {
				subDomains.add(pSubDomain);
				pDomain.setSubDomains(subDomains);
				pDomain = domainRepository.save(pDomain);
			}
		} 	
		return pDomain;
		
	}
	
	public DpDomain getDomain(int pId) throws GenericDaoException {
		Optional<DpDomain> domain = domainRepository.findById(pId);
		if (domain != null && domain.isPresent()) {
			return domain.get();
		}
		return null;
	}
	
	public DpSubDomain getSubDomain(int pId) throws GenericDaoException {
		Optional<DpSubDomain> domain = subDomainRepository.findById(pId);
		if (domain != null && domain.isPresent()) {
			return domain.get();
		}
		return null;
	}
	


	
}
