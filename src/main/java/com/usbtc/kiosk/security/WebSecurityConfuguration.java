package com.usbtc.kiosk.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * WebSecurityConfuguration Overrides the spring security configuration by
 * extending the abstract class WebSecurityConfigurerAdapter
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfuguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Override
  public void configure(WebSecurity web) throws Exception {
    // configure security for http requests.
    super.configure(web);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // We configure security for web pages...

    // Disable CSRF (cross site request forgery)
    // enabled by default
    http.csrf().disable();

    // No session will be created or used by spring security
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // set authentication policies for each routes
    http.authorizeRequests()
        // list out the routes not to authenticate.
        .antMatchers("/api/v1/auth/signup").permitAll().antMatchers("/api").permitAll()
        // set the rest to be authenticated.
        .anyRequest().authenticated();

    // define what to do when user attempt to access and authenticated route without
    // proper authorizations
    http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {

      @Override
      public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException ex)
          throws IOException, ServletException {
        res.setStatus(res.SC_UNAUTHORIZED);
      }
    });
    // accessDeniedPage("/api/v1/auth/login"); PREV
    // accessDeniedHandler() // specify the handler to handle access denied

    // create a new SecurityConfigurerAdapter<DefaultSecurityFilterChain,
    // HttpSecurity>
    // SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>
    // jwtConfigurer = new JwtTokenFilterConfigurer(
    // jwtProvider);

    // Apply JWT Filter to handle authentication/Authorization
    http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

    // Optional, if you want to test the API from a browser
    // http.httpBasic();
  }

  // Create a bean to handle password encoding.
  // @Bean
  // public PasswordEncoder passwordEncoder() {
  // return new BCryptPasswordEncoder(12);
  // }

  // @Bean
  // public PasswordEncoder passwordEncoder() {
  // return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  // }

}