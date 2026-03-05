package io.github.wkktoria.githubapp.infrastructure.controller.dto;

import java.util.List;

public record NonForkRepoResponseDto(
        String repositoryName,
        String ownerLogin,
        List<BranchResponseDto> branches) {
}
