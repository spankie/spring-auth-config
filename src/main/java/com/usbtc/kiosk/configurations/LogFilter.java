package com.usbtc.kiosk.configurations;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * LogFilter
 */
public class LogFilter extends OncePerRequestFilter {

  private Logger log = LoggerFactory.getLogger(LogFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    log.debug("Hi there... contentType: ");
    System.out.println("hi there... what is happengin" + request.getRemotePort());
    response.setStatus(500);
    // call the rest of the filters in the chain
    filterChain.doFilter(request, response);
  }

}