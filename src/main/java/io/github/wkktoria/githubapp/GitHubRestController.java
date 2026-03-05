package io.github.wkktoria.githubapp;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
public class GitHubRestController {

    private final RepoRetriever repoRetriever;

    GitHubRestController(RepoRetriever repoRetriever) {
        this.repoRetriever = repoRetriever;
    }

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NonForkRepoResponseDto>> getAllUserRepositories(@PathVariable String username) {
        log.info("Getting all repositories for user={}", username);
        return ResponseEntity.ok(repoRetriever.getUserRepos(username));
    }

}
