package io.github.wkktoria.githubapp.domain.repocrud;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
class RepoDeleter {

    private final RepoRepository repoRepository;

    void deleteById(final Long id) {
        log.info("Deleting repo with id={} from database", id);
        if (repoRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Could not find repo with id=" + id);
        }
        repoRepository.deleteById(id);
    }

}
