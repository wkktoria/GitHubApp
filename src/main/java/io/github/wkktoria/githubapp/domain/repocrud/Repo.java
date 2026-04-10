package io.github.wkktoria.githubapp.domain.repocrud;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "repo")
@NoArgsConstructor
@AllArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Builder
class Repo {

    @Id
    @GeneratedValue(generator = "repo_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "repo_id_seq",
            sequenceName = "repo_id_seq",
            allocationSize = 1
    )
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private String name;

}
