package web.controller;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping(value = "/users/view", method = {RequestMethod.GET})
    @ResponseBody
    public String users_view(Model model, HttpServletRequest request) {

//        KeycloakSecurityContext keycloak = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
//        model.addAttribute("token", keycloak.getTokenString());
        return "keycloak";
    }

//    @RequestMapping(value = "/admin/view", method = {RequestMethod.GET})
//    public String admin_view(Model model, HttpServletRequest request) {
//
//        KeycloakSecurityContext keycloak = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
//        model.addAttribute("token", keycloak.getTokenString());
//        return "admin/view";
//    }
}
