package com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models;

import java.time.LocalDate;
import java.util.List;

import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.enums.FormatState;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@JsonSubTypes( { @JsonSubTypes.Type(value = FormatTIA.class, name = "FormatTIA") , @JsonSubTypes.Type(value = FormatPPAEntity.class, name = "FormatPPAEntity")})
public class FormatEntity {
    private Long id;
    private String title;
    private String directorName;
    private LocalDate createdAt;
    private FormatState state;
    private String generalObjective;
    private List<String> specificObjectives;
    private String stimatedTime;
    private String observations;


}
