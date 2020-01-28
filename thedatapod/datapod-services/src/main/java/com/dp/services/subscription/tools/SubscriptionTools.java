package com.dp.services.subscription.tools;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.db.model.DpDomain;
import com.dp.db.model.DpSubDomain;
import com.dp.db.model.DpSubscriptionFeature;
import com.dp.db.model.DpSubscriptionType;
import com.dp.db.repository.DomainRepository;
import com.dp.db.repository.SubDomainRepository;
import com.dp.db.repository.SubscriptionFeatureRepository;
import com.dp.db.repository.SubscriptionTypeRepository;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.subscription.request.FeatureRequest;
import com.dp.services.subscription.request.SubscriptionTypeRequest;
import com.dp.services.constants.Domain;
import com.dp.services.constants.Error;
import com.dp.services.constants.SubscriptionType;
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
	
	/** The subscription type repository. */
	@Autowired
	private SubscriptionTypeRepository subscriptionTypeRepository;
	
	/** The subscription feature repository. */
	@Autowired
	private SubscriptionFeatureRepository subscriptionFeatureRepository;

	
	
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
	
	/**
	 * Gets the all domains.
	 *
	 * @return the all domains
	 * @throws GenericDaoException the generic dao exception
	 */
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
	
	/**
	 * Link sub domain to domain.
	 *
	 * @param pSubDomain the sub domain
	 * @param pDomainId the domain id
	 * @throws GenericDaoException the generic dao exception
	 */
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
	
	/**
	 * Gets the domain.
	 *
	 * @param pId the id
	 * @return the domain
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpDomain getDomain(int pId) throws GenericDaoException {
		Optional<DpDomain> domain = domainRepository.findById(pId);
		if (domain != null && domain.isPresent()) {
			return domain.get();
		}
		return null;
	}
	
	/**
	 * Gets the sub domain.
	 *
	 * @param pId the id
	 * @return the sub domain
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpSubDomain getSubDomain(int pId) throws GenericDaoException {
		Optional<DpSubDomain> domain = subDomainRepository.findById(pId);
		if (domain != null && domain.isPresent()) {
			return domain.get();
		}
		return null;
	}
	
	/**
	 * Gets the subscription type.
	 *
	 * @param pId the id
	 * @return the subscription type
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpSubscriptionType getSubscriptionType(int pId) throws GenericDaoException {
		Optional<DpSubscriptionType> subscriptionType = subscriptionTypeRepository.findById(pId);
		if (subscriptionType != null && subscriptionType.isPresent()) {
			return subscriptionType.get();
		}
		return null;
	}
	
	
	/**
	 * Creates the subscription type domain.
	 *
	 * @param pSubscriptionType the subscription type
	 * @param pRequest the request
	 * @return the dp subscription type
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpSubscriptionType createSubscriptionTypeDomain(DpSubscriptionType pSubscriptionType, SubscriptionTypeRequest pRequest) throws GenericDaoException {
			if (pSubscriptionType == null) {
				throw new GenericDaoException(Error.DOMAIN_BAD_REQUEST.getCode(), 
						Error.DOMAIN_BAD_REQUEST.getLabel(), Error.DOMAIN_BAD_REQUEST.getValue());
			} else if (DpUtils.isEmptyString(pSubscriptionType.getName())) {
				throw new GenericDaoException(Error.SUBSCRIPTION_TYPE_NAME_REQUIRED.getCode(), 
						Error.SUBSCRIPTION_TYPE_NAME_REQUIRED.getLabel(), Error.SUBSCRIPTION_TYPE_NAME_REQUIRED.getValue());
			} else if (pSubscriptionType.getCost() == null) {
				throw new GenericDaoException(Error.SUBSCRIPTION_TYPE_COST_REQUIRED.getCode(), 
						Error.SUBSCRIPTION_TYPE_COST_REQUIRED.getLabel(), Error.SUBSCRIPTION_TYPE_COST_REQUIRED.getValue());
			} else if (pRequest.getDomainId() == null) {
				throw new GenericDaoException(Error.DOMAIN_ROOT_REQUIRED.getCode(), 
						Error.DOMAIN_ROOT_REQUIRED.getLabel(), Error.DOMAIN_ROOT_REQUIRED.getValue());
			}
			DpDomain domain = getDomain(pRequest.getDomainId());
			if (domain != null) {
				pSubscriptionType.setStatus(SubscriptionType.ACTIVE.getValue());
				if (pRequest.getFeatures() != null && !pRequest.getFeatures().isEmpty()) {
					List<DpSubscriptionFeature> features = new ArrayList<DpSubscriptionFeature>();
					for (FeatureRequest feature : pRequest.getFeatures()) {
						DpSubscriptionFeature subFeature = new DpSubscriptionFeature();
						BeanUtils.copyProperties(feature, subFeature);
						subFeature = subscriptionFeatureRepository.save(subFeature);
						if (subFeature != null) {
							features.add(subFeature);
						}
					}
					if (features != null && !features.isEmpty()) {
						pSubscriptionType.setFeatures(features);
					}
				}
				pSubscriptionType.setDomainId(domain);
				pSubscriptionType.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
				pSubscriptionType.setLastModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
				DpSubscriptionType updatedSubscriptionType = subscriptionTypeRepository.save(pSubscriptionType);
				return updatedSubscriptionType;
			} else {
				throw new GenericDaoException(Error.DOMAIN_NOT_FOUND.getCode(), 
						Error.DOMAIN_NOT_FOUND.getLabel(), Error.DOMAIN_NOT_FOUND.getValue());
			}
			
		
	}
	
	/**
	 * Update subscription type domain.
	 *
	 * @param pRequest the request
	 * @return the dp subscription type
	 * @throws GenericDaoException the generic dao exception
	 */
	public DpSubscriptionType updateSubscriptionTypeDomain(SubscriptionTypeRequest pRequest) throws GenericDaoException {
		if (pRequest == null) {
			throw new GenericDaoException(Error.DOMAIN_BAD_REQUEST.getCode(), 
					Error.DOMAIN_BAD_REQUEST.getLabel(), Error.DOMAIN_BAD_REQUEST.getValue());
		}  else if (pRequest.getId() == null) {
			throw new GenericDaoException(Error.SUBSCRIPTION_TYPE_ID_REQUIRED.getCode(), 
					Error.SUBSCRIPTION_TYPE_ID_REQUIRED.getLabel(), Error.SUBSCRIPTION_TYPE_ID_REQUIRED.getValue());
		}
		DpSubscriptionType subscriptionType = getSubscriptionType(pRequest.getId().intValue());
		if (subscriptionType != null) {
			String status = pRequest.getStatus();
			if (!DpUtils.isEmptyString(status)) {
				subscriptionType.setStatus(status);
			}
			subscriptionType.setLastModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
			DpSubscriptionType updatedSubscriptionType = subscriptionTypeRepository.save(subscriptionType);
			// fetch the domain
			return updatedSubscriptionType;
		} else {
			throw new GenericDaoException(Error.SUBSCRIPTION_TYPE_NOT_FOUND.getCode(), 
					Error.SUBSCRIPTION_TYPE_NOT_FOUND.getLabel(), Error.SUBSCRIPTION_TYPE_NOT_FOUND.getValue());
		}
	
	}
	
	public List<DpSubscriptionType> getSubscriptionTypeBasedOnDomain(Integer pId) throws GenericDaoException {
		List<DpSubscriptionType> subscriptionTypes = null;
		subscriptionTypes = subscriptionTypeRepository.getSubscriptionTypeBasedOnDomain(pId);
		return subscriptionTypes;
	}
	


	
}
