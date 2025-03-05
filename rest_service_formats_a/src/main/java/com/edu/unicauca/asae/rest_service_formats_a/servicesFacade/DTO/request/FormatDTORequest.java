package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormatDTORequest {
    private String state;
    //private Long id;
    private String title;
    private String directorName;
    private LocalDate createdAt;
    private String generalObjective;
    private List<String> specificObjectives;
    private String stimatedTime;
    private String observations;

}
