package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Main application class responsible for bootstrapping the Spring Boot application.
 */
@SpringBootApplication
public class JustEatApplication {

        /**
         * Main method to start the Spring Boot application.
         *
         * @param args Command-line arguments
         */
        public static void main(String[] args) {
                SpringApplication.run(JustEatApplication.class, args);
        }

        /**
         * Bean definition for RestTemplate.
         *
         * @return RestTemplate instance
         */
        @Bean
        public RestTemplate restTemplate() {
                return new RestTemplate();
        }
}
