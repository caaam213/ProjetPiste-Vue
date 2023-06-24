package com.epul.permispiste.service;

import com.epul.permispiste.domains.*;
import com.epul.permispiste.repositories.ActionMissionRepository;
import com.epul.permispiste.repositories.ActionRepository;
import com.epul.permispiste.repositories.InscriptionActionRepository;
import com.epul.permispiste.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Service
public class InscriptionService implements IInscriptionService {

    public InscriptionRepository inscriptionRepository;

    public ActionMissionRepository actionMissionRepository;

    public ActionRepository actionRepository;
    public InscriptionActionRepository inscriptionActionRepository;


    @Autowired
    public InscriptionService(InscriptionRepository inscriptionRepository,
                              ActionMissionRepository actionMissionRepository,
                              ActionRepository actionRepository, InscriptionActionRepository inscriptionActionRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.actionMissionRepository = actionMissionRepository;
        this.actionRepository = actionRepository;
        this.inscriptionActionRepository = inscriptionActionRepository;
    }

    public List<InscriptionEntity> getInscriptionsByIdUsers(int id) {
        return inscriptionRepository.findAllByFkUser(id);
    }

    public InscriptionEntity addNewInscription(int idApp, int idMission) {
        InscriptionEntity nouvelleInscription = new InscriptionEntity();
        //Ajout de la nouvelleinscription
        nouvelleInscription.setFkUser(idApp);
        nouvelleInscription.setFkMission(idMission);

        //Ajout de la Date en java.sql.Date
        java.util.Date currentDate = new java.util.Date();
        Date sqlDate = new Date(currentDate.getTime());
        nouvelleInscription.setDate(sqlDate);

        InscriptionEntity inscription = inscriptionRepository.save(nouvelleInscription);

        return nouvelleInscription;

    }

    public void addNewInscriptionAction(int idApp, int idMission, int idInscription){
        // Avoir la liste de toutes les inscription pour un utilisateur
        List<Integer> listActionsUtilisateur =  new ArrayList<>();
        InscriptionEntity inscriptionAdded = inscriptionRepository.findInscriptionEntityById(idInscription);
        List<InscriptionEntity> inscriptionEntityList = inscriptionRepository.findAllByFkUser(idApp);
        System.out.println("liste inscriptionEntityList : "+ inscriptionEntityList);

        for (InscriptionEntity inscriptionEntity : inscriptionEntityList)
        {
            List<InscriptionActionEntity> inscriptionActionEntityList =
                    inscriptionActionRepository.findAllByFkInscription(inscriptionEntity.getId());
            System.out.println("Liste inscription entity");

            for (InscriptionActionEntity  inscriptionActionEntity : inscriptionActionEntityList){
                //ActionEntity actionAlready = actionRepository.findActionEntityById(inscriptionActionEntity.getFkAction());
                System.out.println("Liste Actioninscription entity");
                if (!listActionsUtilisateur.contains(inscriptionActionEntity.getFkAction()))
                {
                    listActionsUtilisateur.add(inscriptionActionEntity.getFkAction());
                }
            }

        }

        List<ActionMissionEntity> actionMissionEntities = actionMissionRepository.findActionMissionEntitiesByFkMission(idMission);
        System.out.println("actionMission list "+ actionMissionEntities);
        for (ActionMissionEntity actionMissionEntity : actionMissionEntities ) {
            ActionEntity action = actionRepository.findActionEntityById(actionMissionEntity.getFkAction());
            System.out.println("Action info : "+action.getId()+" "+action.getWording());
            // Si l'action n'existe pas déjà, on l'ajoute
            if(!listActionsUtilisateur.contains(action.getId())){
                InscriptionActionEntity inscriptionActionEntity = new InscriptionActionEntity();
                inscriptionActionEntity.setFkInscription(inscriptionAdded.getId());
                System.out.println("Id de l'action "+action.getId());
                inscriptionActionEntity.setFkAction(action.getId());
                inscriptionActionEntity.setScore(-1);
                inscriptionActionRepository.save(inscriptionActionEntity);
                System.out.println("action ajoutee "+action.getId());
            }

        }

    }


}
