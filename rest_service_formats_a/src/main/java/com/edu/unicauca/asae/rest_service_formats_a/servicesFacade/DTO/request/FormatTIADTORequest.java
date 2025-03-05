package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request;

import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models.FormatEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FormatTIADTORequest extends FormatDTORequest {
    private String student1;
    private String student2;
}
