package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.Format;

public class UnderReviewState implements IState {

    @Override
    public Result sendToReview(Format format) {
        return new Result(false, "A under review format cannot be sent to review");
    }

    @Override
    public Result sendToApproval(Format format) {
        format.setState(FormatStateServiceEnum.APPROVED);
        return new Result(true, "Format sent to approval");
    }

    @Override
    public Result sendToFormulated(Format format) {
        return new Result(false, "A under review format cannot be sent to formulated");
    }

    @Override
    public Result sendToCorrection(Format format) {
        format.setState(FormatStateServiceEnum.TO_BE_FIXED);
        return new Result(true, "Format sent to correction");
    }

    @Override
    public Result sendToRejected(Format format) {
        format.setState(FormatStateServiceEnum.REJECTED);
        return new Result(true, "Format sent to rejected");
    }
    
}
