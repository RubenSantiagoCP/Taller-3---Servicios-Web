package com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.repositories;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models.FormatPPAEntity;
import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models.FormatTIAEntity;
import org.springframework.boot.actuate.endpoint.invoker.cache.CachingOperationInvokerAdvisor;
import org.springframework.stereotype.Repository;

import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.enums.FormatState;
import com.edu.unicauca.asae.rest_service_formats_a.dataAccessLayer.models.FormatEntity;

@Repository("IDFormatRepository")
public class FormatRepository {

    private Map<Long, FormatEntity> formatMap;

    public FormatRepository(CachingOperationInvokerAdvisor cachingOperationInvokerAdvisor) {
        formatMap = new HashMap<>();
    }

    public FormatEntity addFormat(FormatEntity format) {
        System.out.println("Adding format");
        if(format instanceof FormatTIAEntity) {
            System.out.printf("TIA:"+(FormatTIAEntity)format);

        }else if(format instanceof FormatPPAEntity) {
            System.out.printf("PPA:"+(FormatPPAEntity)format);
        }
        Long idFormat = (long) formatMap.size();
        format.setId(idFormat);
        formatMap.put(idFormat, format);
        return formatMap.get(idFormat);
    }

    public Optional<FormatEntity> getFormat(Long id) {
        System.out.println("Getting format");
        return Optional.ofNullable(formatMap.get(id));
    }

    public Optional<Collection<FormatEntity>> getFormatsBetweenDates(LocalDate startDate, LocalDate endDate) {
        System.out.println("Getting formats between dates");
        Collection<FormatEntity> formats = this.formatMap.values().stream()
                .filter(format -> format.getCreatedAt().isAfter(startDate) && format.getCreatedAt().isBefore(endDate))
                .collect(Collectors.toList());
        return Optional.ofNullable(formats);
    }

    public Optional<FormatEntity> updateById(Long id, FormatEntity format) {
        Optional<FormatEntity> respuesta;
        System.out.println("Updating format");

        if(this.formatMap.containsKey(id)) {
            this.formatMap.put(id, format);
            respuesta = Optional.of(format);

        }else{
            respuesta = Optional.empty();
        }
        return respuesta;
    }

    public Optional<FormatEntity> changeState(Long id, String State) {
         System.out.println("Changing State");
         if (this.formatMap.containsKey(id)) {
             this.formatMap.get(id).setState(FormatState.valueOf(State));
         }
         return Optional.ofNullable(this.formatMap.get(id));
     }
}
