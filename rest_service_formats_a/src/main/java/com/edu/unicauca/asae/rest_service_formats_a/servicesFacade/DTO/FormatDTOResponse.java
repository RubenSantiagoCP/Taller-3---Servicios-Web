package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormatDTOResponse {
    String state;
}
