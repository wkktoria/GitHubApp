package io.github.wkktoria.githubapp.domain.proxy.dto;

public record RepoBranchResponseDto(String name, RepoBranchCommitResponseDto commit) {
}
