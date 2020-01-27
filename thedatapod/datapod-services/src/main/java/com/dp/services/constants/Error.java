package com.dp.services.constants;

public enum Error {
	DOMAIN_BAD_REQUEST(1000, "error.missing.domain.request", "Bad domain request"), 
	DOMAIN_ID_MISSING(1001, "error.domain.id.required", "Please provide domain id"),
	DOMAIN_NOT_FOUND(1002, "error.domain.not.found", "Domain Not found"),
	DOMAIN_NAME_MISSING(1003, "error.domain.name.required", "Domain name is required");
	
	private final int code;
    
    private final String value;
    
    private final String label;


    Error(int code, String label, String value) {
        this.code = code;
        this.label = label;
        this.value = value;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public String getLabel() {
        return this.label;
    }

}
