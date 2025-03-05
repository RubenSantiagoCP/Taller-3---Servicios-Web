package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state.FormatStateServiceEnum;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state.Result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Format {
    private FormatStateServiceEnum State;

    public Format() {
        this.State = FormatStateServiceEnum.FORMULATED;
    }

    public Result sendToReview() {
        return this.State.getState().sendToReview(this);
    }

    public Result sendToApproval() {
        return this.State.getState().sendToApproval(this);
    }

    public Result sendToFormulated() {
        return this.State.getState().sendToFormulated(this);
    }

    public Result sendToCorrection() {
        return this.State.getState().sendToCorrection(this);
    }

    public Result sendToRejected() {
        return this.State.getState().sendToRejected(this);
    }

}
