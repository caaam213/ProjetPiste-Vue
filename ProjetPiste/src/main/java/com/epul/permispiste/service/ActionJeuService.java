package com.epul.permispiste.service;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.ActionJeuEntity;
import com.epul.permispiste.dto.ActionDTO;
import com.epul.permispiste.repositories.ActionJeuRepository;
import com.epul.permispiste.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActionJeuService {

    public ActionJeuRepository actionJeuRepository;
    public ActionRepository actionRepository;

    @Autowired
    public ActionJeuService(ActionJeuRepository actionJeuRepository, ActionRepository actionRepository) {
        this.actionJeuRepository = actionJeuRepository;
        this.actionRepository = actionRepository;
    }

    public List<ActionDTO> getActionsByJeu(int id) {
        List<ActionDTO> listActionDTO = new ArrayList<>();
        List<ActionJeuEntity> actionJeuEntities = actionJeuRepository.findActionJeuEntitiesByFkJeu(id);
//        List<ActionEntity> actionEntities = new ArrayList<>();
        for (ActionJeuEntity actionJeuEntity : actionJeuEntities) {
            ActionEntity actionEntity = actionRepository.findActionEntityById(actionJeuEntity.getFkAction());
            ActionDTO actionDTO = new ActionDTO();
            actionDTO.setIdAction(actionEntity.getId());
            actionDTO.setWording(actionEntity.getWording());
            actionDTO.setScoreMin(actionEntity.getScoreMinimum());
            listActionDTO.add(actionDTO);
        }
        return listActionDTO;
    }
}
