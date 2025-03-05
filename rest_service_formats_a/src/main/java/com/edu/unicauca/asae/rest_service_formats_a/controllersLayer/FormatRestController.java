package com.edu.unicauca.asae.rest_service_formats_a.controllersLayer;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request.FormatDTORequest;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response.FormatDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response.ResultDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.services.IFormatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping(value = "/update/{id}", consumes =  "application/json", produces = "application/json")
    public ResultDTOResponse updateFormat(@PathVariable Long id, @RequestBody FormatDTORequest format) {
        return facadeFormatService.updateState(id, format);
    }
    
}
