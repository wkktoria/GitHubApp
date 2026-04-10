package io.github.wkktoria.githubapp.domain.repocrud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RepoCrudFacade {

    private final RepoAdder repoAdder;
    private final RepoRetriever repoRetriever;
    private final RepoDeleter repoDeleter;
    private final RepoUpdater repoUpdater;

    public RepoDto addRepo(final String owner, final String name) {
        return repoAdder.addRepo(owner, name);
    }

    public Set<RepoDto> findAllRepos(final Pageable pageable) {
        return repoRetriever.findAll(pageable);
    }

    public RepoDto findRepoById(final Long id) {
        return repoRetriever.findById(id);
    }

    public void deleteRepoById(final Long id) {
        repoDeleter.deleteById(id);
    }

    public RepoDto updateRepoById(final Long id, final String owner, final String name) {
        return repoUpdater.updateRepo(id, owner, name);
    }

}
