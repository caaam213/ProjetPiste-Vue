package com.epul.permispiste.controller;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.domains.UtilisateurEntity;
import com.epul.permispiste.dto.UtilisateurDTO;
import com.epul.permispiste.mesExceptions.MonException;
import com.epul.permispiste.service.UtilisateurService;
import com.epul.permispiste.utilitaires.MonMotPassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/getAllApprennants")
    public List<UtilisateurDTO> getAllApprenant(HttpServletRequest request){

        List<UtilisateurDTO> apprenants = null;
        try
        {
            apprenants = utilisateurService.getAllApprenant();
        }
        catch (MonException e) {
            ResponseEntity.notFound().build();
        }
        return apprenants;
    }

    @PostMapping("/addApprenant")
    public ResponseEntity<?> addApprenant(HttpServletRequest request, @RequestBody UtilisateurEntity utilisateurData) {
        try {
            utilisateurData.setNomUtil(utilisateurData.getSurname());
            utilisateurData.setRole("learner");
            byte[] salt = MonMotPassHash.GenerateSalt();
            utilisateurData.setSalt(MonMotPassHash.bytesToString(salt));
            utilisateurData.setMotPasse(MonMotPassHash.bytesToString(MonMotPassHash.generatePasswordHash(MonMotPassHash.converttoCharArray(utilisateurData.getMotPasse()), salt))
            );
            utilisateurService.addUtilisateur(utilisateurData);
            return ResponseEntity.ok("Apprenant ajoutée avec succès");

        } catch (Exception e) {
            String errorMessage = "Une erreur s'est produite lors de l'ajout de l'apprenant";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping("/editApprenant")
    public ResponseEntity<?> editApprenant(HttpServletRequest request, @RequestBody UtilisateurEntity utilisateurData) {
        try {
            utilisateurData.setNomUtil(utilisateurData.getSurname());
            utilisateurService.editApprenant(utilisateurData);
            return ResponseEntity.ok("Apprenant modifié avec succès");

        } catch (Exception e) {
            String errorMessage = "Une erreur s'est produite lors de la modification de l'apprenant";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @GetMapping(value = "/delete")
    public void delete(HttpServletRequest request,@RequestParam("id") int id){
        try
        {
            utilisateurService.delete(id);
        }
        catch (MonException e) {
            ResponseEntity.notFound().build();
        }
    }


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
