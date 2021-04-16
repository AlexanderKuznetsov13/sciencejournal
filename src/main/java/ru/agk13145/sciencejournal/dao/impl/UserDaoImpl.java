package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.agk13145.sciencejournal.dao.UserDao;
import ru.agk13145.sciencejournal.model.User;
import ru.agk13145.sciencejournal.model.mapper.UserMapper;

import java.util.HashMap;
import java.util.Map;


@Repository
public class UserDaoImpl implements UserDao {

    private final static String SQL_SELECT_USER = "SELECT ID, NAME, SURNAME, MIDDLE_NAME, EMAIL, PASSWORD FROM users " +
            "WHERE id = :id";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getUser(Integer userId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", userId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_USER, paramMap, new UserMapper());
    }
}
