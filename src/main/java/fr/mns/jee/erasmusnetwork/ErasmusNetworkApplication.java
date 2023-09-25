package fr.mns.jee.erasmusnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ErasmusNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErasmusNetworkApplication.class, args);
	}

}
