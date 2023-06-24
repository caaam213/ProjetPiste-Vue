package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.ActionJeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionJeuRepository extends JpaRepository<ActionJeuEntity, Integer> {

    public ActionJeuEntity save(ActionJeuEntity actionJeuEntity);

    public List<ActionJeuEntity> findActionJeuEntitiesByFkJeu(int id);


}
