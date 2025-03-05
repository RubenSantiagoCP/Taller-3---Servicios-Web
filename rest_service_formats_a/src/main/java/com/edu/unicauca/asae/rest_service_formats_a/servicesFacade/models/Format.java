package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state.FormatStateServiceEnum;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state.Result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Format {
    private FormatStateServiceEnum state;

    public Format() {
        this.state = FormatStateServiceEnum.FORMULATED;
    }

    public Result sendToReview() {
        return this.state.getState().sendToReview(this);
    }

    public Result sendToApproval() {
        return this.state.getState().sendToApproval(this);
    }

    public Result sendToFormulated() {
        return this.state.getState().sendToFormulated(this);
    }

    public Result sendToCorrection() {
        return this.state.getState().sendToCorrection(this);
    }

    public Result sendToRejected() {
        return this.state.getState().sendToRejected(this);
    }

}
