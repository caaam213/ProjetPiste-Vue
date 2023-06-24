package com.epul.permispiste.service;

import com.epul.permispiste.domains.InscriptionActionEntity;
import com.epul.permispiste.repositories.InscriptionActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionActionService {

    public InscriptionActionRepository inscriptionActionRepository;

    @Autowired
    public InscriptionActionService(InscriptionActionRepository inscriptionActionRepository) {
        this.inscriptionActionRepository = inscriptionActionRepository;
    }

    public List<InscriptionActionEntity> getInscriptionActionsById(int id) {
        return inscriptionActionRepository.findAllByFkInscription(id);
    }

    public InscriptionActionEntity getInscriptionActionByIdAction(int idAction, int idInscription) {
        return inscriptionActionRepository.findByFkActionAndFkInscription(idAction, idInscription);
    }

    public void updateScore(int inscriptionId, int actionId, int score) {
        InscriptionActionEntity inscriptionActionEntity = getInscriptionActionByIdAction(actionId, inscriptionId);
        inscriptionActionEntity.setScore(score);
        inscriptionActionRepository.save(inscriptionActionEntity);
    }






}
