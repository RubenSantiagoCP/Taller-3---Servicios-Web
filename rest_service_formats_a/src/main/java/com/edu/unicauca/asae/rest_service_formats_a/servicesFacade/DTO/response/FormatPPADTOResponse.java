package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response;


import lombok.Data;

@Data
public class FormatPPADTOResponse extends FormatDTOResponse{
    private String student;
    private String organizationAdvisor;
    private String acceptanceLetter;
}
