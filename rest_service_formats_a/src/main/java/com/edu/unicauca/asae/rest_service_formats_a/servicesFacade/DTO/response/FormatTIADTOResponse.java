package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormatTIADTOResponse extends FormatDTOResponse{
    private String student1;
    private String student2;
}
