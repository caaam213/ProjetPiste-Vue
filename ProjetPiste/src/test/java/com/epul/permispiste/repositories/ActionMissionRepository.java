package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.ActionMissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActionMissionRepository extends JpaRepository<ActionMissionEntity, Integer> {

    /*Récupère les actions liés à une mission*/
    List<ActionMissionEntity> findActionMissionEntitiesByFkMission(int idFkMission);

}
