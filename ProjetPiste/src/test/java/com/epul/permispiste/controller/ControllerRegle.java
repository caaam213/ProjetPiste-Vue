//package com.epul.permispiste.controller;
//
//
//import com.epul.permispiste.domains.RegleEntity;
//import com.epul.permispiste.service.RegleService;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.RedirectView;
//
//import javax.servlet.http.HttpServletRequest;
//
//@RequestMapping("/regle")
//@RestController
//@CrossOrigin
//public class ControllerRegle {
//    @GetMapping(value = "index_regle.htm")
//    public ModelAndView index(HttpServletRequest request) throws Exception {
//        String destinationPage;
//        try {
//            request.setAttribute("regles", new RegleService().getAll());
//            destinationPage = "regle/index";
//        } catch (Exception e) {
//            request.setAttribute("errors", e.getMessage());
//            destinationPage = "layouts/error";
//        }
//        return new ModelAndView(destinationPage);
//    }
//
//    @GetMapping(value = "create_regle.htm")
//    public ModelAndView create(HttpServletRequest request) throws Exception {
//        String destinationPage;
//        try {
//            request.setAttribute("regles", new RegleService().getAll());
//            destinationPage = "regle/create";
//        } catch (Exception e) {
//            request.setAttribute("errors", e.getMessage());
//            destinationPage = "layouts/error";
//        }
//
//        return new ModelAndView(destinationPage);
//    }
//
//    @PostMapping(value = "store_regle.htm")
//    public ModelAndView store(HttpServletRequest request) throws Exception {
//        String destinationPage;
//        try {
//
//            RegleEntity regle = new RegleEntity();
//            regle.setLibRegle(request.getParameter("libregle"));
//            regle.setScoreMin(Integer.parseInt(request.getParameter("scoremin")));
//            new RegleService().insert(regle);
//            destinationPage = "redirect: index_regle.htm";
//
//        } catch (Exception e) {
//            request.setAttribute("errors", e.getMessage());
//            destinationPage = "layouts/error";
//        }
//
//        return new ModelAndView(destinationPage);
//    }
//
//    @PostMapping(value = "update_regle.htm")
//    public ModelAndView update(HttpServletRequest request) throws Exception {
//        String destinationPage = "";
//        try {
//            RegleService serviceRegle = new RegleService();
//            RegleEntity regle = serviceRegle.getRegleById(request.getParameter("id"));
//            regle.setLibRegle(request.getParameter("libregle"));
//            regle.setScoreMin(Integer.parseInt(request.getParameter("scoremin")));
//            serviceRegle.update(regle);
//
//            destinationPage = "redirect: index_regle.htm";
//        } catch (Exception e) {
//            request.setAttribute("errors", e.getMessage());
//            destinationPage = "layouts/error";
//        }
//
//        return new ModelAndView(destinationPage);
//    }
//
//    @GetMapping(value = "delete_regle.htm")
//    public RedirectView delete(HttpServletRequest request) throws Exception {
//        RegleService serviceRegle = new RegleService();
//        RegleEntity action = serviceRegle.getRegleById(request.getParameter("id"));
//        serviceRegle.delete(action);
//        RedirectView rv = new RedirectView();
//        rv.setContextRelative(true);
//        rv.setUrl("/index_regle.htm");
//        return rv;
//    }
//}