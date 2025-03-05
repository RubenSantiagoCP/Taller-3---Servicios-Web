package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormatDTORequest {
    private String state;
}
