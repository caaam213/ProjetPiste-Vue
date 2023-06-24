package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.UtilisateurJeuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurJeuRepository extends JpaRepository<UtilisateurJeuEntity, Integer> {

    public UtilisateurJeuEntity save(UtilisateurJeuEntity utilisateurJeuEntity);
    //Renvoie la liste de de JeuUTilisateur en fonction de l'id d'un apprenant
    public List<UtilisateurJeuEntity> findAllByFkUtilisateur(int id);

}
