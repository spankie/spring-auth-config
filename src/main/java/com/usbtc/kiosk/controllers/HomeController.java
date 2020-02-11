package com.usbtc.kiosk.controllers;

import javax.servlet.http.HttpServletResponse;

import com.usbtc.kiosk.configurations.PropertyConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 */
@RestController
@RequestMapping("api")
public class HomeController {

  @Autowired
  private PropertyConfiguration propertyConfiguration;

  @Value("${api.spankie.from:Hi}") // sets the default to "Hi"
  private String from;

  @GetMapping
  public String name(HttpServletResponse response) {
    response.setStatus(200);
    return "'" + propertyConfiguration.getFrom() + "'" + from + "'";
  }
}