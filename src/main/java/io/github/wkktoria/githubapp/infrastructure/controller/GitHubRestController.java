package io.github.wkktoria.githubapp.infrastructure.controller;

import io.github.wkktoria.githubapp.domain.repocrud.RepoCrudFacade;
import io.github.wkktoria.githubapp.infrastructure.controller.dto.NonForkRepoResponseDto;
import io.github.wkktoria.githubapp.domain.service.GitHubRepoRetriever;
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

    private final GitHubRepoRetriever gitHubRepoRetriever;
    private final RepoCrudFacade repoCrudFacade;

    GitHubRestController(final GitHubRepoRetriever gitHubRepoRetriever, final RepoCrudFacade repoCrudFacade) {
        this.gitHubRepoRetriever = gitHubRepoRetriever;
        this.repoCrudFacade = repoCrudFacade;
    }

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NonForkRepoResponseDto>> getAllUserRepositories(@PathVariable String username) {
        log.info("Getting all repositories for user={}", username);
        List<NonForkRepoResponseDto> repos = gitHubRepoRetriever.getUserRepos(username);
        for (NonForkRepoResponseDto repo : repos) {
            repoCrudFacade.addRepo(
                    repo.ownerLogin(),
                    repo.repositoryName()
            );
        }
        return ResponseEntity.ok(repos);
    }

}
