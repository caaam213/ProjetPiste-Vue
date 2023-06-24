package com.epul.permispiste.controller;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.dto.ActionDTO;
import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@RequestMapping("/action")
@RestController
@CrossOrigin
public class ControllerAction {

    @Autowired
    private ActionService actionService;

    private HttpSession session;

    @GetMapping("/getAll/")
    public List<ActionDTO> getAllAction(HttpServletRequest request) {
        List<ActionDTO> actions = null;
        try
        {
            actions = actionService.getAllAction();
        }
        catch (MonException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return actions;
    }

    @GetMapping("/addForm")
    public ResponseEntity<?> addForm(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("id") == null) {
                String message = "Vous n'êtes pas connecté !!";
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
            } else {
                return ResponseEntity.ok("vues/action/ajouterAction");
            }
        } catch (Exception e) {
            String errorMessage = "Une erreur s'est produite lors de l'ajout de l'action";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addForm(HttpServletRequest request, @RequestBody ActionEntity actionData) {
        try {
            HttpSession session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
//            } else {
            // TODO : Décommenter pour gérer la connexion
                actionService.addAction(actionData);
                return ResponseEntity.ok("Action ajoutée avec succès");
//            }
        } catch (Exception e) {
            String errorMessage = "Une erreur s'est produite lors de l'ajout de l'action";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
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
//            }
//            else
//            {
//                ActionEntity action = actionService.getAction(id);
//                request.setAttribute("action", action);
//                destinationPage = "/vues/action/editAction";
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
//                int scoreMin = Integer.parseInt(request.getParameter("scoreMin"));
//                ActionEntity actionEntity = new ActionEntity();
//                actionEntity.setId(id);
//                actionEntity.setWording(libelle);
//                actionEntity.setScoreMinimum(scoreMin);
//                actionService.editAction(actionEntity);
//                request.setAttribute("actions", actionService.getAllAction());
//                destinationPage = "/vues/action/afficherActions";
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
//            }
//            else
//            {
//                actionService.delete(id);
//                List<ActionEntity> actionEntityList = actionService.getAllAction();
//                if (actionEntityList.size() == 0)
//                {
//                    request.setAttribute("erreurType", "Action");
//                    destinationPage = "/vues/aucuneDonneesVue";
//                }
//                else
//                {
//                    request.setAttribute("actions", actionEntityList);
//                    destinationPage = "/vues/action/afficherActions";
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

}

