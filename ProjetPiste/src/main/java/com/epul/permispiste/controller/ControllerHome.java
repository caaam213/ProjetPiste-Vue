//package com.epul.permispiste.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//
//@Controller
//public class ControllerHome {
//    private HttpSession session;
//
//    @GetMapping("/")
//    public ModelAndView home(HttpServletRequest request) {
//        String destinationPage = "index";
//        session = request.getSession();
//        if (session.getAttribute("id") == null) {
//            destinationPage = "vues/connection/login";
//        }
//        return new ModelAndView(destinationPage);
//    }
//}
