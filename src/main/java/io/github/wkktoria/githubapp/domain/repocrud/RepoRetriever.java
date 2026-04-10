package io.github.wkktoria.githubapp.domain.repocrud;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
class RepoRetriever {

    private final RepoRepository repoRepository;

    Set<RepoDto> findAll(final Pageable pageable) {
        log.info("Fetching all repositories from database");
        return repoRepository.findAll(pageable).stream()
                .map(repo -> RepoDto.builder()
                        .id(repo.getId())
                        .owner(repo.getOwner())
                        .name(repo.getName())
                        .build())
                .collect(Collectors.toSet());
    }

    RepoDto findById(final Long id) {
        log.info("Fetching repo with id={} from database", id);
        return repoRepository.findById(id).map(repo -> RepoDto.builder()
                        .id(repo.getId())
                        .owner(repo.getOwner())
                        .name(repo.getName())
                        .build())
                .orElseThrow(() -> new RuntimeException("Could not find repo with id=" + id));
    }

}
