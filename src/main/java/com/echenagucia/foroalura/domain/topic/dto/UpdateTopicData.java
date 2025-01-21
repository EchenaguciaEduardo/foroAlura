package com.echenagucia.foroalura.domain.topic.dto;

import com.echenagucia.foroalura.domain.topic.Topic;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateTopicData(

        @NotNull
        Long id,
        String tittle,
        String message,
        LocalDateTime createDate,
        String status,
        String author,
        String course

    ) {
    public UpdateTopicData(Topic topic) {

        this(topic.getId(), topic.getTittle(), topic.getMessage(), topic.getCreateData(),
                topic.getStatus(), topic.getAuthor(), topic.getCourse());

    }
}
