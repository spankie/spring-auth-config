package com.usbtc.kiosk;

import com.usbtc.kiosk.configurations.ApiConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KioskApplication {

	@Autowired
	private ApiConfiguration apiConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(KioskApplication.class, args);
		// System.out.println(apiConfiguration.getUrl());
	}

}
