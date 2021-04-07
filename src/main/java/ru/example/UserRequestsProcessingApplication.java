package ru.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class UserRequestsProcessingApplication {

    @Value("${db.timezone}")
    private String timeZone;


    public static void main(String[] args) {
        SpringApplication.run(UserRequestsProcessingApplication.class, args);
    }

    @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }
}
