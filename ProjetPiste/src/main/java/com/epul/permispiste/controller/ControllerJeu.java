package com.epul.permispiste.controller;

import com.epul.permispiste.classesjson.JeuCreationRequest;
import com.epul.permispiste.domains.*;
import com.epul.permispiste.dto.*;
import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RequestMapping("/jeu")
@RestController
@CrossOrigin
public class ControllerJeu {

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private InscriptionActionService inscriptionActionService;

    @Autowired
    private ActionService actionWRepoService;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private JeuService jeuService;

    @Autowired
    private ActionJeuService actionJeuService;

    @Autowired
    private IndicateurService indicateurService;

    @Autowired
    private UtilisateurService ServiceUtilisateur;
    @Autowired
    private UtilisateurJeuService unUtilisateurJeuService;

    @Autowired
    private ActionService unActionService;

    @GetMapping(value = "/choixApprenant")
    public ResponseEntity<?> selectionnerApprenant() {
        try {
            List<UtilisateurDTO> listeApprenants = ServiceUtilisateur.getAllApprenant();
            return ResponseEntity.ok(listeApprenants);
        } catch (MonException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    public List<ActionEntity> verifierDependances(ActionEntity action, InscriptionActionEntity inscription)
    {
        ArrayList<ActionEntity> actionsAAjouter = new ArrayList<>();
        while (action.getFkAction() != null)
        {
            ActionEntity actionMere = actionWRepoService.getActionById(action.getFkAction());

            InscriptionActionEntity inscriptionActionMere = inscriptionActionService.getInscriptionActionByIdAction(actionMere.getId(), inscription.getFkInscription());

            if (actionMere.getScoreMinimum() > inscriptionActionMere.getScore())
            {
                actionsAAjouter = new ArrayList<>();
                break;
            }
            else
            {
                actionsAAjouter.add(action);
                action = actionMere;
            }
        }
        return actionsAAjouter;
    }

    @GetMapping("/listeJeuxPossiblesApprenant")
    public ResponseEntity<List<ActionEntityWDernierScore>> getJeuxPossiblesPourUnApp(@RequestParam("idApprenant") int idApprenant) {
        List<ActionEntityWDernierScore> listeActionsWDernierScore = new ArrayList<>();

        try {
            // Récupération des informations sur l'utilisateur
            UtilisateurEntity utilisateur = utilisateurService.getUtilisateurById(idApprenant);

            List<InscriptionActionEntity> listeInscriptionActions;
            List<InscriptionEntity> listeInscriptionsPourUtilisateur;
            List<ActionEntity> listeActionsPossibles = new ArrayList<>();

            // On récupère toutes les inscriptions de l'apprenant
            listeInscriptionsPourUtilisateur = inscriptionService.getInscriptionsByIdUsers(idApprenant);
            for (InscriptionEntity inscription : listeInscriptionsPourUtilisateur) {
                // On récupère toutes les actions de l'inscription
                listeInscriptionActions = inscriptionActionService.getInscriptionActionsById(inscription.getId());

                // On récupère toutes les actions possibles
                for (InscriptionActionEntity inscriptionAction : listeInscriptionActions) {
                    ActionEntity action = actionWRepoService.getActionById(inscriptionAction.getFkAction());
                    if (action.getFkAction() == null) {
                        // Dans le cas où l'action n'a pas de dépendance
                        if (!listeActionsPossibles.contains(action)) {
                            ActionEntityWDernierScore actionWDernierScore = new ActionEntityWDernierScore(
                                    action.getId(),
                                    action.getWording(),
                                    "",
                                    action.getScoreMinimum(),
                                    inscriptionAction.getFkInscription(),
                                    inscriptionAction.getScore(),
                                    true
                            );
                            listeActionsWDernierScore.add(actionWDernierScore);
                        }
                    } else {
                        // Dans le cas où l'action a des dépendances
                        List<ActionEntity> actionsAAjouter = verifierDependances(action, inscriptionAction);

                        if (actionsAAjouter.size() == 0) {
                            ActionEntityWDernierScore actionWDernierScore = new ActionEntityWDernierScore(
                                    action.getId(),
                                    action.getWording(),
                                    actionWRepoService.getActionById(action.getFkAction()).getWording(),
                                    action.getScoreMinimum(),
                                    inscriptionAction.getFkInscription(),
                                    inscriptionAction.getScore(),
                                    false
                            );
                            listeActionsWDernierScore.add(actionWDernierScore);
                        } else {
                            for (ActionEntity actionAAjouter : actionsAAjouter) {
                                ActionEntityWDernierScore actionWDernierScore = new ActionEntityWDernierScore(
                                        actionAAjouter.getId(),
                                        actionAAjouter.getWording(),
                                        "",
                                        actionAAjouter.getScoreMinimum(),
                                        inscriptionAction.getFkInscription(),
                                        inscriptionAction.getScore(),
                                        true
                                );
                                listeActionsWDernierScore.add(actionWDernierScore);
                            }
                        }
                    }
                }
            }

            Collections.sort(listeActionsWDernierScore, new ActionWEntityWDernierScoreComparator());

            return ResponseEntity.ok(listeActionsWDernierScore);
        } catch (MonException e) {
            // Gérer les exceptions spécifiques
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            // Gérer les exceptions générales
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("/creerJeu")
    public ResponseEntity<String> creerJeu(@RequestBody JeuCreationRequest jeuRequest) {
        try {
            ArrayList<Integer> listeIdActions = new ArrayList<>();
            for (String option : jeuRequest.getActionsCheckbox()) {
                listeIdActions.add(Integer.parseInt(option));
            }

            JeuEntity jeu = jeuService.addActionsEtJeu(jeuRequest.getLibelleJeu(),
                    listeIdActions, jeuRequest.getIdApprenant());

            String idJeu = String.valueOf(jeu.getId());
            return ResponseEntity.status(HttpStatus.OK).body(idJeu);
        } catch (MonException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/jouer")
    public ResponseEntity<List<IndicatorsActions>> jouer(@RequestParam("idJeu") int idJeu,
                                                            @RequestParam("idApprenant") int idApprenant) {
        try {
            List<ActionDTO> listeActions = actionJeuService.getActionsByJeu(idJeu);
            List<IndicatorsActions> listeIndicateursActions = new ArrayList<>();

            for (ActionDTO action : listeActions) {
                // Récupérer les indicateurs de l'action
                List<IndicatorDTO> listeIndicateurs = indicateurService.findAllByFkAction(action.getIdAction());

                IndicatorsActions indicatorsActions = new IndicatorsActions(action, listeIndicateurs);
                listeIndicateursActions.add(indicatorsActions);
            }

            return ResponseEntity.ok().body(listeIndicateursActions);
        } catch (MonException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    public ActionDTO verifyIfActionIsInList(LinkedHashMap listeActions, int idAction)
    {
        ActionDTO action = null;
        Iterator it = listeActions.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            ActionDTO actionEntity = (ActionDTO) pair.getKey();
            if(actionEntity.getIdAction() == idAction)
            {
                action = actionEntity;
            }
        }
        return action;
    }

    // TODO : A transformer en API
//    @RequestMapping(value = "/validerJeu")
//    public ModelAndView validerJeu(HttpServletRequest request, HttpServletResponse response) throws Exception
//    {
//        String destinationPage = "";
//        try
//        {
//            // Récupération des indicateurs sélectionnés
//            String[] options = request.getParameterValues("checkboxesChecked");
//            List<String> idIndicateursSelected = new ArrayList<String>(Arrays.asList(options));
//            if (idIndicateursSelected.get(0) == "-1")
//            {
//                idIndicateursSelected.remove(0);
//            }
//
//            int idJeu = Integer.parseInt(request.getParameter("idJeu"));
//            int idApprenant = Integer.parseInt(request.getParameter("idApprenant"));
//
//            List<InscriptionEntity> listeInscriptions = inscriptionService.getInscriptionsByIdUsers(idApprenant);
//
//            List<ActionDTO> listeActions = actionJeuService.getActionsByJeu(idJeu);
//
//            LinkedHashMap<ActionDTO, Integer> actionsAAfficherScore = new LinkedHashMap();
//
//            // Pour chaque inscription, on calcule le score et on le met à jour
//            for (InscriptionEntity inscription : listeInscriptions)
//            {
//                for (ActionDTO action : listeActions)
//                {
//                    int score;
//                    ActionDTO actionEntity = verifyIfActionIsInList(actionsAAfficherScore, action.getIdAction());
//                    if (actionEntity == null)
//                    {
//                        List<IndicatorDTO> listeIndicateurs = indicateurService.findAllByFkAction(action.getIdAction());
//                        score = 0;
//                        for (IndicatorDTO indicateur : listeIndicateurs)
//                        {
//                            if (idIndicateursSelected.contains(String.valueOf(indicateur.getId())))
//                            {
//                                score += indicateur.getValueIfCheck();
//                                System.out.println("J'ai trouvé l'indicateur : "+indicateur.getId()+" dans la liste des indicateurs cochés");
//                            }
//                            else
//                            {
//                                score += indicateur.getValueIfUnCheck();
//                                System.out.println("L'id de l'indicateur : "+indicateur.getId()+" n'est pas dans la liste des indicateurs cochés");
//                            }
//                        }
//                        actionsAAfficherScore.put(action, score);
//                    }
//                    else
//                    {
//                        score = actionsAAfficherScore.get(actionEntity);
//                    }
//                    System.out.println("action : "+action.getWording());
//                    System.out.println("score : "+score);
//                    inscriptionActionService.updateScore(inscription.getId(), action.getIdAction(), score);
//                }
//            }
//            System.out.println("actionsAAfficherScore : "+actionsAAfficherScore);
//            // Faire afficher le score
//            request.setAttribute("actionsAAfficherScore", actionsAAfficherScore);
//            System.out.println("Taille de la liste des actions : "+actionsAAfficherScore.size());
//            request.setAttribute("idJeu", idJeu);
//            request.setAttribute("idApprenant", idApprenant);
//            destinationPage = "vues/jeu/afficherResultats";
//        }
//        catch (MonException e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "vues/Erreur";
//        }
//        return new ModelAndView(destinationPage);
//
//
//
//    }


//    @RequestMapping(value = "listeJeuxRealise.htm")
//    public ModelAndView getJeuxRealise(HttpServletRequest request, HttpServletResponse response) throws Exception
//    {
//        System.out.println("arrivée liste jeu");
//        String destinationPage = "";
//        int idUser = Integer.parseInt(request.getParameter("idApprenant"));
//        System.out.println("Trouver jeu : " + jeuService.getAllJeu());
//
//        List<UtilisateurJeuEntity> listeJeuxPourUtilisateur = null;
//        UtilisateurEntity Utilisateurs = null;
//        List<JeuEntity> listeJeux;
//
//        try {
//            System.out.println("idUser: " + idUser);
//            listeJeuxPourUtilisateur = unUtilisateurJeuService.getInscriptionByUsers(idUser);
//
//            if (listeJeuxPourUtilisateur.size()!=0 || listeJeuxPourUtilisateur != null)
//            {
//                System.out.println("liste jeux : " + listeJeuxPourUtilisateur.get(0));
//
//                // Récupérer les informations des jeux associés
//                listeJeux = new ArrayList<>();
//                for (UtilisateurJeuEntity jeu : listeJeuxPourUtilisateur) {
//                    //On récupère le jeu grâce à son id
//                    JeuEntity jeuEntity = jeuService.getJeubyID(jeu.getFkJeu());
//                    //On récupère les actions lié au jeu
//                    listeJeux.add(jeuEntity);
//                    Utilisateurs = ServiceUtilisateur.getUserByFkKey(idUser);
//                }
//                request.setAttribute("Utilisateur", Utilisateurs);
//                request.setAttribute("controllerType", "getJeuxRealise");
//                request.setAttribute("listeJeux", listeJeux);
//                request.setAttribute("listeJeuxRealise", listeJeuxPourUtilisateur);
//                destinationPage = "vues/jeu/listeJeuxRealise";
//            }
//            else
//            {
//                request.setAttribute("erreurType", "afficherJeuApprenant");
//                request.setAttribute("nom_prenom", Utilisateurs.getForename()+" "+Utilisateurs.getSurname());
//                destinationPage = "vues/aucuneDonneesVue";
//            }
//
//        }
//        catch (IndexOutOfBoundsException e)
//        {
//            request.setAttribute("erreurType", "afficherJeuApprenant");
//            destinationPage = "vues/aucuneDonneesVue";
//        }
//
//        catch (MonException e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//        return new ModelAndView(destinationPage);
//    }
}
//
//
//
//
//
//
