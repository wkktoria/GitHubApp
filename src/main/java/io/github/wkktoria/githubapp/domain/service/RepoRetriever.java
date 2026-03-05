package io.github.wkktoria.githubapp.domain.service;

import feign.FeignException;
import io.github.wkktoria.githubapp.infrastructure.controller.dto.BranchResponseDto;
import io.github.wkktoria.githubapp.infrastructure.controller.dto.NonForkRepoResponseDto;
import io.github.wkktoria.githubapp.domain.proxy.dto.RepoBranchResponseDto;
import io.github.wkktoria.githubapp.UserNotFoundException;
import io.github.wkktoria.githubapp.domain.proxy.GitHubClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepoRetriever {

    private final GitHubClient gitHubClient;

    RepoRetriever(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    public List<NonForkRepoResponseDto> getUserRepos(String username) {
        try {
            return gitHubClient.getUserRepos(username).stream()
                    .filter(repo -> !repo.fork())
                    .map(repo -> {
                        List<RepoBranchResponseDto> branches = gitHubClient.getRepoBranches(username, repo.name());
                        List<BranchResponseDto> branchDtos = branches.stream()
                                .map(RepoMapper::mapRepoBranchResponseDtoToBranchResponseDto)
                                .toList();

                        return new NonForkRepoResponseDto(
                                repo.name(),
                                repo.owner().login(),
                                branchDtos
                        );
                    })

                    .toList();
        } catch (FeignException.NotFound exception) {
            throw new UserNotFoundException("Could not find user with username='" + username + "'");
        }
    }
}
