package io.github.wkktoria.githubapp;

import feign.FeignException;
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
                                .map(branch -> new BranchResponseDto(branch.name(), branch.commit().sha()))
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
