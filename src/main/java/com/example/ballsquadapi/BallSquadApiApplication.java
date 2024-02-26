package com.example.ballsquadapi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import javax.sql.DataSource;

import static java.lang.Thread.sleep;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class BallSquadApiApplication {

    public static void main(String[] args) throws InterruptedException {
        boolean connection = false;
        while (!connection) {
            if (isDatabaseConnected()) {
                SpringApplication.run(BallSquadApiApplication.class, args);
                connection = true;
            } else {
                System.out.println("Database connection failed. Trying again.");
                sleep(10000);
            }
        }
    }
    private static boolean isDatabaseConnected() {
        try {
            DataSourceBuilder.create()
                    .url("jdbc:mysql://ballsquad_db_appc:3306/ballsquad")
                    .username("root")
                    .password("root")
                    .build()
                    .getConnection()
                    .close();
            return true;
        } catch (Exception e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return false;
        }
    }
}
