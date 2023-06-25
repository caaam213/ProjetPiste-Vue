package com.epul.permispiste.controller;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.domains.UtilisateurEntity;
import com.epul.permispiste.dto.ActionDTO;
import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.service.ApprenantService;
import com.epul.permispiste.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/apprenant")
@RestController
@CrossOrigin
public class ControllerApprenant {

    @Autowired
    private ApprenantService apprenantService;
    @Autowired
    private UtilisateurService utilisateurService;

    private HttpSession session;

    @GetMapping(value = "/getAll")
    public List<ApprenantEntity> getAllApprenant(HttpServletRequest request){

        List<ApprenantEntity> apprenants = null;
        try
        {
            apprenants = apprenantService.getAll();
        }
        catch (MonException e) {
            ResponseEntity.notFound().build();
        }
        return apprenants;
    }

//    @RequestMapping("/addForm")
//    public ModelAndView addForm(HttpServletRequest request) {
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
//                destinationPage = "/vues/apprenant/ajouterApprenant";
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
//
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
//                ApprenantEntity apprenantEntity = apprenantService.getApprenantById(id);
//                request.setAttribute("apprenant", apprenantEntity);
//                destinationPage = "/vues/apprenant/editApprenants";
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
//                ApprenantEntity apprenantEntity = new ApprenantEntity();
//                apprenantEntity.setId(id);
//                apprenantService.editApprenant(apprenantEntity);
//                request.setAttribute("apprenants", apprenantService.getAll());
//                destinationPage = "/vues/apprenant/afficherApprenants";
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
//                apprenantService.delete(id);
//                request.setAttribute("apprenants", apprenantService.getAll());
//                destinationPage = "/vues/apprenant/afficherApprenants";
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
