package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.Format;

public class ToBeFixedState implements IState {

    @Override
    public Result sendToReview(Format format) {
        format.setState(FormatStateServiceEnum.UNDER_REVIEW);
        return new Result(true, "Format sent to review");
    }

    @Override
    public Result sendToApproval(Format format) {
        return new Result(false, "A to be fixed format cannot be sent directly to approval");
    }

    @Override
    public Result sendToFormulated(Format format) {
        return new Result(false, "A to be fixed format cannot be sent to formulated");
    }

    @Override
    public Result sendToCorrection(Format format) {
        return new Result(false, "A to be fixed format cannot be sent to correction");
    }

    @Override
    public Result sendToRejected(Format format) {
        return new Result(false, "A to be fixed format cannot be sent to rejected");    
    }
    
}
