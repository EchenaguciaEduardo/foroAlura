package com.echenagucia.foroalura.domain.topic.dto;


import com.echenagucia.foroalura.domain.topic.Topic;

import java.time.LocalDateTime;

public record ListTopicData(

        String tittle,
        String message,
        LocalDateTime createDate,
        String status,
        String author,
        String course

    ) {

    public ListTopicData(Topic topic) {

        this(topic.getTittle(), topic.getMessage(), topic.getCreateData(),
                topic.getStatus(), topic.getAuthor(), topic.getCourse());

    }

}
