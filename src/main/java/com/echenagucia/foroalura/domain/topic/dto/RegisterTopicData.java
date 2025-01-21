package com.echenagucia.foroalura.domain.topic.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegisterTopicData(

        @NotBlank
        String tittle,
        @NotBlank
        String message,
        @NotNull
        @Future
        LocalDateTime createDate,
        @NotBlank
        String status,
        @NotBlank
        String author,
        @NotBlank
        String course

    ) {
}
