package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
public class FormatPPADTORequest extends FormatDTORequest {
    private String student;
    private String organizationAdvisor;
    private String acceptanceLetter;
}
