package io.security.springsecuritymaster;

import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    AuthenticationTrustResolverImpl trustResolver = new AuthenticationTrustResolverImpl();

    @GetMapping("/")
    public String index() {
        Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext()
                .getAuthentication();
        return trustResolver.isAnonymous(authentication) ? "anonymous" : "authenticated";
    }

    @GetMapping("/user")
    public User user(@AuthenticationPrincipal User user){
        return user;
    }

    @GetMapping("/user2")
    public String user2(@AuthenticationPrincipal(expression = "username") String username){
        return username;
    }

    @GetMapping("/currentUser")
    public User currentUser(@CurrentUser User user){
        return user;
    }

    @GetMapping("/currentUser2")
    public String currentUser2(@CurrentUsername String user){
        return user;
    }

    @GetMapping("/db")
    public String db(){
        return "db";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}