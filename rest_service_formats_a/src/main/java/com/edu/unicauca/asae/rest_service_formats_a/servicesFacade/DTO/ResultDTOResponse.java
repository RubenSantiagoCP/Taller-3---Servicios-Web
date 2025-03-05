package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ResultDTOResponse {
    boolean success;
    String message;
}
