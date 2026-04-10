package io.github.wkktoria.githubapp.domain.repocrud;

import lombok.Builder;

@Builder
public record RepoDto(Long id, String owner, String name) {
}
