package com.cg.iter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookOrderMsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookOrderMsEurekaServerApplication.class, args);
	}

}
