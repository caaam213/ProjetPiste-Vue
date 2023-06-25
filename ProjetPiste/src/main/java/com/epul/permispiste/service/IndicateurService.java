package com.epul.permispiste.service;

import com.epul.permispiste.domains.IndicatorEntity;
import com.epul.permispiste.dto.IndicatorDTO;
import com.epul.permispiste.repositories.IndicateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndicateurService {

    public IndicateurRepository repository;

    @Autowired
    public IndicateurService(IndicateurRepository repository) {
        this.repository = repository;
    }

    public List<IndicatorDTO> findAllByFkAction(int idAction) {
        List<IndicatorEntity> indicators = repository.findAllByFkAction(idAction);
        List<IndicatorDTO> indicatorDTOS = new ArrayList<>();
        for (IndicatorEntity indicator : indicators) {
            IndicatorDTO indicatorDTO = new IndicatorDTO();
            indicatorDTO.setId(indicator.getId());
            indicatorDTO.setWording(indicator.getWording());
            indicatorDTO.setValueIfCheck(indicator.getValueIfCheck());
            indicatorDTO.setValueIfUnCheck(indicator.getValueIfUnCheck());
            indicatorDTOS.add(indicatorDTO);
        }
        return indicatorDTOS;
    }
}
