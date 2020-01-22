package com.dp.utils;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;



/**
 * The Class ResourceBundleHelper.
 */
@Component("resourceBundleHelperComponent")
public class ResourceBundleHelper {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** The message source. */
	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

	/**
	 * Gets the message.
	 *
	 * @param pErrorCode the error code
	 * @param pLocale the locale
	 * @return the message
	 */
	public String getMessage(String pErrorCode, String pLocale) {
		String lMessage = null;
		Locale lLocale = Locale.US;
		
		if (lLocale == null) {
			lLocale = new Locale(pLocale);
		}
		
		try {
			lMessage = messageSource.getMessage(pErrorCode, new Object[] {}, lLocale);
		} catch (Exception lE) {
			LOGGER.error(lE.getMessage());
		}
		if (StringUtils.isEmpty(lMessage)) {
			lMessage = pErrorCode;
		}
		return lMessage;
	}
}
