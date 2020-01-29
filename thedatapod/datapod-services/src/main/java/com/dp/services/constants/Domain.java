package com.dp.services.constants;

/**
 * The Enum Domain.
 */
public enum Domain {
	
	ACTIVE(1, "ACTIVE"), 
	DEACTIVE(2, "DEACTIVE"); 


    /** The code. */
    private final int code;
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new domain.
     *
     * @param code the code
     * @param value the value
     */
    Domain(int code, String value) {
        this.code = code;
        this.value = value;
    }
    
    /**
     * Gets the code.
     *
     * @return the code
     */
    public int getCode() {
        return this.code;
    }
    
    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

}
