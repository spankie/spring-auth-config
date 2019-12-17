package com.usbtc.kiosk.controllers;

import com.usbtc.kiosk.dto.UserRequestDTO;
import com.usbtc.kiosk.models.User;
import com.usbtc.kiosk.services.AuthService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping("/signup")
  public String signup(@RequestBody UserRequestDTO user) {
    User newuser = authService.signup(modelMapper.map(user, User.class));
    return newuser.getUsername();
  }
}