package com.dp.db.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class DpContactInfo.
 */
@Entity
@Table(name = "address")
public class DpContactInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7553348001676414693L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer id;
	
	/** The name. */
	@Column(name = "address_line_1")
	private String addressLineOne;
	
	/** The description. */
	@Column(name = "address_line_2")
	private String addressLineTwo;
	
	/** The city. */
	@Column(name = "city")
	private String city;
	
	/** The state. */
	@Column(name = "state")
	private String state;
	
	
	/** The country. */
	@Column(name = "country")
	private String country;
	
	/** The pin code. */
	@Column(name = "pinCode")
	private String pinCode;
	


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the address line one.
	 *
	 * @return the address line one
	 */
	public String getAddressLineOne() {
		return addressLineOne;
	}

	/**
	 * Sets the address line one.
	 *
	 * @param addressLineOne the new address line one
	 */
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	/**
	 * Gets the address line two.
	 *
	 * @return the address line two
	 */
	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	/**
	 * Sets the address line two.
	 *
	 * @param addressLineTwo the new address line two
	 */
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the pin code.
	 *
	 * @return the pin code
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * Sets the pin code.
	 *
	 * @param pinCode the new pin code
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

		
	
}
