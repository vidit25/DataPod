package com.dp.db.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class LyUser.
 */
@Entity
@Table(name = "dp_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DpUser implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer userId;

	/** The email address. */
	@Column(name = "email")
	private String emailAddress;

	/** The first name. */
	@Column(name = "first_name")
	private String firstName;

	/** The last name. */
	@Column(name = "last_name")
	private String lastName;

	/** The user phone number. */
	@Column(name = "phone")
	private String phone;

	/** The user password. */
	@Column(name = "password")
	private String password;

	/** The user failed attempts at login. */
	@Column(name = "failure_attempts")
	private int failureCount;

	/** The user last login time. */
	@Column(name = "last_login")
	private Timestamp lastLogin;

	/** The user status. */
	@Column(name = "status")
	private String status;

	/** The password reset flag. */
	@Column(name = "reset_flag")
	private Boolean resetFlag;

	/** The account expired. */
	@Column(name = "account_expired")
	private boolean accountExpired;

	/** The account locked. */
	@Column(name = "account_locked")
	private boolean accountLocked;

	/** The credentials expired. */
	@Column(name = "credentials_expired")
	private boolean credentialsExpired;

	/** The enabled. */
	@Column(name = "enabled")
	private boolean enabled;

	/** The authorities. */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_authorities", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	@OrderBy
	private List<DpAuthority> authorities;
	
	/** The user type. */
	@Column(name = "type")
	private String type;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private DpAccount accountId;

	/**
	 * Checks if is account expired.
	 *
	 * @return true, if is account expired
	 */
	
	public boolean isAccountExpired() {
		return accountExpired;
	}

	/**
	 * Sets the account expired.
	 *
	 * @param accountExpired the new account expired
	 */
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	/**
	 * Checks if is account locked.
	 *
	 * @return true, if is account locked
	 */
	
	public boolean isAccountLocked() {
		return accountLocked;
	}

	/**
	 * Sets the account locked.
	 *
	 * @param accountLocked the new account locked
	 */
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	/**
	 * Checks if is credentials expired.
	 *
	 * @return true, if is credentials expired
	 */
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	/**
	 * Sets the credentials expired.
	 *
	 * @param credentialsExpired the new credentials expired
	 */
	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	
	public List<DpAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * Sets the authorities.
	 *
	 * @param authorities the new authorities
	 */
	public void setAuthorities(List<DpAuthority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * Gets the failure count.
	 *
	 * @return the failureCount
	 */
	public int getFailureCount() {
		return failureCount;
	}

	/**
	 * Sets the failure count.
	 *
	 * @param failureCount the failureCount to set
	 */
	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}

	/**
	 * Gets the last login.
	 *
	 * @return the lastLogin
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * Sets the last login.
	 *
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the email address.
	 *
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the reset flag.
	 *
	 * @return the resetFlag
	 */
	public Boolean getResetFlag() {
		return resetFlag;
	}

	/**
	 * Sets the reset flag.
	 *
	 * @param resetFlag the resetFlag to set
	 */
	public void setResetFlag(Boolean resetFlag) {
		this.resetFlag = resetFlag;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	
	public DpAccount getAccountId() {
		return accountId;
	}

	public void setAccountId(DpAccount accountId) {
		this.accountId = accountId;
	}

}
