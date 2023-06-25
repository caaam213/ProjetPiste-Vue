package com.epul.permispiste.controller;

import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.domains.UtilisateurEntity;
import com.epul.permispiste.dto.UtilisateurDTO;
import com.epul.permispiste.service.UtilisateurService;
import com.epul.permispiste.utilitaires.MonMotPassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/utilisateur")
@RestController
@CrossOrigin
public class ControllerUtilisateur {

    @Autowired
    private UtilisateurService utilisateurService;

    private HttpSession session;

    @GetMapping("/getUtilisateur")
    public UtilisateurDTO getUtilisateur(@RequestParam("id") int id) {
        UtilisateurEntity utilisateur = null;
        UtilisateurDTO utilisateurDTO = new UtilisateurDTO();
        try {
            utilisateur = utilisateurService.getUtilisateurById(id);
            utilisateurDTO.setIdUtilisateur(utilisateur.getNumUtil());
            utilisateurDTO.setEmail(utilisateur.getEmail());
            utilisateurDTO.setForename(utilisateur.getForename());
            utilisateurDTO.setSurname(utilisateur.getSurname());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateurDTO;
    }
//
//    @RequestMapping(value = "/indexApprenant")
//    public ModelAndView indexApprenant(HttpServletRequest request) throws Exception {
//        String destinationPage;
//        try {
//            List<UtilisateurEntity> listeApprenants = utilisateurService.getAllApprenant();
//            if (listeApprenants.size() == 0)
//            {
//                // S'il n'y a pas de données, on change la vue
//                request.setAttribute("erreurType", "Apprenant");
//                destinationPage = "/vues/aucuneDonneesVue";
//            }
//            else
//            {
//                request.setAttribute("apprenants", utilisateurService.getAllApprenant());
//                destinationPage = "/vues/apprenant/afficherApprenants";
//            }
//
//        } catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//        return new ModelAndView(destinationPage);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/addApprenant")
//    public ModelAndView addApprennant(HttpServletRequest request, HttpServletResponse response) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            } else {
//                UtilisateurEntity utilisateur = new UtilisateurEntity();
//                String nom = request.getParameter("nom");
//                String prenom = request.getParameter("prenom");
//                String password = request.getParameter("password");
//                utilisateur.setNomUtil(nom);
//                utilisateur.setForename(nom);
//                utilisateur.setSurname(prenom);
//                utilisateur.setRole("learner");
//                byte[] salt = MonMotPassHash.GenerateSalt();
//                utilisateur.setSalt(MonMotPassHash.bytesToString(salt));
//                utilisateur.setMotPasse(MonMotPassHash.bytesToString(MonMotPassHash.generatePasswordHash(MonMotPassHash.converttoCharArray(password), salt))
//                );
//                utilisateurService.addUtilisateur(utilisateur);
//                request.setAttribute("apprenants", utilisateurService.getAllApprenant());
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
//    @RequestMapping("/addForm")
//    public ModelAndView addForm(HttpServletRequest request) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            } else {
//                destinationPage = "/vues/utilisateur/ajouterApprenant";
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
//    @RequestMapping(method = RequestMethod.POST, value = "/add")
//    public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            } else {
//                UtilisateurEntity utilisateur = (UtilisateurEntity) session.getAttribute("utilisateur");
//                if (utilisateur.getRole().equals("admin")) {
//                    UtilisateurEntity utiisateurEntity = new UtilisateurEntity();
//                    String nomUti = request.getParameter("nomUtil");
//                    String surname = request.getParameter("surname");
//                    String forename = request.getParameter("forename");
//                    String role = request.getParameter("role");
//                    String email = request.getParameter("email");
//                    String motPasse = request.getParameter("motPasse");
//                    String salt = request.getParameter("salt");
//                    utiisateurEntity.setNomUtil(nomUti);
//                    utiisateurEntity.setSurname(surname);
//                    utiisateurEntity.setForename(forename);
//                    utiisateurEntity.setRole(role);
//                    utiisateurEntity.setEmail(email);
//                    utiisateurEntity.setRole(motPasse);
//                    utiisateurEntity.setEmail(salt);
//                    utilisateurService.addUtilisateur(utiisateurEntity);
//                    request.setAttribute("utilisateurs", utilisateurService.getAll());
//                    destinationPage = "/vues/utilisateur/afficherUtilisateurs";
//                } else {
//                    destinationPage = "/vues/Erreur";
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
//    @RequestMapping(method = RequestMethod.GET, value = "/editForm/{id}")
//    public ModelAndView editForm(HttpServletRequest request, @PathVariable(value = "id") int id) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            } else {
//                UtilisateurEntity utilisateur = (UtilisateurEntity) session.getAttribute("utilisateur");
//                if (utilisateur.getRole().equals("admin")) {
//                    UtilisateurEntity utiisateurEntity = utilisateurService.getUtilisateurById(id);
//                    request.setAttribute("apprenant", utiisateurEntity);
//                    destinationPage = "/vues/apprenant/editApprenants";
//                } else {
//                    destinationPage = "/vues/Erreur";
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
//    @RequestMapping(method = RequestMethod.POST, value = "/editApprenant")
//    public ModelAndView editApprenant(HttpServletRequest request, HttpServletResponse response) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            } else {
//                UtilisateurEntity utilisateur = (UtilisateurEntity) session.getAttribute("utilisateur");
//                if (utilisateur.getRole().equals("admin")) {
//                    UtilisateurEntity utiisateurEntity = new UtilisateurEntity();
//                    int id = Integer.valueOf(request.getParameter("id")) ;
//                    String nom = request.getParameter("nom");
//                    String prenom = request.getParameter("prenom");
//                    utiisateurEntity.setNumUtil(id);
//                    utiisateurEntity.setSurname(nom);
//                    utiisateurEntity.setForename(prenom);
//                    utilisateurService.editApprenant(utiisateurEntity);
//                    request.setAttribute("apprenants", utilisateurService.getAllApprenant());
//                    destinationPage = "/vues/apprenant/afficherApprenants";
//                } else {
//                    destinationPage = "/vues/Erreur";
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
//    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
//    public ModelAndView delete(HttpServletRequest request, @PathVariable(value = "id") int id) {
//        String destinationPage;
//        try {
//            session = request.getSession();
//            if (session.getAttribute("id") == null) {
//                String message = "Vous n'êtes pas connecté !!";
//                request.setAttribute("message", message);
//                destinationPage = "vues/connection/login";
//            } else {
//                UtilisateurEntity utilisateur = (UtilisateurEntity) session.getAttribute("utilisateur");
//                if (utilisateur.getRole().equals("admin")) {
//                    utilisateurService.delete(id);
//                    List<UtilisateurEntity> utilisateurEntities = utilisateurService.getAllApprenant();
//                    if (utilisateurEntities.size() == 0)
//                    {
//                        request.setAttribute("erreurType", "Apprenant");
//                        destinationPage = "/vues/aucuneDonneesVue";
//                    }
//                    else
//                    {
//                        request.setAttribute("apprenants", utilisateurEntities);
//                        destinationPage = "/vues/apprenant/afficherApprenants";
//
//                    }
//                } else {
//                    destinationPage = "/vues/Erreur";
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
