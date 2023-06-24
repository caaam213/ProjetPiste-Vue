package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer> {

    public UtilisateurEntity getFirstByNomUtil(String nom);
    public UtilisateurEntity findByNumUtil(int num);
    UtilisateurEntity findUtilisateurEntitiesByNumUtil(int idUser);
    public List<UtilisateurEntity> findAllByRoleEquals(String role);
    List<UtilisateurEntity> findUtilisateurEntitiesByRole(String role);


}

