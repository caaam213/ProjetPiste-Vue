package com.epul.permispiste.service;

import com.epul.permispiste.domains.IndicatorEntity;
import com.epul.permispiste.repositories.IndicateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndicateurService {

    public IndicateurRepository repository;

    @Autowired
    public IndicateurService(IndicateurRepository repository) {
        this.repository = repository;
    }

    public List<IndicatorEntity> findAllByFkAction(int idAction) {
        return repository.findAllByFkAction(idAction);
    }
}
