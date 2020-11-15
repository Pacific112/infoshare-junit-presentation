package pl.infoshare.junit5._4_security.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;

public class CurrendaSecurityFilter extends GenericFilterBean {

    private final CurrendaUserRepository currendaUserRepository;

    public CurrendaSecurityFilter(CurrendaUserRepository currendaUserRepository) {
        this.currendaUserRepository = currendaUserRepository;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var httpServletRequest = (HttpServletRequest) servletRequest;
        var path = httpServletRequest.getServletPath();
        var authHeader = httpServletRequest.getHeader("Authorization");

        if (Objects.nonNull(authHeader) && authHeader.equals("let me in") && path.equals("/secured/secret")) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(new User("sample", "pass", Collections.emptyList()), "pass", Collections.emptyList()));
        } else if (Objects.nonNull(authHeader) && path.equals("/users/me")) {
            var id = Integer.valueOf(authHeader);
            var currendaUser = currendaUserRepository.findById(id);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(currendaUser, "pass", Collections.emptyList()));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
