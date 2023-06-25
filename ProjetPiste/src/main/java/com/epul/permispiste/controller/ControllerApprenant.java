package com.epul.permispiste.controller;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.dto.ApprenantDTO;
import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RequestMapping("/apprenant")
@RestController
@CrossOrigin
public class ControllerApprenant {

    @Autowired
    private ApprenantService apprenantService;

    private HttpSession session;

    @GetMapping("/getAll/")
    public List<ApprenantDTO> getAllAction(HttpServletRequest request) {
        List<ApprenantDTO> apprenants = null;
        try
        {
            apprenants = apprenantService.getAll();
        }
        catch (MonException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return apprenants;
    }

    @GetMapping("/addForm")
    public ResponseEntity<?> addForm(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            if (session.getAttribute("id") == null) {
                String message = "Vous n'êtes pas connecté !!";
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
            } else {
                return ResponseEntity.ok("vues/apprenant/ajouterApprenant");
            }
        } catch (Exception e) {
            String errorMessage = "Une erreur s'est produite lors de l'ajout de l'apprenant";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addForm(HttpServletRequest request, @RequestBody ApprenantEntity apprenantData) {
        try {
            HttpSession session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
//            } else {
            // TODO : Décommenter pour gérer la connexion
            apprenantService.addApprenant(apprenantData);
            return ResponseEntity.ok("Action ajoutée avec succès");
//            }
        } catch (Exception e) {
            String errorMessage = "Une erreur s'est produite lors de l'ajout de l'action";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}

//package com.epul.permispiste.controller;
//import com.epul.permispiste.domains.ApprenantEntity;
//import com.epul.permispiste.domains.UtilisateurEntity;
//import com.epul.permispiste.service.ApprenantService;
//import com.epul.permispiste.service.UtilisateurService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@RequestMapping("/apprenant")
//@RestController
//@CrossOrigin
//public class ControllerApprenant {
//
//    @Autowired
//    private ApprenantService apprenantService;
//    @Autowired
//    private UtilisateurService utilisateurService;
//
//    private HttpSession session;
//
//    @RequestMapping(value = "/index")
//    public ModelAndView index(HttpServletRequest request) throws Exception {
//        String destinationPage;
//        try {
//            request.setAttribute("apprenant", apprenantService.getAll());
//            destinationPage = "/vues/apprenant/afficherApprenants";
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//        return new ModelAndView(destinationPage);
//    }
//
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
//}
