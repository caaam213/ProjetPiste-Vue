package com.epul.permispiste.service;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.dto.ActionDTO;
import com.epul.permispiste.repositories.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class ActionService{

    @Autowired
    private ActionRepository actionRepository;

    public ActionEntity getAction(int id) {
        ActionEntity action = null;
        try {
            action = actionRepository.findById(id).orElse(action);
        } catch (Exception e) {
            System.out.println(e);
        }
        return action;
    }


    public ActionEntity getActionById(int id) {
        return actionRepository.findActionEntityById(id);


    }
    public ActionDTO getActionDTOById(int id) {
        ActionEntity action =  actionRepository.findActionEntityById(id);
        ActionDTO actionDTO = new ActionDTO();
        actionDTO.setIdAction(action.getId());
        actionDTO.setWording(action.getWording());
        actionDTO.setScoreMin(action.getScoreMinimum());
        return actionDTO;

    }

    public List<ActionDTO> getAllAction() {
        List<ActionDTO> actionsDTO=new ArrayList<>();
        try {
            List<ActionEntity> actions= actionRepository.findAll();
            for(ActionEntity action:actions)
            {
                ActionDTO actionDTO = new ActionDTO();
                actionDTO.setIdAction(action.getId());
                actionDTO.setWording(action.getWording());
                actionDTO.setScoreMin(action.getScoreMinimum());
                actionsDTO.add(actionDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return actionsDTO;
    }

    public void addAction(ActionEntity actionEntity) {
        actionRepository.save(actionEntity);
    }

    public void editAction(ActionEntity actionEntity) {
        System.out.println("ICI : "+actionEntity.getId());
        ActionEntity action = actionRepository.findById(actionEntity.getId()).get();
        action.setWording(actionEntity.getWording());
        action.setScoreMinimum(actionEntity.getScoreMinimum());
        actionRepository.save(action);
    }

    public void delete(int id) {
        ActionEntity action = actionRepository.findById(id).get();
        actionRepository.delete(action);
    }

}
