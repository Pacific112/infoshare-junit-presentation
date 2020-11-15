package pl.infoshare.junit5._4_security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {

    @GetMapping("/secured/secret")
    public String  getUser(@AuthenticationPrincipal User user) {
        return "secured_controller: " + user.getUsername() ;
    }
}
