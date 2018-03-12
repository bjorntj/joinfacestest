package no.havleik.joinfacestest.configuration;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.session.SessionManagementFilter;

/**
 * Created by Bjørn T Johansen on 09.11.2015.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    /*@SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DataSource dataSource;*/

    /*@Autowired
    private CustomPasswordEncoderImpl customPasswordEncoder;*/

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable();

        http
            .authorizeRequests()
            .requestMatchers(EndpointRequest.to("status", "info")).permitAll()
            .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("Admin")
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .antMatchers("/secure/admin/**").access("hasAuthority('Admin')")
            .antMatchers("/secure/**").access("isAuthenticated()")
            .antMatchers("/**").permitAll()
            .and()
            .formLogin().loginPage("/login.xhtml").failureUrl("/login.xhtml")
            .defaultSuccessUrl("/secure/index.xhtml")
            .failureUrl("/login.xhtml")
            .usernameParameter("j_username")
            .passwordParameter("j_password")
            .loginProcessingUrl("/j_spring_security_check")
            .permitAll()
            .and()
            .logout().logoutUrl("j_spring_security_logout").logoutSuccessUrl("/logout")
            .permitAll()
            .and()
            .sessionManagement()
            .invalidSessionUrl("/login.xhtml")
            .maximumSessions(2);

        SessionManagementFilter sessionManagementFilter = new SessionManagementFilter(new HttpSessionSecurityContextRepository());
        http.addFilter(sessionManagementFilter);
    }

}
