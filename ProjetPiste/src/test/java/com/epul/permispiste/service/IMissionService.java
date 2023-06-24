package com.epul.permispiste.service;
import com.epul.permispiste.domains.MissionEntity;
import org.springframework.stereotype.Service;

@Service
public interface IMissionService
{
    MissionEntity addMission(MissionEntity missionEntity);

    MissionEntity getMissionById(int id);

    void editMission(MissionEntity missionEntity);

    void delete(int id);
}
