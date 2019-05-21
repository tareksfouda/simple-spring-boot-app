package com.example.review;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.review.model.Role;
import com.example.review.model.User;
import com.example.review.repo.UserRepo;
import com.example.review.service.UserService;

@SpringBootApplication
public class ApplicationStarter {
	
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
    
//    @Autowired
//    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepo repo) throws Exception {
//    	builder.userDetailsService(s -> new CustomUserDetails(repo.findByName(s)));
//    }
    
    @Bean
    public CommandLineRunner setupDefaultUser(UserService service) {
        return args -> {
            service.store(new User(
                    "user", //username
                    "user", //password
Arrays.asList(new Role("USER"), new Role("ACTUATOR"))//roles 
            ));
        };
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }    

}
