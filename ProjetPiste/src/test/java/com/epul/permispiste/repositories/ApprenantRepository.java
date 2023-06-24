package com.epul.permispiste.repositories;


import com.epul.permispiste.domains.ApprenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenantRepository extends JpaRepository<ApprenantEntity, Integer> {

}