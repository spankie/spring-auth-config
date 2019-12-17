package com.usbtc.kiosk.services;

import com.usbtc.kiosk.models.User;

/**
 * AuthService
 */
public interface AuthService {
  public User signup(User user);
}