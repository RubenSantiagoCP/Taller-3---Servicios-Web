package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.services;

import java.time.LocalDateTime;
import java.util.List;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.FormatDTORequest;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.FormatDTOResponse;

public interface IFormatService {

    public FormatDTOResponse save(FormatDTORequest format);  
    public FormatDTOResponse findById(Long id);
    public List<FormatDTOResponse> getFormatsBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
    public FormatDTOResponse update(Long id, FormatDTORequest format)

}