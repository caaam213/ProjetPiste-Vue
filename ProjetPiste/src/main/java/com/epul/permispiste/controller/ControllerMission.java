package com.epul.permispiste.controller;
import com.epul.permispiste.domains.MissionEntity;
import com.epul.permispiste.dto.ActionDTO;
import com.epul.permispiste.dto.MissionDTO;
import com.epul.permispiste.dto.UtilisateurDTO;
import com.epul.permispiste.service.*;
import com.epul.permispiste.domains.*;
import com.epul.permispiste.mesExceptions.MonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import java.util.List;


@RequestMapping("/mission")
@RestController
@CrossOrigin
public class ControllerMission {

    @Autowired
    private MissionService missionService;

    @Autowired
    private ActionService actionService;
    @Autowired
    private ActionMissionService actionMissionService;

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private UtilisateurService utilisateurService;



    private HttpSession session;

    @GetMapping(value = "/choixApprenant")
    public ResponseEntity<?> selectionnerApprenant() {
        try {
            List<UtilisateurDTO> listeApprenants = utilisateurService.getAllApprenant();
            return ResponseEntity.ok(listeApprenants);
        } catch (MonException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @GetMapping("/listeMissionApp")
    public ResponseEntity<List<MissionDTO>> getlisteMissionApp(@RequestParam("idApprenant") int idApprenant) {
        try {
            List<MissionDTO> missions = missionService.findAll();
            List<MissionDTO> missionsNonApprentie = new ArrayList<>();
            List<MissionDTO> missionsApprentie = new ArrayList<>();
            List<InscriptionEntity> listeInscriptionsPourUtilisateur = inscriptionService.getInscriptionsByIdUsers(idApprenant);

            for (InscriptionEntity inscription : listeInscriptionsPourUtilisateur) {
                for (MissionDTO mission : missions) {
                    if (mission.getId() == inscription.getFkMission()) {
                        missionsApprentie.add(mission);
                    }
                }
            }

            for (MissionDTO mission : missions) {
                if (!missionsApprentie.contains(mission)) {
                    missionsNonApprentie.add(mission);
                }
            }

            List<MissionDTO> combinedMissions = new ArrayList<>();
            combinedMissions.addAll(missionsNonApprentie);

            return ResponseEntity.ok(combinedMissions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getAll/")
    public List<MissionDTO> getAll(HttpServletRequest request) {
        List<MissionDTO> missions = null;
        try {
            session = request.getSession();
            missions = missionService.getAllMissions();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return missions;
    }

    //TODO : Tester les deux fonctions sur postman
    @RequestMapping("/addForm")
    public ResponseEntity<?> addForm(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("id") == null) {
                String message = "Vous n'êtes pas connecté !!";
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
            } else {
                return ResponseEntity.ok("vues/mission/ajouterMission");
            }
        } catch (Exception e) {
            String errorMessage = "Une erreur s'est produite lors de l'ajout de l'action";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addForm(HttpServletRequest request, @RequestBody MissionEntity MissionData) {
        try {
            HttpSession session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
//            } else {
            // TODO : Décommenter pour gérer la connexion
            missionService.addMission(MissionData);
            return ResponseEntity.ok("Mission ajoutée avec succès");
//            }
        } catch (Exception e) {
            String errorMessage = "Une erreur s'est produite lors de l'ajout de l'action";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    //TODO : Adapter ces fonctions en API (toutes les fonctions après ce TODO )
    @RequestMapping(method = RequestMethod.GET, value ="/editForm/{id}")
    public ModelAndView edit(HttpServletRequest request, @PathVariable(value = "id") int id ) {
        String destinationPage;
        try {
            session = request.getSession();
            if (session.getAttribute("id") == null) {
                String message = "Vous n'êtes pas connecté !!";
                request.setAttribute("message", message);
                destinationPage = "vues/connection/login";
            } else {
                MissionEntity mission = missionService.getMissionById(id);
                request.setAttribute("mission", mission);
                destinationPage = "/vues/mission/editMission";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ModelAndView(destinationPage);
    }

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

    @RequestMapping(method = RequestMethod.POST, value ="/edit")
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response ) {
        String destinationPage;
        try {
            session = request.getSession();
            if (session.getAttribute("id") == null) {
                String message = "Vous n'êtes pas connecté !!";
                request.setAttribute("message", message);
                destinationPage = "vues/connection/login";
            }
            else
            {
                int id = Integer.parseInt(request.getParameter("id"));
                String libelle = request.getParameter("libelle");
                MissionEntity missionEntity = new MissionEntity();
                missionEntity.setId(id);
                missionEntity.setWording(libelle);
                missionService.editMission(missionEntity);
                request.setAttribute("missions", missionService.getAll());
                destinationPage = "/vues/mission/afficherMissions";
            }
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        // Redirection vers la page jsp appropriee
        return new ModelAndView(destinationPage);
    }

    //TODO : Adapter ces fonctions en API
    @RequestMapping(method = RequestMethod.GET, value ="/delete/{id}")
    public ModelAndView delete(HttpServletRequest request, @PathVariable(value = "id") int id ) {
        String destinationPage;
        try {
            session = request.getSession();
            if (session.getAttribute("id") == null) {
                String message = "Vous n'êtes pas connecté !!";
                request.setAttribute("message", message);
                destinationPage = "vues/connection/login";
            } else {
                missionService.delete(id);
                List<MissionEntity> missions = missionService.getAll();
                if (missions.size() == 0)
                {
                    request.setAttribute("erreurType", "Mission");
                    destinationPage = "/vues/aucuneDonneesVue";
                }
                else
                {
                    request.setAttribute("missions", missions);
                    destinationPage = "/vues/mission/afficherMissions";
                }
            }
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = "/vues/Erreur";
        }

        // Redirection vers la page jsp appropriee
        return new ModelAndView(destinationPage);
    }



    @PostMapping("/ajouterApprenant")
    public ResponseEntity<String> ajouterApprenant(@RequestParam("idApprenant") int idApprenant,
                                                   @RequestParam("idMission") int idMission) {
        try {
            InscriptionEntity inscriptionEntity = inscriptionService.addNewInscription(idApprenant, idMission);
            inscriptionService.addNewInscriptionAction(idApprenant, idMission, inscriptionEntity.getId());

            return ResponseEntity.ok("ok");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

//    @PostMapping("/ajouterMissionPourInscription")
//    public ResponseEntity<String> ajouterMissionPourInscription(@RequestParam int idApprenant, @RequestParam int idMission,
//                                                                @RequestParam int inscriptionId) {
//        try {
//            // Perform necessary operations
//            inscriptionService.addNewInscriptionAction(idApprenant, idMission, inscriptionId);
//
//            // Create the redirect URL
//            String redirectUrl = "/";
//
//            return ResponseEntity.ok(redirectUrl);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }

}





