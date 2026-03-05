package io.github.wkktoria.githubapp;

import java.util.List;

public record NonForkRepoResponseDto(
        String repositoryName,
        String ownerLogin,
        List<BranchResponseDto> branches) {
}
