package com.usbtc.kiosk.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.usbtc.kiosk.controllers.AuthController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TestAuthController
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthControllerTest {

  private AuthController authController;

  @Autowired
  public AuthControllerTest(AuthController authController) {
    this.authController = authController;
  }

  @Test
  public void contextLoads() {
    assertNotNull(authController);
  }

}