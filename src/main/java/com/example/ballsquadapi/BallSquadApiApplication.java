package com.example.ballsquadapi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableFeignClients
public class BallSquadApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BallSquadApiApplication.class, args);
    }

}
