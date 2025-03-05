package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.Format;

public interface IState {
    Result sendToReview(Format format);
    Result sendToApproval(Format format);
    Result sendToFormulated(Format format);
    Result sendToCorrection(Format format);
    Result sendToRejected(Format format);
}
