package br.edu.ufop.web.nameserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class NameserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(NameserverApplication.class, args);
    }

}
