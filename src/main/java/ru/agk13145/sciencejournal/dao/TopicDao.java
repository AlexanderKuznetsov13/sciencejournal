package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.Topic;

import java.util.List;

public interface TopicDao {
    /**
     *
     * @param topicId
     * @return
     */
    Topic getTopic(Integer topicId);

    Integer createTopic(Topic topic);

    void updateTopic(Topic topic);

    void deleteTopic(Integer topicId);

    List<Topic> getTopics();

}
