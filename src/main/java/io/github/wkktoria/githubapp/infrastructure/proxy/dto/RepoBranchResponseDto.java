package io.github.wkktoria.githubapp.infrastructure.proxy.dto;

public record RepoBranchResponseDto(String name, RepoBranchCommitResponseDto commit) {
}
