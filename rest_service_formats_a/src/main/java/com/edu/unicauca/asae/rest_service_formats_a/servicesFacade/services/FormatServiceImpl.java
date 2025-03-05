package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.services;

import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.enums.FormatState;
import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models.FormatEntity;
import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.repositories.FormatRepository;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.FormatDTORequest;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.FormatDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.ResultDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.Format;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state.FormatStateServiceEnum;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state.Result;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service("IDFacadeFormatService")
@AllArgsConstructor
@NoArgsConstructor
public class FormatServiceImpl implements IFormatService {
    @Qualifier("IDFormatRepository")
    private FormatRepository formatRepository;
	private ModelMapper modelMapper;




    @Override
    public FormatDTOResponse save(FormatDTORequest format) {
        FormatEntity formatEntity = this.modelMapper.map(format, FormatEntity.class);
        formatEntity.setState(FormatState.FORMULATED);
        FormatEntity savedFormatEntity = this.formatRepository.addFormat(formatEntity);
        System.out.println(savedFormatEntity);
        FormatDTOResponse formatDTO = this.modelMapper.map(savedFormatEntity, FormatDTOResponse.class);
        return formatDTO;
    }


    @Override
    public FormatDTOResponse findById(Long id) {
        FormatDTOResponse formatResponse = null;
        Optional<FormatEntity> optionalFormat = this.formatRepository.getFormat(id);
        if (optionalFormat.isPresent()) {
            FormatEntity formatEntity = optionalFormat.get();
            formatResponse = this.modelMapper.map(formatEntity, FormatDTOResponse.class);
        }
        return formatResponse;
    }

    @Override
    public List<FormatDTOResponse> getFormatsBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        List<FormatDTOResponse> listaRetornar;
        Optional<Collection<FormatEntity>> formatsEntityOpt = this.formatRepository.getFormatsBetweenDates(startDate, endDate);
        
        // Si el Optional está vacío, devolvemos una lista vacía
        if (formatsEntityOpt.isEmpty()) {
            listaRetornar = List.of(); // Retorna una lista inmutable vacía
        } else {
            // Convertimos la colección a una lista y la mapeamos a FormatDTOResponse
            Collection<FormatEntity> formatsEntity = formatsEntityOpt.get();
            listaRetornar = this.modelMapper.map(formatsEntity, new TypeToken<List<FormatDTOResponse>>() {}.getType());
        }
        return listaRetornar;
    }
    
    @Override
    public ResultDTOResponse updateState(Long id, FormatDTORequest format) {
        Format formatDomain = this.modelMapper.map(formatRepository.getFormat(id).orElseThrow(), Format.class);
        FormatStateServiceEnum targetState = FormatStateServiceEnum.valueOf(format.getState());
        Result res = changeState(formatDomain,targetState);
        if(res.success()){
            FormatEntity updatedFormatEntity = this.modelMapper.map(formatDomain, FormatEntity.class);
            this.formatRepository.updateById(id, updatedFormatEntity);
        }
        return modelMapper.map(res, ResultDTOResponse.class);
    }


    private Result changeState(Format formatDomain,FormatStateServiceEnum state){
        switch (state){
            case FORMULATED:
                return formatDomain.sendToFormulated();
            case UNDER_REVIEW:
                return formatDomain.sendToReview();
            case TO_BE_FIXED:
                return formatDomain.sendToCorrection();
            case REJECTED:
                return formatDomain.sendToRejected();
            case APPROVED:
                return formatDomain.sendToApproval();
        }
        return null;
    }
}