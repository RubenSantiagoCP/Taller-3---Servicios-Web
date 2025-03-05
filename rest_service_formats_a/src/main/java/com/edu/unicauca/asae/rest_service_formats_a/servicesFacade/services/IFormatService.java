package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request.FormatDTORequest;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response.FormatDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response.ResultDTOResponse;

public interface IFormatService {

    public FormatDTOResponse save(FormatDTORequest format);  
    public FormatDTOResponse findById(Long id);
    public List<FormatDTOResponse> getFormatsBetweenDates(LocalDate startDate, LocalDate endDate);
    public ResultDTOResponse updateState(Long id, FormatDTORequest format);
    public FormatDTOResponse update(Long id, FormatDTORequest format);

}