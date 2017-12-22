package com.cmpe275.cusr;	

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.cmpe275.cusr.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.cmpe275.cusr"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}	
}
