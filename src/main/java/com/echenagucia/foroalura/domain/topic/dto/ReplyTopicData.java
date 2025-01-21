package com.echenagucia.foroalura.domain.topic.dto;


import com.echenagucia.foroalura.domain.topic.Topic;

import java.time.LocalDateTime;

public record ReplyTopicData(

        Long id,
        String tittle,
        String message,
        LocalDateTime createDate,
        String status,
        String author,
        String course

    ) {

    public ReplyTopicData(Topic topic) {

        this(topic.getId(), topic.getTittle(), topic.getMessage(), topic.getCreateData(),
                topic.getStatus(), topic.getAuthor(), topic.getCourse());

    }

}
