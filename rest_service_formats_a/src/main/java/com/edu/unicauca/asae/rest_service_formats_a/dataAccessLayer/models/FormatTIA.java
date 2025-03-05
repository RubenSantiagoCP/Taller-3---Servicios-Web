package com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class FormatTIA extends FormatEntity {
    
    private String student1;
    private String student2;

}
