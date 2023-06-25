package com.epul.permispiste.service;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.dto.ActionDTO;
import com.epul.permispiste.dto.MissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epul.permispiste.repositories.MissionRepository;


import java.util.ArrayList;
import java.util.List;


@Service
public class MissionService {

    @Autowired
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

    //TODO : setActionMission différent de null , régler le soucis de boucle infini
    public List<MissionDTO> getAllMissions() {
        List<MissionDTO> missionsDTO = new ArrayList<>();
        try {
            List<MissionEntity> missions = missionRepository.findAll();
            for (MissionEntity mission : missions) {
                MissionDTO missionDTO = new MissionDTO();
                missionDTO.setId(mission.getId());
                missionDTO.setWording(mission.getWording());
                missionsDTO.add(missionDTO);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return missionsDTO;
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

    public List<MissionDTO> findAll() {
        List<MissionEntity> missionsList =  missionRepository.findAll();
        List<MissionDTO> missionDTOS = new ArrayList<>();
        for (MissionEntity missionEntity : missionsList)
        {
            MissionDTO missionDTO = new MissionDTO();
            missionDTO.setId(missionEntity.getId());
            missionDTO.setWording(missionEntity.getWording());
            missionDTOS.add(missionDTO);
        }
        return missionDTOS;

    }
    public MissionEntity findMissionById(int id) {return missionRepository.findById(id); }

    public MissionDTO getMissionDTOById(int id) {
        MissionEntity mission = missionRepository.findById(id);
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(mission.getId());
        missionDTO.setWording(mission.getWording());
        return missionDTO;
    }
}
