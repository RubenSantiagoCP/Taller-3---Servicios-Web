package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.Format;

public class RejectedState implements IState {

    @Override
    public Result sendToReview(Format format) {
        return new Result(false, "A rejected format cannot be sent to review again");
    }

    @Override
    public Result sendToApproval(Format format) {
        return new Result(false, "A rejected format cannot be sent to approval");
    }

    @Override
    public Result sendToFormulated(Format format) {
        return new Result(false, "A rejected format cannot be sent to formulated");
    }

    @Override
    public Result sendToCorrection(Format format) {
        return new Result(false, "A rejected format cannot be sent to correction");
    }

    @Override
    public Result sendToRejected(Format format) {
        return new Result(false, "A rejected format cannot be rejected again");
    }
    
}
