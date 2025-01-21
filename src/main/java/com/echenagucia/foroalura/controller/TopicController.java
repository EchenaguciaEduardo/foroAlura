package com.echenagucia.foroalura.controller;

import com.echenagucia.foroalura.domain.topic.Topic;
import com.echenagucia.foroalura.domain.topic.TopicRepository;
import com.echenagucia.foroalura.domain.topic.dto.ListTopicData;
import com.echenagucia.foroalura.domain.topic.dto.RegisterTopicData;
import com.echenagucia.foroalura.domain.topic.dto.ReplyTopicData;
import com.echenagucia.foroalura.domain.topic.dto.UpdateTopicData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ReplyTopicData> registerTopic(@RequestBody @Valid RegisterTopicData registerTopicData,
                                                        UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = topicRepository.save(new Topic(registerTopicData));
        ReplyTopicData replyTopicData = new ReplyTopicData(topic);
        URI uri = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(replyTopicData);
    }

    @GetMapping
    public ResponseEntity<Page<ListTopicData>> listTopics(@PageableDefault(size = 5)Pageable pagination) {
        return ResponseEntity.ok(topicRepository.findAll(pagination).map(ListTopicData::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReplyTopicData> listarOneTopic(@PathVariable Long id) {
        Topic topic = topicRepository.getReferenceById(id);
        ReplyTopicData replyTopicData = new ReplyTopicData(topic);
        return ResponseEntity.ok(replyTopicData);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid UpdateTopicData updateTopicData) {
        Topic topic = topicRepository.getReferenceById(updateTopicData.id());
        topic.updateData(updateTopicData);
        return ResponseEntity.ok(new UpdateTopicData(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        topicRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
