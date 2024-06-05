package com.example.Gelderse_Kastelen_Java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GelderseKastelenJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GelderseKastelenJavaApplication.class, args);
	}

}
