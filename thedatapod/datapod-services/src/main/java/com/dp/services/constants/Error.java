package com.dp.services.constants;

/**
 * The Enum Error.
 */
public enum Error {
	SYSTEM_ERROR(999, "system.error", "System error!"),
	DOMAIN_BAD_REQUEST(1000, "error.missing.domain.request", "Bad domain request"), 
	DOMAIN_ID_MISSING(1001, "error.domain.id.required", "Please provide domain id"),
	DOMAIN_NOT_FOUND(1002, "error.domain.not.found", "Domain Not found"),
	DOMAIN_NAME_MISSING(1003, "error.domain.name.required", "Domain name is required"),
	DOMAIN_ROOT_REQUIRED(1004, "error.parent.domain.required", "Parent domain is required"),
	SUBSCRIPTION_TYPE_NAME_REQUIRED(1005, "error.subscription.type.name.required", "Subscription name is required"),
	SUBSCRIPTION_TYPE_COST_REQUIRED(1006, "error.subscription.type.cost.required", "Subscription base cost is required"),
	SUBSCRIPTION_TYPE_ID_REQUIRED(1007, "error.subscription.type.id.required", "Subscription base id is required"),
	SUBSCRIPTION_TYPE_NOT_FOUND(1008, "error.subscription.type.not.found", "Subscription type not found"),
	SUB_DOMAIN_ID_MISSING(1009, "error.sub.domain.id.required", "Please provide sub domain id"),
	ORGANIZATION_NAME(1010, "error.org.required", "Please provide organization name"),
	USER_EMAIL(1011, "error.user.email.required", "Please provide mail"),
	USER_SUBSCRIPTION_ALREADY_FOUND(1012, "error.user.subscription.already.found", "You have subscribed already. Please contact customer care."),
	SUBSCRIPTIONS_NOT_FOUND(1013, "error.no.subscription", "Subscriptions not available."),
	USER_NOT_FOUND(1014, "error.no.user.found", "User not found."),
	USER_SUBSCRIPTION_TYPE_ID_REQUIRED(10015, "error.user.subscription.id.required", "User Subscription id is required"),
	USER_SUBSCRIPTION_NOT_FOUND(10016, "error.user.subscription.not.found", "User Subscription not found"),
	ACCOUNT_CREATION_ERROR(10017, "error.account.creation.error", "Account creation error"),
	ACCOUNT_ALREADY_EXIST(10018, "error.account.already.exist", "Account already exist.");


	
	/** The code. */
	private final int code;
    
    /** The value. */
    private final String value;
    
    /** The label. */
    private final String label;


    /**
     * Instantiates a new error.
     *
     * @param code the code
     * @param label the label
     * @param value the value
     */
    Error(int code, String label, String value) {
        this.code = code;
        this.label = label;
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
    
    /**
     * Gets the label.
     *
     * @return the label
     */
    public String getLabel() {
        return this.label;
    }

}
