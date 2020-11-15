package pl.infoshare.junit5._4_security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * UWAGA! Ta konfiguracja oraz pochodne komponenty tj. filtry powstały jedynie w celu zaprezentowania konkretnych
 * testowych przypadków i nie powinna być w żadnym wypadku brane za wzór w jaki sposób implementować warstwę Security w Springu.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new CurrendaSecurityFilter(new CurrendaUserRepository()), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/secured/secret").authenticated()
                .antMatchers("/users/me").authenticated()
                .antMatchers("/**").permitAll();
    }
}
