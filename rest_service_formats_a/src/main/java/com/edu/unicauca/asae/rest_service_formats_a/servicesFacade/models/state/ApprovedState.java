package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.Format;

public class ApprovedState implements IState {

    @Override
    public Result sendToReview(Format format) {
        return new Result(false, "An approved format cannot be sent to review again");
    }

    @Override
    public Result sendToApproval(Format format) {
        return new Result(false, "An approved format cannot be sent to approval again");
    }

    @Override
    public Result sendToFormulated(Format format) {
        return new Result(false, "An approved format cannot be sent to formulated again");
    }

    @Override
    public Result sendToCorrection(Format format) {
        return new Result(false, "An approved format cannot be sent to correction again");
    }

    @Override
    public Result sendToRejected(Format format) {
        return new Result(false, "An approved format cannot be sent to rejected again");
    }
    
}
