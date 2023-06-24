//package com.epul.permispiste.controller;
//
//import com.epul.permispiste.domains.UtilisateurEntity;
//import com.epul.permispiste.service.AuthentificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@RequestMapping("/login")
//@RestController
//@CrossOrigin
//public class ControllerLogin {
//    // on initialise
//    @Autowired
//    private AuthentificationService unAuthenService;
//
//    @RequestMapping("/deconnection")
//    public RedirectView deconnection(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        HttpSession session = request.getSession();
//        session.setAttribute("id", null);
//        return new RedirectView("/login");
//    }
//
//    @RequestMapping("")
//    public ModelAndView pageLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        return new ModelAndView("/vues/connection/login");
//    }
//
//    ///
//    //
//    //// Contrôle Login
//    ///
//    ////
//    @RequestMapping(method = RequestMethod.POST, value = "/getLogin")
//    public ModelAndView controleLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String destinationPage;
//        UtilisateurEntity unUtilisateur= new UtilisateurEntity();
//        HttpSession session;
//        try {
//            String login = request.getParameter("login");
//            String pwd = request.getParameter("password");
//            unUtilisateur.setNomUtil(login);
//            unUtilisateur.setMotPasse(pwd);
//            String message = "";
//
//            unUtilisateur = unAuthenService.authentification(unUtilisateur);
//            if (unUtilisateur != null) {
//                session = request.getSession();
//                session.setAttribute("id", unUtilisateur.getNumUtil());
//                session.setAttribute("utilisateur", unUtilisateur);
//                destinationPage = "/index";
//            } else {
//                message = "mot de passe erroné";
//                request.setAttribute("message", message);
//                destinationPage = "/vues/connection/login";
//            }
//        }catch (Exception e) {
//            request.setAttribute("MesErreurs", e.getMessage());
//            destinationPage = "/vues/Erreur";
//        }
//
//        return new ModelAndView(destinationPage);
//    }
//
//}