package io.github.wkktoria.githubapp.domain.repocrud;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
class RepoUpdater {

    private final RepoRepository repoRepository;

    RepoDto updateRepo(final Long id, final String owner, final String name) {
        log.info("Updating repo with id={}, setting owner={} and name={}",
                id, owner, name);

        Repo repo = repoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find repo with id=" + id));

        if (owner != null && !owner.isBlank()) {
            repo.setOwner(owner);
        }

        if (name != null && !name.isBlank()) {
            repo.setName(name);
        }

        return RepoDto.builder()
                .id(repo.getId())
                .owner(repo.getOwner())
                .name(repo.getName())
                .build();
    }

}
