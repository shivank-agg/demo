package com.example.demo;

import com.example.demo.models.Author;
import com.example.demo.models.Specifications.AuthorSpecification;
import com.example.demo.models.Video;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.VideoRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository repository
    ) {
        return args -> {
            Faker faker = new Faker();
            var author = Author.builder()
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .age(faker.number().numberBetween(19,50))
                    .email("shivank.agg...sa@gmail.com")
                    .build();
            System.out.println(author);
            repository.save(author);
            //List<Author> aut = repository.findByNamedQuery(16);
            //aut.forEach(System.out::println);
            //Specification<Author> specs = Specification
            //        .where(AuthorSpecification.hasAge(23));

            //repository.findAll(specs).forEach(System.out::println);
            //repository.updateByNamedQuery(23);
            /*for(int i = 0; i <50 ; i++){
                Faker faker = new Faker();
                var author = Author.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .age(faker.number().numberBetween(19,50))
                        .email("shivank.agg"+i+".sa@gmail.com")
                        .build();
                repository.save(author);
            }*/
            /*var video = Video.builder()
                    .name("abc")
                    .length(5)
                    .build();
            videoRepository.save(video);*/

        };
    }

}