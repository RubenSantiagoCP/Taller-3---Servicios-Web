package com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class FormatTIA extends FormatEntity {
    
    private StudentEntity student1;
    private StudentEntity student2;

}
