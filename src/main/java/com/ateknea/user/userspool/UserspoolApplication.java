package com.ateknea.user.userspool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserspoolApplication {

	public static void main(String[] args) {
        SpringApplication.run(UserspoolApplication.class, args);
    }

//    @Bean
//    ApplicationRunner init(UserRepository repository) {
//        return args -> {
//            Stream.of("Antonio", "Javier", "Raúl", "Lola").forEach(name -> {
//                User user = new User();
//                user.setName(name);
//                repository.save(user);
//            });
//            repository.findAll().forEach(System.out::println);
//        };
//    }
}
