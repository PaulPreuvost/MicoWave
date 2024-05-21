package com.gab1machine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicoWaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicoWaveApplication.class, args);
	}

}
