package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.TopicDao;
import ru.agk13145.sciencejournal.model.Topic;
import ru.agk13145.sciencejournal.service.TopicService;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicDao topicDao;

    @Override
    public Topic getTopic(Integer topicId) {
        return topicDao.getTopic(topicId);
    }

    @Override
    @Transactional
    public Integer createTopic(Topic topic) {
        return topicDao.createTopic(topic);
    }

    @Override
    @Transactional
    public void updateTopic(Topic topic) {
        topicDao.updateTopic(topic);
    }

    @Override
    @Transactional
    public void deleteTopic(Integer topicId) {
        topicDao.deleteTopic(topicId);
    }

    @Override
    public List<Topic> getTopics() {
        return topicDao.getTopics();
    }
}
