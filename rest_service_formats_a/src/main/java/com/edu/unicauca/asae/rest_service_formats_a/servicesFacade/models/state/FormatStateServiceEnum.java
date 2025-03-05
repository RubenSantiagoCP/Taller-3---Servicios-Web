package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state;

public enum FormatStateServiceEnum {
    FORMULATED(new FormulatedState()),  
    UNDER_REVIEW(new UnderReviewState()),  
    TO_BE_FIXED(new ToBeFixedState()),  
    REJECTED(new RejectedState()),  
    APPROVED(new ApprovedState());  

    private final IState state;

    FormatStateServiceEnum(IState state) {
        this.state = state;
    }

    public IState getState() {
        return this.state;
    }
}
