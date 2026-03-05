package io.github.wkktoria.githubapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GitHubAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitHubAppApplication.class, args);
    }

}
