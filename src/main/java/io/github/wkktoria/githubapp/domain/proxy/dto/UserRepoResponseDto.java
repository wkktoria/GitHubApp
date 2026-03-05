package io.github.wkktoria.githubapp.domain.proxy.dto;

public record UserRepoResponseDto(String name, UserRepoOwnerResponseDto owner, boolean fork) {
}
