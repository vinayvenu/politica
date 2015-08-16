package org.freedom.politica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@Import(WebMvcAutoConfiguration.class)
@SpringBootApplication
@ComponentScan("org.freedom.politica")
public class PoliticaService extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PoliticaService.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PoliticaService.class, args);
    }
}
