package ru.agk13145.sciencejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.agk13145.sciencejournal.model.Topic;
import ru.agk13145.sciencejournal.service.TopicService;

@Controller
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topic/{topicId}" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Topic> getTopic(@PathVariable String topicId) {
       Topic topic = topicService.getTopic(Integer.parseInt(topicId));
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

}
