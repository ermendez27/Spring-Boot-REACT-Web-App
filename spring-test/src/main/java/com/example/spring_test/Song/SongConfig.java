package com.example.spring_test.Song;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SongConfig {

        @Bean
        CommandLineRunner commandLineRunner(SongRepository repository) {
                return args -> {

                        Song solace = new Song(
                                        "Solace",
                                        "Earl", LocalDate.of(
                                                        2008,
                                                        06,
                                                        27),
                                        2000);

                        Song godspeed = new Song(
                                        "Godspeed",
                                        "Frank", LocalDate.of(
                                                        2008,
                                                        9,
                                                        11),
                                        5000);

                        repository.saveAll(
                                        List.of(solace, godspeed));

                };
        }

}
