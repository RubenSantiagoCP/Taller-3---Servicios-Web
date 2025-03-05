package com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models;

import java.time.LocalDateTime;
import java.util.List;

import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.enums.FormatState;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class FormatEntity {
    private Long id;
    private String title;
    private String directorName;
    private LocalDateTime date;
    private FormatState state;
    private String generalObjective;
    private List<String> specificObjectives;
    private String stimatedTime;
    private String observations;


}
