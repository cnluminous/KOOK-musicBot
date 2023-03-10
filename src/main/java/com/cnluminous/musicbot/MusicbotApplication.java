package com.cnluminous.musicbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MusicbotApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MusicbotApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

}
