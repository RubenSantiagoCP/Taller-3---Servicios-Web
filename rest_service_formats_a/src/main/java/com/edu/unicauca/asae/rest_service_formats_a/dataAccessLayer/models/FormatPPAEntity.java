package com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FormatPPAEntity extends FormatEntity {

    private String student;
    private String organizationAdvisor;
    private String acceptanceLetter;
}
