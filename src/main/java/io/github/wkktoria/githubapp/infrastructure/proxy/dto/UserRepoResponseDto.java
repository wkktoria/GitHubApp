package io.github.wkktoria.githubapp.infrastructure.proxy.dto;

public record UserRepoResponseDto(String name, UserRepoOwnerResponseDto owner, boolean fork) {
}
