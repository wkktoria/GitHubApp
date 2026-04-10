package io.github.wkktoria.githubapp.domain.repocrud;


import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.Set;

interface RepoRepository extends Repository<Repo, Long> {

    Repo save(final Repo repo);

    boolean existsByOwnerAndName(final String owner, final String name);

    Set<Repo> findAll(final Pageable pageable);

    Optional<Repo> findById(final Long id);

    void deleteById(final Long id);

}
