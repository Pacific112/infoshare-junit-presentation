package pl.infoshare.junit5._4_security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomUserController {

    @GetMapping("/users/me")
    public CurrendaUser getMeInfo(@AuthenticationPrincipal CurrendaUser user) {
        return user;
    }
}
