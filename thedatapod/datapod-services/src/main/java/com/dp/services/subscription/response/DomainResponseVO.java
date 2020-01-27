package com.dp.services.subscription.response;

import java.util.List;

import com.dp.services.response.ErrorResponseVO;
import com.dp.services.response.GenericResponseVO;




/**
 * The Class DomainResponseVO.
 */
public class DomainResponseVO extends GenericResponseVO {
	
	public DomainResponseVO() {
	}
	
	public DomainResponseVO(boolean success, List<ErrorResponseVO> errors) {
		super(success, errors);
	}
	
	public DomainResponseVO(boolean success, Object responseObj) {
		super(success, responseObj);
	}
	
}
