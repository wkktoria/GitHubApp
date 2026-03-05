package io.github.wkktoria.githubapp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "github", url = "https://api.github.com")
public interface GitHubClient {

    @GetMapping(value = "/users/{username}/repos", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserRepoResponseDto> getUserRepos(@PathVariable String username);

    @GetMapping(value = "/repos/{username}/{repo}/branches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RepoBranchResponseDto> getRepoBranches(@PathVariable String username, @PathVariable String repo);

}
