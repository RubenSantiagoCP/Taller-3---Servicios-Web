package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormatPPADTOResponse extends FormatDTOResponse{
    private String student;
    private String organizationAdvisor;
    private String acceptanceLetter;
}
