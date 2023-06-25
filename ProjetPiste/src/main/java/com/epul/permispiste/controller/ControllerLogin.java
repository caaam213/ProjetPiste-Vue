package com.epul.permispiste.controller;

import com.epul.permispiste.domains.UtilisateurEntity;
import com.epul.permispiste.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class ControllerLogin {

    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody UtilisateurEntity utilisateur, HttpServletRequest request) {
        try {
            UtilisateurEntity authenticatedUser = authentificationService.authentification(utilisateur);
            if (authenticatedUser != null) {
                HttpSession session = request.getSession();
                session.setAttribute("id", authenticatedUser.getNumUtil());
                session.setAttribute("utilisateur", authenticatedUser);
                return ResponseEntity.ok(authenticatedUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite");
        }
    }
}
