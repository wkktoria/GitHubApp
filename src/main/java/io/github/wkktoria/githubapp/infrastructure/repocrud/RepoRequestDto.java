package io.github.wkktoria.githubapp.infrastructure.repocrud;

import jakarta.validation.constraints.NotBlank;

public record RepoRequestDto(
        @NotBlank
        String owner,

        @NotBlank
        String name
) {
}
