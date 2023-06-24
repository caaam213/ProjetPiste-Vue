package com.epul.permispiste.repositories;


import com.epul.permispiste.domains.ObjectifEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectifRepository
        extends JpaRepository<ObjectifEntity, Integer> {
}