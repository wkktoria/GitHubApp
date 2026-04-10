package io.github.wkktoria.githubapp.domain.repocrud;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
class RepoAdder {

    private final RepoRepository repoRepository;

    RepoDto addRepo(final String owner, final String name) {
        log.info("Adding repo with owner='{}' and name='{}' to database",
                owner, name);

        if (repoRepository.existsByOwnerAndName(owner, name)) {
            log.warn("Repo is already saved");
            return RepoDto.builder()
                    .owner(owner)
                    .name(name)
                    .build();
        }

        Repo repo = Repo.builder()
                .owner(owner)
                .name(name)
                .build();

        Repo savedRepo = repoRepository.save(repo);
        return RepoDto.builder()
                .id(savedRepo.getId())
                .owner(savedRepo.getOwner())
                .name(savedRepo.getName())
                .build();
    }

}
