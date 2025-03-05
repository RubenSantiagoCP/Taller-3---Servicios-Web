package com.edu.unicauca.asae.rest_service_formats_a.controllersLayer;

import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.FormatDTORequest;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.FormatDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.ResultDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.services.FormatServiceImpl;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.services.IFormatService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
