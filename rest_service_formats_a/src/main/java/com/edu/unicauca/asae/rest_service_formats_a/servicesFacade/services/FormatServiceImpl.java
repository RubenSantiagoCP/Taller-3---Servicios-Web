package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.services;

import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.enums.FormatState;
import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models.FormatEntity;
import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models.FormatPPAEntity;
import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models.FormatTIA;
import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.repositories.FormatRepository;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request.FormatDTORequest;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request.FormatPPADTORequest;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.request.FormatTIADTORequest;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response.FormatDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.response.ResultDTOResponse;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.Format;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state.FormatStateServiceEnum;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.models.state.Result;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service("IDFacadeFormatService")
@AllArgsConstructor
public class FormatServiceImpl implements IFormatService {
    @Qualifier("IDFormatRepository")
    private FormatRepository formatRepository;

	private ModelMapper modelMapper;




    @Override
    public FormatDTOResponse save(FormatDTORequest format) {
        FormatEntity formatEntity = this.modelMapper.map(format, FormatEntity.class);
        formatEntity.setState(FormatState.FORMULATED);
        formatEntity.setCreatedAt(LocalDate.now());
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
    public List<FormatDTOResponse> getFormatsBetweenDates(LocalDate startDate, LocalDate endDate) {
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
    public ResultDTOResponse updateState(Long id, String state) {
        Format formatDomain = this.modelMapper.map(formatRepository.getFormat(id).orElseThrow(), Format.class);
        FormatStateServiceEnum targetState = FormatStateServiceEnum.valueOf(state);
        Result res = changeState(formatDomain,targetState);
        if(res.isSuccess()){
            this.formatRepository.changeState(id, formatDomain.getState().toString());
        }
        return modelMapper.map(res, ResultDTOResponse.class);
    }

    @Override
    public FormatDTOResponse update(Long id, FormatDTORequest format) {
        FormatEntity formateUpdate = null;
        Optional<FormatEntity> optionalFormat = this.formatRepository.getFormat(id);



        if (optionalFormat.isPresent()) {
            formateUpdate = optionalFormat.get();
            formateUpdate.setTitle(format.getTitle());
            formateUpdate.setDirectorName(format.getDirectorName());
            //formateUpdate.setCreatedAt(format.getCreatedAt());
            formateUpdate.setGeneralObjective(format.getGeneralObjective());
            formateUpdate.setSpecificObjectives(format.getSpecificObjectives());
            formateUpdate.setStimatedTime(format.getStimatedTime());
            formateUpdate.setObservations(format.getObservations());
            if(format instanceof FormatPPADTORequest){
                FormatPPAEntity formateUpdatePPA = (FormatPPAEntity) formateUpdate;
                formateUpdatePPA.setStudent(((FormatPPADTORequest) format).getStudent());
                formateUpdatePPA.setOrganizationAdvisor(((FormatPPADTORequest) format).getOrganizationAdvisor());
                formateUpdatePPA.setAcceptanceLetter(((FormatPPADTORequest) format).getAcceptanceLetter());
            } else if (format instanceof FormatTIADTORequest) {
                FormatTIA formateUpdateTIA = (FormatTIA) formateUpdate;
                formateUpdateTIA.setStudent1(((FormatTIADTORequest) format).getStudent1());
                formateUpdateTIA.setStudent2(((FormatTIADTORequest) format).getStudent2());
            }
            this.formatRepository.updateById(id, formateUpdate);
        }
        return modelMapper.map(formateUpdate, FormatDTOResponse.class);
    }


    private Result changeState(Format formatDomain,FormatStateServiceEnum state){
        return switch (state) {
            case FORMULATED -> formatDomain.sendToFormulated();
            case UNDER_REVIEW -> formatDomain.sendToReview();
            case TO_BE_FIXED -> formatDomain.sendToCorrection();
            case REJECTED -> formatDomain.sendToRejected();
            case APPROVED -> formatDomain.sendToApproval();
        };
    }
}