package io.github.wkktoria.githubapp.infrastructure.repocrud;

import io.github.wkktoria.githubapp.domain.repocrud.RepoCrudFacade;
import io.github.wkktoria.githubapp.domain.repocrud.RepoDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/repos")
@RequiredArgsConstructor
class RepoController {

    private final RepoCrudFacade repoCrudFacade;

    @GetMapping
    ResponseEntity<Set<RepoDto>> getRepos(@PageableDefault final Pageable pageable) {
        return ResponseEntity.ok(repoCrudFacade.findAllRepos(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<RepoDto> getRepoById(@PathVariable final Long id) {
        return ResponseEntity.ok(repoCrudFacade.findRepoById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteRepo(@PathVariable final Long id) {
        repoCrudFacade.deleteRepoById(id);
        return ResponseEntity.ok("Repo with id=" + id + " successfully deleted");
    }

    @PostMapping
    ResponseEntity<RepoDto> createRepo(@RequestBody @Valid final RepoRequestDto requestDto) {
        RepoDto repo = repoCrudFacade.addRepo(requestDto.owner(), requestDto.name());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repo);
    }

    @PutMapping("/{id}")
    ResponseEntity<RepoDto> updateRepo(@PathVariable final Long id,
                                       @RequestBody @Valid final RepoRequestDto requestDto) {
        return ResponseEntity.ok(repoCrudFacade.updateRepoById(id, requestDto.owner(), requestDto.name()));
    }

}
