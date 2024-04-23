package io.security.springsecuritymaster;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final SessionInfoService sessionInfoService;

    @GetMapping("/")
    public Authentication index(Authentication authentication){
        return authentication;
    }

    @GetMapping("/sessionInfo")
    public String sessionInfo() {
        sessionInfoService.sessionInfo();
        return "sessionInfo";
    }

    @GetMapping("/loginPage")
    public String login(){
        return "loginPage";
    }

    @GetMapping("/anonymous")
    public String anonymous(){
        return "anonymous";
    }

    @GetMapping("/authentication")
    public String authentication(Authentication authentication){

        if (authentication instanceof AnonymousAuthenticationToken) {
            return "anonymous";
        } else {
            return "null";
        }
    }
    @GetMapping("/anonymousContext")
    public String anonymousContext(@CurrentSecurityContext SecurityContext context){
        return context.getAuthentication().getName();
    }

    @GetMapping("/logoutSuccess")
    public String logoutSuccess(@CurrentSecurityContext SecurityContext context){
        return "logoutSuccess";
    }

    @GetMapping("/invalidSessionUrl")
    public String invalidSessionurl() {
        return "invalidSessionUrl";
    }

    @GetMapping("/expiredUrl")
    public String expiredUrl() {
        return "expiredUrl";
    }
}