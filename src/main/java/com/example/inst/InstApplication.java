package com.example.inst;

import com.example.inst.util.Md5Encoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class InstApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstApplication.class, args);


    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Md5Encoder();
    }

}
