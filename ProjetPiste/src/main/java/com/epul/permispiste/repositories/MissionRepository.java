package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.MissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<MissionEntity, Integer> {
    public MissionEntity findById(int id);
    public List<MissionEntity> findAll();

}


