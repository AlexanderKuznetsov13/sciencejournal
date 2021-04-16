package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.Topic;

public interface TopicDao {
    /**
     *
     * @param topicId
     * @return
     */
    Topic getTopic(Integer topicId);

}
