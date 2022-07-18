package cn.metaq.example.keycloak.web;

import javax.servlet.http.HttpServletRequest;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

  @RequestMapping(value = "/getToken",method = RequestMethod.POST)
  @ResponseBody
  public String token(HttpServletRequest request) {

    KeycloakSecurityContext keycloak = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());

    return keycloak.getTokenString();
  }

  @RequestMapping(value = "/hello")
  @ResponseBody
  public String hello() {
    return "Hello World!";
  }

  @RequestMapping(value = "/hello2")
  @ResponseBody
  public String hello2() {
    return "Hello World2!";
  }
}
