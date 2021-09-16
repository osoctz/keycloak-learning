package cn.metaq.app.sqlbuilder.web;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("index")
    public String index(Model model, HttpServletRequest request) {
        KeycloakSecurityContext keycloak = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
        model.addAttribute("accessToken", keycloak.getTokenString());
        return "index";
    }

    @GetMapping("demo/list")
    public String list() {

        return "list";
    }
}