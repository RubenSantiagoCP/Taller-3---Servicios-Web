package com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.enums;

public enum FormatState {
    FORMULATED("Formulated"),  
    UNDER_REVIEW("Under Evaluation"),  
    TO_BE_FIXED("Needs Correction"),  
    REJECTED("Rejected"),  
    APPROVED("Approved");  

    private final String description;

    FormatState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
