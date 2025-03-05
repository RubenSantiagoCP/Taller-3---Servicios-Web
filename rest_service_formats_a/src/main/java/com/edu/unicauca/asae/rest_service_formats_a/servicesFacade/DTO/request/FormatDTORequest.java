package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = FormatTIADTORequest.class, name = "FormatTIADTORequest") , @JsonSubTypes.Type(value = FormatPPADTORequest.class, name = "FormatPPADTORequest")})
public class FormatDTORequest {
    private String state;
    //private Long id;
    private String title;
    private String directorName;
    //private LocalDate createdAt;
    private String generalObjective;
    private List<String> specificObjectives;
    private String stimatedTime;
    private String observations;

}
