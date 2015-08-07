package org.freedom.politica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("org.freedom.politica")
public class PoliticaService {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PoliticaService.class, args);
    }
}
