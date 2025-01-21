package com.echenagucia.foroalura.domain.topic;

import com.echenagucia.foroalura.domain.topic.dto.UpdateTopicData;
import com.echenagucia.foroalura.domain.topic.dto.RegisterTopicData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle;
    private String message;
    private LocalDateTime createData;
    private String status;
    private String author;
    private String course;

    public Topic(RegisterTopicData registerTopicData) {

        this.tittle = registerTopicData.tittle();
        this.message = registerTopicData.message();
        this.createData = registerTopicData.createDate();
        this.status = registerTopicData.status();
        this.author = registerTopicData.author();
        this.course = registerTopicData.course();

    }

    public void updateData(UpdateTopicData updateTopicData) {

        if (updateTopicData.tittle() != null) {
            this.tittle = updateTopicData.tittle();
        }

        if (updateTopicData.message() != null) {
            this.message = updateTopicData.message();
        }

        if (updateTopicData.createDate() != null) {
            this.createData = updateTopicData.createDate();
        }

        if (updateTopicData.status() != null) {
            this.status = updateTopicData.status();
        }

        if (updateTopicData.author() != null) {
            this.author = updateTopicData.author();
        }

        if (updateTopicData.course() != null) {
            this.course = updateTopicData.course();
        }

    }

}
