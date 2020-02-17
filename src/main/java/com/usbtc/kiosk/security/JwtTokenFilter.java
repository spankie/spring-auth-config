package com.usbtc.kiosk.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usbtc.kiosk.exceptions.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * {JwtTokenFilter} We should use OncePerRequestFilter since we are doing a
 * database call, there is no point in doing this more than once
 */
public class JwtTokenFilter extends OncePerRequestFilter {
  private JwtTokenProvider jwtTokenProvider;

  public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    // Removes the "Bearer " from the authorization header
    String token = jwtTokenProvider.resolveToken(request);
    try {
      if (token != null && jwtTokenProvider.validateToken(token)) {
        Authentication auth = jwtTokenProvider.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    } catch (UsernameNotFoundException e) {
      // this is very important, since it guarantees the user is not authenticated at
      // all
      SecurityContextHolder.clearContext();
      // see what happens if this error is not sent
      response.sendError(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
      // OR just throw a custom exception that would be caught by exception handler
      return; // dont call the rest of the filter chain
    }

    filterChain.doFilter(request, response);
  }

}