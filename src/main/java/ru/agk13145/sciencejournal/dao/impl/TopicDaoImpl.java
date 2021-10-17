package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.TopicDao;
import ru.agk13145.sciencejournal.model.Topic;
import ru.agk13145.sciencejournal.model.mapper.TopicMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TopicDaoImpl implements TopicDao {

    private final static String SQL_SELECT_TOPIC = "SELECT ID, NAME FROM sciencejournal.topics " +
            "WHERE id = :id";

    private final static String SQL_CREATE_TOPIC = "INSERT INTO " +
            "sciencejournal.topics(name) VALUES (:name)";

    private final static String SQL_UPDATE_TOPIC = "UPDATE sciencejournal.topics " +
            "SET name = :name WHERE id = :id";

    private final static String SQL_DELETE_TOPIC = "DELETE FROM sciencejournal.topics WHERE id = :id";

    private final static String SQL_SELECT_ALL_TOPICS = "SELECT ID, NAME FROM sciencejournal.topics ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Topic getTopic(Integer topicId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", topicId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_TOPIC, paramMap, new TopicMapper());
    }

    @Override
    @Transactional
    public Integer createTopic(Topic topic) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", topic.getName());
        namedParameterJdbcTemplate.update(SQL_CREATE_TOPIC, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateTopic(Topic topic) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", topic.getId());
        params.put("name", topic.getName());
        namedParameterJdbcTemplate.update(SQL_UPDATE_TOPIC, params);
    }

    @Override
    @Transactional
    public void deleteTopic(Integer topicId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", topicId);
        namedParameterJdbcTemplate.update(SQL_DELETE_TOPIC, params);
    }

    @Override
    public List<Topic> getTopics() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_TOPICS, new TopicMapper());
    }
}
