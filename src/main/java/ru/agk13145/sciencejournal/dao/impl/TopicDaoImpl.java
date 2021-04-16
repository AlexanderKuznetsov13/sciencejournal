package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.agk13145.sciencejournal.dao.TopicDao;
import ru.agk13145.sciencejournal.model.Topic;
import ru.agk13145.sciencejournal.model.mapper.TopicMapper;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TopicDaoImpl implements TopicDao {

    private final static String SQL_SELECT_TOPIC = "SELECT ID, NAME FROM topics " +
            "WHERE id = :id";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Topic getTopic(Integer topicId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", topicId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_TOPIC, paramMap, new TopicMapper());
    }
}
