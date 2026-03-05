package io.github.wkktoria.githubapp;

public record UserRepoResponseDto(String name, UserRepoOwnerResponseDto owner, boolean fork) {
}
