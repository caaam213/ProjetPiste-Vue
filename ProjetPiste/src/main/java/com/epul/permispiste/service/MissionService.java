package com.epul.permispiste.service;

import com.epul.permispiste.domains.MissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epul.permispiste.repositories.MissionRepository;


import java.util.List;


@Service
public class MissionService {

    private MissionRepository missionRepository;

    @Autowired
    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<MissionEntity> getAll(){
        List<MissionEntity> missions=null;
        try {
            missions = missionRepository.findAll();
        }catch (Exception e) {
            System.out.println(e);
        }
        return missions;
    }

    public void editMission(MissionEntity missionEntity) {
        MissionEntity mission = missionRepository.findById(missionEntity.getId());
        mission.setWording(missionEntity.getWording());
        missionRepository.save(mission);
    }


    public MissionEntity addMission(MissionEntity missionEntity)  {
        return missionRepository.save(missionEntity);
    }


    public MissionEntity getMissionById(int id) {
        return missionRepository.findById(id);
    }

    public void delete(int id) {
        MissionEntity mission = missionRepository.findById(id);
        missionRepository.delete(mission);
    }

    public List<MissionEntity> findAll() { return missionRepository.findAll();}
    public MissionEntity findMissionById(int id) {return missionRepository.findById(id); }
}
