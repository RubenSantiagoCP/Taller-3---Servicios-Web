package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state;

import lombok.Data;

@Data
public class Result {
    private final boolean success;
    private final String message;
}