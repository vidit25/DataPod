package com.dp.services.constants;

/**
 * The Enum SubscriptionType.
 */
public enum SubscriptionType {
	
	INITIATED(100, "INITIATED"),
	ACTIVE(101, "ACTIVE"),
	SUSPENDED(102, "SUSPENDED"),
	DEACTIVE(103, "DEACTIVE"); 


    /** The code. */
    private final int code;
    
    /** The value. */
    private final String value;

    /**
     * Instantiates a new subscription type.
     *
     * @param code the code
     * @param value the value
     */
    SubscriptionType(int code, String value) {
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
