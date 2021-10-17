package ru.agk13145.sciencejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.model.Topic;
import ru.agk13145.sciencejournal.service.TopicService;

import java.util.List;

@Controller
@RequestMapping(value = "/topics", produces = "application/json;charset=UTF-8")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Topic>> getTopics() {
        List<Topic> topics = topicService.getTopics();
        return new ResponseEntity<>(topics, HttpStatus.OK);
    }

    @GetMapping(value = "/{topicId}")
    @ResponseBody
    public ResponseEntity<Topic> getTopic(@PathVariable Integer topicId) {
        Topic topic = topicService.getTopic(topicId);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        Integer topicId = topicService.createTopic(topic);
        topic = topicService.getTopic(topicId);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @PutMapping(value = "/{topicId}")
    @ResponseBody
    public ResponseEntity<Topic> updateTopic(@PathVariable Integer topicId, @RequestBody Topic topic) {
        topic.setId(topicId);
        topicService.updateTopic(topic);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{topicId}")
    public ResponseEntity<Integer> deleteTopic(@PathVariable Integer topicId) {
        topicService.deleteTopic(topicId);
        return new ResponseEntity<>(topicId, HttpStatus.OK);
    }

}
