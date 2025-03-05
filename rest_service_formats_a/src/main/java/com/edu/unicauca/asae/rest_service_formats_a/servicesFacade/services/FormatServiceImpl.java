package com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.services;

import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.repositories.FormatRepository;
import com.edu.unicauca.asae.rest_service_formats_a.servicesFacade.DTO.FormatDTOResponse;

@Service("IDFacadeFormatService")
@AllArgsConstructor
public class FormatServiceImpl implements IFormatService {
    @Qualifier("IDFormatRepository")
    private final FormatRepository formatRepository;
	private ModelMapper modelMapper;


    @Override
    public FormatDTOResponse save(FormatDTORequest format) {
        FormatEntity formatEntity = this.modelMapper.map(format, FormatEntity.class);
        formatEntity.setEstado(true);
        formatEntity.setCreateAt(new Date());
        FormatEntity savedFormatEntity = this.formatRepository.save(formatEntity);
        System.out.println(savedFormatEntity);
        FormatDTOResponse formatDTO = this.modelMapper.map(savedFormatEntity, FormatDTOResponse.class);
        return formatDTO;
    }
    
    @Override
    public FormatDTOResponse findById(Long id) {
        FormatDTOResponse formatResponse = null;
        Optional<FormatEntity> optionalFormat = this.formatRepository.findById(id);
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
    public FormatDTOResponse update(Long id, FormatDTORequest format) {
        // Implementation here
        return null;
    }
}