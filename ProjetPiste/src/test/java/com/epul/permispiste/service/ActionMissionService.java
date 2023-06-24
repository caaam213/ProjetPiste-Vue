package com.epul.permispiste.service;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.ActionMissionEntity;
import com.epul.permispiste.repositories.ActionMissionRepository;
import org.springframework.beans.factory.annotation.Autowired;


import com.epul.permispiste.domains.MissionEntity;
import org.springframework.stereotype.Service;


@Service
public class ActionMissionService {


    @Autowired
    private ActionMissionRepository actionMissionRepository;

    public void addActionMission(ActionMissionEntity actionMissionEntity) {
        actionMissionRepository.save(actionMissionEntity);
    }

}
