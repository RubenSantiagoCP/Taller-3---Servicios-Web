package com.edu.unicauca.asae.rest_service_formats_a.controllersLayer;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request.FormatDTORequest;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response.FormatDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response.ResultDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.services.IFormatService;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/format")
@AllArgsConstructor
public class FormatRestController {

    @Qualifier("IDFacadeFormatService")
    private IFormatService facadeFormatService;


    @PostMapping(value = "/save", consumes =  "application/json", produces = "application/json")
    public FormatDTOResponse saveFormat(@RequestBody FormatDTORequest format) {
        return facadeFormatService.save(format);
    }

    @PatchMapping(value = "/updateState/{id}", consumes =  "application/json", produces = "application/json")
    public ResultDTOResponse updateFormat(@PathVariable Long id, @RequestParam(value = "state") String state) {
        return facadeFormatService.updateState(id, state);
    }   
    
    @GetMapping("/get/{id}")
    public FormatDTOResponse getFormat(@PathVariable Long id) {
        return facadeFormatService.findById(id);
    }
    
    @GetMapping("/getBetweenDates")
    public List<FormatDTOResponse> getFormatsBetweenDates(@RequestParam(value = "startDate") LocalDate startDate, @RequestParam(value = "endDate") LocalDate endDate) {
        return facadeFormatService.getFormatsBetweenDates(startDate, endDate);
    }

    @PutMapping("/update/{id}")
    public ResultDTOResponse updateFormat(@PathVariable Long id, @RequestBody FormatDTORequest format) {
        return facadeFormatService.update(id, format);
    }
    
}
