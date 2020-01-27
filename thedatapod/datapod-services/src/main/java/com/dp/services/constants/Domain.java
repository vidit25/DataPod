package com.dp.services.constants;

public enum Domain {
	
	ACTIVE(1, "ACTIVE"), 
    MEDIUM(2, "DE-ACTIVE"); 


    private final int code;
    
    private final String value;

    Domain(int code, String value) {
        this.code = code;
        this.value = value;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getValue() {
        return this.value;
    }

}
