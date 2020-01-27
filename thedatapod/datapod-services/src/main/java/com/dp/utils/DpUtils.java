package com.dp.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dp.services.response.ErrorResponseVO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class DpUtils.
 */
public class DpUtils {
	
	/**
	 * Checks if is empty sting.
	 *
	 * @param pValue
	 *            the value
	 * @return true, if is empty sting
	 */
	public static boolean isEmptyString(String pValue) {
		boolean lIsEmpty = false;
		if (pValue == null) {
			return true;
		} else if (pValue != null && pValue.length() <= 0) {
			return true;
		} else if (pValue != null && pValue.length() > 1 && pValue.trim().length() <= 0) {
			return true;
		}
		return lIsEmpty;
	}
	
	/**
	 * Match password.
	 *
	 * @param password the password
	 * @param encriptedPassword the encripted password
	 * @return true, if successful
	 */
	public static boolean matchPassword(String password, String encriptedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(password, encriptedPassword);
	}
	
	/**
	 * B crypt.
	 *
	 * @param data
	 *            the data
	 * @return the string
	 */
	public static String bCrypt(String data) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(8);
		return passwordEncoder.encode(data);
	}
	
	/**
	 * Generate error response.
	 *
	 * @param errorMessage the error message
	 * @param errors the errors
	 * @param status the status
	 * @return the map
	 */
	public static Map<String, Object> generateErrorResponse(String errorMessage, 
			List<String> errors, String status) {
		Map<String, Object> errorResponse = new HashMap<String, Object>();
		errorResponse.put("success", false);
		errorResponse.put("errorResponse", errorMessage);
		errorResponse.put("status", status);
		errorResponse.put("errors", errors);
		return errorResponse;
	}
	
	 /**
     * Gets the json to map object.
     *
     * @param pJsonValue the json value
     * @return the json to map object
     * @throws JsonParseException the json parse exception
     * @throws JsonMappingException the json mapping exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, Object> getJsonToMapObject(String pJsonValue) throws JsonParseException, 
    JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> responseMap = mapper.readValue(pJsonValue, Map.class);		
		return responseMap;
    }
    
    /**
     * Gets the pojo to map object.
     *
     * @param pObj the obj
     * @return the pojo to map object
     * @throws JsonParseException the json parse exception
     * @throws JsonMappingException the json mapping exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Map<String, Object> getPojoToMapObject(Object pObj) throws JsonParseException, 
    JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> responseMap = mapper.convertValue(pObj, 
				new TypeReference<Map<String, Object>>() {});
		return responseMap;
    }
    
    /**
     * Generate error msg.
     *
     * @param pErrorCode the error code
     * @param pErrorLabel the error label
     * @param pMessage the message
     * @return the list
     */
    public static List<ErrorResponseVO> generateErrorMsg(int pErrorCode, String pErrorLabel, String pMessage) {
    	List<ErrorResponseVO> errors = new ArrayList<>();
    	ErrorResponseVO errorMsg = new ErrorResponseVO(pErrorCode, pErrorLabel, pMessage);
    	errors.add(errorMsg);
    	return errors;
    }

}
