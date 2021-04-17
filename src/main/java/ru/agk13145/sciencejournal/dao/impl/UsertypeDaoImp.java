package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.UsertypeDao;
import ru.agk13145.sciencejournal.model.UserType;
import ru.agk13145.sciencejournal.model.mapper.UsertypeMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsertypeDaoImp implements UsertypeDao {

    private final static String SQL_SELECT_USERTYPE = "SELECT ID, NAME, DESCRIPTION FROM sciencejournal.Usertypes " +
            "WHERE id = :id";

    private final static String SQL_CREATE_USERTYPE = "INSERT INTO " +
            "sciencejournal.Usertypes(name, description) VALUES (:name,:description )";

    private final static String SQL_UPDATE_USERTYPE = "UPDATE sciencejournal.Usertypes " +
            "SET name = :name, description=:description WHERE id = :id";

    private final static String SQL_DELETE_USERTYPE = "DELETE FROM sciencejournal.Usertypes WHERE id = :id";

    private final static String SQL_SELECT_ALL_USERTYPE = "SELECT ID, NAME, DESCRIPTION  FROM sciencejournal.Usertypes ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public UserType getUserType(Integer usertypeId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", usertypeId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_USERTYPE, paramMap, new UsertypeMapper());
    }

    @Override
    @Transactional
    public Integer createUserType(UserType usertype) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", usertype.getName());
        namedParameters.addValue("description", usertype.getDescription());
        namedParameterJdbcTemplate.update(SQL_CREATE_USERTYPE, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateUserType(UserType usertype) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", usertype.getId());
        params.put("name", usertype.getName());
        params.put("description", usertype.getDescription());
        namedParameterJdbcTemplate.update(SQL_UPDATE_USERTYPE, params);
    }

    @Override
    @Transactional
    public void deleteUserType(Integer usertypeId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", usertypeId);
        namedParameterJdbcTemplate.update(SQL_DELETE_USERTYPE, params);
    }

    @Override
    public List<UserType> getUserTypes() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_USERTYPE, new UsertypeMapper());
    }
}
