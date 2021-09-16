package cn.metaq.web;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping(value = "/customer/view", method = {RequestMethod.GET})
    public String customerView(Model model, HttpServletRequest request) {
        KeycloakSecurityContext keycloak = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
        model.addAttribute("authz", keycloak.getAuthorizationContext());
        return "customer/view";
    }

    @RequestMapping(value = "/customer/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String customerDelete(Model model, HttpServletRequest request) {
        KeycloakSecurityContext keycloak = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
        model.addAttribute("authz", keycloak.getAuthorizationContext());
        return "customer/delete";
    }

    @RequestMapping(value = "/admin/view", method = {RequestMethod.GET, RequestMethod.POST})
    public String admin(Model model, HttpServletRequest request) {
        KeycloakSecurityContext keycloak = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
        model.addAttribute("authz", keycloak.getAuthorizationContext());
        return "admin/view";
    }

    @RequestMapping(value = "/admin/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String adminDelete(Model model, HttpServletRequest request) {
        KeycloakSecurityContext keycloak = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
        model.addAttribute("authz", keycloak.getAuthorizationContext());
        return "admin/delete";
    }

    @RequestMapping(value = "/accessDenied", method = {RequestMethod.GET, RequestMethod.POST})
    public String accessDenied() {
        return "access_denied";
    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "logout";
    }
}
