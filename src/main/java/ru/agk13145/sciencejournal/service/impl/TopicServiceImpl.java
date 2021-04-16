package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agk13145.sciencejournal.dao.TopicDao;
import ru.agk13145.sciencejournal.dao.UserDao;
import ru.agk13145.sciencejournal.model.Topic;
import ru.agk13145.sciencejournal.model.User;
import ru.agk13145.sciencejournal.service.TopicService;
import ru.agk13145.sciencejournal.service.UserService;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicDao topicDao;

    @Override
    public Topic getTopic(Integer topicId) {
        return topicDao.getTopic(topicId);
    }
}
