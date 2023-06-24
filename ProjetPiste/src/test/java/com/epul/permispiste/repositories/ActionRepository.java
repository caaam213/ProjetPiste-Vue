package com.epul.permispiste.repositories;


import com.epul.permispiste.domains.ActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, Integer> {

        public ActionEntity findActionEntityById(int id);

}

