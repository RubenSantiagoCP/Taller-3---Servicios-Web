package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
public class FormatTIADTORequest extends FormatDTORequest {
    private String student1;
    private String student2;
}
