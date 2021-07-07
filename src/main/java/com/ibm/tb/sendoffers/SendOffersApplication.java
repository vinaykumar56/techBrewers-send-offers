package com.ibm.tb.sendoffers;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.ibm.tb.sendoffers.controller","com.ibm.tb.sendoffers.api.config","com.ibm.tb.sendoffers.api.client","com.ibm.tb.sendoffers.api.service"})
public class SendOffersApplication {


	public static void main(String[] args) {
		SpringApplication.run(SendOffersApplication.class, args);
		
	}

}
