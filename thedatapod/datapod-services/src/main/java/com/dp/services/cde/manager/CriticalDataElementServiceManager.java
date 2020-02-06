package com.dp.services.cde.manager;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dp.db.model.DpAccount;
import com.dp.db.model.DpCriticalDataElement;
import com.dp.services.cde.helper.FileProcessor;
import com.dp.db.model.DpDataElementMetaData;
import com.dp.db.model.DpUser;
import com.dp.db.repository.DataElementMetaDataRepository;
import com.dp.services.cde.request.CriticalDataElementRequest;
import com.dp.services.cde.tools.CriticalDataElementTools;
import com.dp.services.exception.GenericDaoException;
import com.dp.services.profile.manager.ProfileServiceManager;
import com.dp.services.response.GenericResponseVO;

/**
 * The Class CriticalDataElementServiceManager.
 */
@Service("criticalDataElementServiceManager")
public class CriticalDataElementServiceManager {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private CriticalDataElementTools criticalDataElementTools;
	
	@Autowired
	private FileProcessor excelFileProcessor;
	
	@Autowired
	private DataElementMetaDataRepository dataElementMetaDataRepository;
	
	@Autowired
	private ProfileServiceManager profileServiceManager;
	
	/**
	 * 
	 * @param subDomainIds
	 * @return
	 */
	public List<DpCriticalDataElement> getCriticalDataElementBySubDomain( List<Integer> subDomainIds) throws GenericDaoException {
		List<DpCriticalDataElement> criticalDataElements = criticalDataElementTools.getCriticalDataElementBySubDomain(subDomainIds);
		return criticalDataElements;
	}
	
	/**
	 * 
	 * @param userName
	 * @return
	 * @throws GenericDaoException
	 */
	public List<DpCriticalDataElement>  retrieveAssociatedFunctionalData(String userName) throws GenericDaoException {
		DpUser  dpUser = profileServiceManager.getUserBasedOnUserName(userName);
		List<DpCriticalDataElement> criticalDataElements = criticalDataElementTools.retrieveAssociatedFunctionalData(dpUser.getAccountId().getAccountId());
		return criticalDataElements;
	}
	
	/**
	 * 
	 * @param request
	 * @param userName
	 * @return
	 * @throws GenericDaoException
	 */
	public GenericResponseVO associateCriticalDataElement(CriticalDataElementRequest request, String userName) throws GenericDaoException {
		GenericResponseVO genericResponseVO = new GenericResponseVO();
		DpDataElementMetaData dataElementMetaData = new DpDataElementMetaData();
		List<Integer> dataElementIds = request.getDataElementIds();
		DpUser lUser = profileServiceManager.getUserBasedOnUserName(userName);
		System.out.println("Value of dataElements.. " + dataElementIds);
		System.out.println("Value of lUser... " + lUser);
		for (Integer id : dataElementIds) {
			dataElementMetaData = new DpDataElementMetaData();
			DpCriticalDataElement criticalDataElement = new DpCriticalDataElement();
			criticalDataElement.setId(id);
			dataElementMetaData.setCriticalDataElement(criticalDataElement);
			
			DpAccount account = new DpAccount();
			account.setAccountId(lUser.getAccountId().getAccountId());
			dataElementMetaData.setAccount(account);			
			dataElementMetaDataRepository.save(dataElementMetaData);
		}
		genericResponseVO.setSuccess(true);
		return genericResponseVO;
	}
	
	
	public void uploadFile(MultipartFile file,String accountId) throws GenericDaoException {
		excelFileProcessor.uploadFile(file, accountId);
		return;
	}
	
}
