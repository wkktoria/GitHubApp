package io.github.wkktoria.githubapp.domain.service;

import io.github.wkktoria.githubapp.infrastructure.proxy.dto.RepoBranchResponseDto;
import io.github.wkktoria.githubapp.infrastructure.controller.dto.BranchResponseDto;

public class RepoMapper {

    public static BranchResponseDto mapRepoBranchResponseDtoToBranchResponseDto(RepoBranchResponseDto repoBranch) {
        return new BranchResponseDto(repoBranch.name(), repoBranch.commit().sha());
    }

}
