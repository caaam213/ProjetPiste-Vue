//package com.epul.permispiste.controller;
//import com.epul.permispiste.domains.MissionEntity;
//import com.epul.permispiste.service.*;
//import com.epul.permispiste.domains.*;
//import com.epul.permispiste.mesExceptions.MonException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import javax.servlet.RequestDispatcher;
//import java.util.List;
//
//
//@RequestMapping("/mission")
//@RestController
//@CrossOrigin
//public class ControllerMission {
//
//    @Autowired
//    private MissionService missionService;
//
//    @Autowired
//    private ActionService actionService;
//    @Autowired
//    private ActionMissionService actionMissionService;
//
//    @Autowired
//    private InscriptionService inscriptionService;
//
//    @Autowired
//    private UtilisateurService utilisateurService;
//
//    private HttpSession session;
//
//    @RequestMapping("/index")
//    public ModelAndView getAll(HttpServletRequest request) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            }
//            else
//            {
//                List<MissionEntity> missions = missionService.getAll();
//                if (missions.size() == 0)
//                {
//                    request.setAttribute("erreurType", "Mission");
//                    destinationPage = "/vues/aucuneDonneesVue";
//                }
//                else
//                {
//                    request.setAttribute("missions", missions);
//                    destinationPage = "/vues/mission/afficherMissions";
//                }
//            }
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//
//        // Redirection vers la page jsp appropriee
//        return new ModelAndView(destinationPage);
//    }
//
//    @RequestMapping("/addForm")
//    public ModelAndView addForm(HttpServletRequest request) {
//        String destinationPage;
//
//
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            }
//            else
//            {
//                request.setAttribute("actions", actionService.getAllAction());
//                destinationPage = "/vues/mission/ajouterMission";
//            }
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//
//        // Redirection vers la page jsp appropriee
//        return new ModelAndView(destinationPage);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value ="/add")
//    public ModelAndView add(HttpServletRequest request, HttpServletResponse response ) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            }
//            else
//            {
//                String libelle = request.getParameter("libelle");
//                MissionEntity missionEntity = new MissionEntity();
//
//                missionEntity.setInscriptionsById(new ArrayList<>());
//                missionEntity.setWording(libelle);
//
//
//                MissionEntity mission = missionService.addMission(missionEntity);
//
//
//                /*
//                String[] actions = request.getParameterValues("actions");
//                if(actions!=null && actions.length>0)
//                    for(String idAction : actions){
//                        ActionMissionEntity actionMissionEntity = new ActionMissionEntity();
//                        //actionMissionEntity.setFkMission(mission.getId());
//                        //actionMissionEntity.setActionByFkAction(actionService.getAction(Integer.parseInt(idAction)));
//                        //actionMissionEntity.setMissionByFkMission(null);
//                        actionMissionService.addActionMission(actionMissionEntity);
//                    }
//                */
//
//
//
//                request.setAttribute("missions", missionService.getAll());
//                destinationPage = "/vues/mission/afficherMissions";
//            }
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//
//        // Redirection vers la page jsp appropriee
//        return new ModelAndView(destinationPage);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value ="/editForm/{id}")
//    public ModelAndView edit(HttpServletRequest request, @PathVariable(value = "id") int id ) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            } else {
//                MissionEntity mission = missionService.getMissionById(id);
//                request.setAttribute("mission", mission);
//                destinationPage = "/vues/mission/editMission";
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return new ModelAndView(destinationPage);
//    }
//
//    @GetMapping(value= "choixApprenant")
//    public ModelAndView selectionnerApprenant(HttpServletRequest request, HttpServletResponse response) throws Exception
//    {
//        String destinationPage;
//        try {
//            List<UtilisateurEntity> listeApprenants = utilisateurService.getAllApprenant();
//            System.out.println(listeApprenants);
//            request.setAttribute("listeApprenants", listeApprenants);
//            destinationPage = "vues/mission/indexMission";
//        } catch (MonException e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//
//        }
//        return new ModelAndView(destinationPage);
//    }
//
//    @GetMapping(value = "listeMissionApp.htm")
//    public ModelAndView getlisteMissionApp(HttpServletRequest request) throws Exception {
//        String destinationPage;
//        List<MissionEntity> missions = null;
//        List<MissionEntity> missionsNonApprentie = new ArrayList<>();
//        List<MissionEntity> missionsApprentie = new ArrayList<>();
//        List<InscriptionEntity> listeInscriptionsPourUtilisateur = null;
//
//        //Récupération information utilisateur
//        int idApprenant = Integer.parseInt(request.getParameter("idApprenant"));
//
//
//        try {
//            // On récupère toutes les inscriptions de l'apprenant
//            listeInscriptionsPourUtilisateur = inscriptionService.getInscriptionsByIdUsers(idApprenant);
//            missions = missionService.findAll();
//            //On les ajoutee dans
//            for (InscriptionEntity inscription : listeInscriptionsPourUtilisateur) {
//                for (MissionEntity mission : missions) {
//                    if (mission.getId() == inscription.getFkMission()) {
//                        missionsApprentie.add(mission);
//                    }
//                }
//            }
//
//            // On récupère toutes les missionsNon apprise
//            for (MissionEntity mission : missions) {
//                if (!missionsApprentie.contains(mission)) {
//                    missionsNonApprentie.add(mission);
//                }
//            }
//
//
//            System.out.println("Taille liste non apprise" + missionsNonApprentie.size());
//            System.out.println("Taille liste Apprise" + missionsApprentie.size());
//            request.setAttribute("missionsApp", missionsApprentie);
//            request.setAttribute("missionsNonApp", missionsNonApprentie);
//            request.setAttribute("idApprenant", idApprenant);
//            destinationPage = "vues/mission/listMissionApp";
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//
//        // Redirection vers la page jsp appropriee
//        return new ModelAndView(destinationPage);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value ="/edit")
//    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response ) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            }
//            else
//            {
//                int id = Integer.parseInt(request.getParameter("id"));
//                String libelle = request.getParameter("libelle");
//                MissionEntity missionEntity = new MissionEntity();
//                missionEntity.setId(id);
//                missionEntity.setWording(libelle);
//                missionService.editMission(missionEntity);
//                request.setAttribute("missions", missionService.getAll());
//                destinationPage = "/vues/mission/afficherMissions";
//            }
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//
//        // Redirection vers la page jsp appropriee
//        return new ModelAndView(destinationPage);
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value ="/delete/{id}")
//    public ModelAndView delete(HttpServletRequest request, @PathVariable(value = "id") int id ) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            } else {
//                missionService.delete(id);
//                List<MissionEntity> missions = missionService.getAll();
//                if (missions.size() == 0)
//                {
//                    request.setAttribute("erreurType", "Mission");
//                    destinationPage = "/vues/aucuneDonneesVue";
//                }
//                else
//                {
//                    request.setAttribute("missions", missions);
//                    destinationPage = "/vues/mission/afficherMissions";
//                }
//            }
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//
//        // Redirection vers la page jsp appropriee
//        return new ModelAndView(destinationPage);
//    }
//
//        @RequestMapping(value = "ajouterApprenant.htm")
//        public void ajouterApp (HttpServletRequest request, HttpServletResponse response) throws Exception {
//            try {
//                System.out.println("Début controlleur");
//                //Récupération Information utilisateur
//                int idApprenant = Integer.parseInt(request.getParameter("idApprenant"));
//                System.out.println("idApprenant" + idApprenant);
//
//                //Récupération Information mission
//                int idMission = Integer.parseInt(request.getParameter("idMission"));
//                System.out.println("idMission" + idMission);
//
//                InscriptionEntity inscriptionEntity = inscriptionService.addNewInscription(idApprenant, idMission);
//                System.out.println("Appelle controlleur avant redirection");
//                String redirectUrl = "/mission/ajouterMissionPourInscription.htm?inscriptionId=" + inscriptionEntity.getId() +
//                        "&idApprenant=" + idApprenant + "&idMission=" + idMission;
//                response.sendRedirect(redirectUrl);
//
//            } catch (Exception e) {
//                request.setAttribute("MesErreurs", e.getMessage());
//                String destinationPage = "vues/Erreur";
//                RequestDispatcher dispatcher = request.getRequestDispatcher(destinationPage);
//                dispatcher.forward(request, response);
//            }
//        }
//
//        @RequestMapping(value = "ajouterMissionPourInscription.htm")
//        public void ajouterNewApp (HttpServletRequest request, HttpServletResponse response) throws Exception {
//            try {
//                System.out.println("Début controlleur");
//                //Récupération Information utilisateur
//                int idApprenant = Integer.parseInt(request.getParameter("idApprenant"));
//                System.out.println("idApprenant" + idApprenant);
//
//                //Récupération Information mission
//                int idMission = Integer.parseInt(request.getParameter("idMission"));
//                System.out.println("idMission" + idMission);
//
//                // Récupération id Inscription
//                int idInscription = Integer.parseInt(request.getParameter("inscriptionId"));
//                System.out.println("Inscription id" + idInscription);
//
//                inscriptionService.addNewInscriptionAction(idApprenant, idMission, idInscription);
//                System.out.println("Appelle controlleur avant redirection");
//                String redirectUrl = "/";
//                response.sendRedirect(redirectUrl);
//
//            } catch (Exception e) {
//                request.setAttribute("MesErreurs", e.getMessage());
//                String destinationPage = "vues/Erreur";
//                RequestDispatcher dispatcher = request.getRequestDispatcher(destinationPage);
//                dispatcher.forward(request, response);
//            }
//        }
//
//    }
//
//
//
//
//
