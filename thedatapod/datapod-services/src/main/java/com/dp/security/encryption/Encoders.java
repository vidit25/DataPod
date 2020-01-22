package com.dp.security.encryption;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The Class Encoders.
 */
@Configuration
public class Encoders {

	/**
	 * Oauth client password encoder.
	 *
	 * @return the password encoder
	 */
	@Bean
	public PasswordEncoder oauthClientPasswordEncoder() {
		return new BCryptPasswordEncoder(4);
	}

	/**
	 * User password encoder.
	 *
	 * @return the password encoder
	 */
	@Bean
	public PasswordEncoder userPasswordEncoder() {
		return new BCryptPasswordEncoder(8);
	}
}
