package com.epul.permispiste.service;

import com.epul.permispiste.domains.ActionJeuEntity;
import com.epul.permispiste.domains.JeuEntity;
import com.epul.permispiste.domains.UtilisateurEntity;
import com.epul.permispiste.domains.UtilisateurJeuEntity;
import com.epul.permispiste.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class JeuService{

    private JeuRepository jeuRepository;
    private ActionJeuRepository actionJeuRepository;

    private UtilisateurJeuRepository inscriptionjeuRepository;

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public JeuService(JeuRepository jeuRepository,
                      ActionJeuRepository actionJeuRepository, UtilisateurJeuRepository inscriptionjeuRepository,
                      UtilisateurRepository utilisateurRepository) {
        this.jeuRepository = jeuRepository;
        this.actionJeuRepository = actionJeuRepository;
        this.inscriptionjeuRepository = inscriptionjeuRepository;
        this.utilisateurRepository = utilisateurRepository;
    }


    public JeuEntity addActionsEtJeu(String jeuString, List<Integer> actions, int utilisateur) {
        JeuEntity jeuEntity = new JeuEntity();
        jeuEntity.setLibellejeu(jeuString);
        jeuRepository.save(jeuEntity);

        Integer idJeu = jeuEntity.getId();


        // Inscrire le jeu à l'inscriptionjeuRepository.inscrireJeu(idJeu, inscription);
        UtilisateurJeuEntity utilisateurJeuEntity = new UtilisateurJeuEntity();
        JeuEntity jeu = jeuRepository.findJeuEntityById(idJeu);
        utilisateurJeuEntity.setJeuByFkJeu(jeu);

        UtilisateurEntity utilisateurEntity = utilisateurRepository.findByNumUtil(utilisateur);
        utilisateurJeuEntity.setUtilisateurByFkUtilisateur(utilisateurEntity);

        LocalDate today = LocalDate.now();
        utilisateurJeuEntity.setCalendrier(Date.valueOf(today));

        // Inscrire le jeu à l'utilisateur
        inscriptionjeuRepository.save(utilisateurJeuEntity);

        List<ActionJeuEntity> actionJeuEntities = new ArrayList<>();

        for (Integer action : actions) {
            ActionJeuEntity actionJeu = new ActionJeuEntity();
            actionJeu.setFkAction(action);
            actionJeu.setFkJeu(idJeu);
            System.out.println("Id action = " + action);

            actionJeuRepository.save(actionJeu); // Sauvegarder l'instance actuelle

            actionJeuEntities.add(actionJeu);
        }

        return jeuEntity;
    }



    public JeuEntity getJeubyID(int id) {
        return jeuRepository.findById(id);
    }

    public List<JeuEntity> getAllJeu() {
        return jeuRepository.findAll();
    }
}
