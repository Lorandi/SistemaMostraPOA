package com.rodrigolorandi.sistemamostrapoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SistemaMostraPOAApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaMostraPOAApplication.class, args);
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
}
