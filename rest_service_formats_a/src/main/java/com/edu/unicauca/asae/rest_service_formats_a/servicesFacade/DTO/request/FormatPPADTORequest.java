package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormatPPADTORequest extends FormatDTORequest {
    private String student;
    private String organizationAdvisor;
    private String acceptanceLetter;
}
