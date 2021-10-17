package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.ConfigDao;
import ru.agk13145.sciencejournal.dao.ConfigDao;
import ru.agk13145.sciencejournal.model.Config;
import ru.agk13145.sciencejournal.model.mapper.ConfigMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ConfigDaoImp implements ConfigDao {

    private final static String SQL_SELECT_CONFIG = "SELECT ID, NAME, DESCRIPTION FROM sciencejournal.configs " +
            "WHERE id = :id";

    private final static String SQL_CREATE_CONFIG = "INSERT INTO " +
            "sciencejournal.configs(name, description) VALUES (:name,:description )";

    private final static String SQL_UPDATE_CONFIG = "UPDATE sciencejournal.configs " +
            "SET name = :name, description=:description WHERE id = :id";

    private final static String SQL_DELETE_CONFIG = "DELETE FROM sciencejournal.configs WHERE id = :id";

    private final static String SQL_SELECT_ALL_CONFIG = "SELECT ID, NAME, DESCRIPTION  FROM sciencejournal.configs ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Config getConfig(Integer configId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", configId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_CONFIG, paramMap, new ConfigMapper());
    }

    @Override
    @Transactional
    public Integer createConfig(Config config) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", config.getName());
        namedParameters.addValue("description", config.getDescription());
        namedParameterJdbcTemplate.update(SQL_CREATE_CONFIG, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateConfig(Config config) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", config.getId());
        params.put("name", config.getName());
        params.put("description", config.getDescription());
        namedParameterJdbcTemplate.update(SQL_UPDATE_CONFIG, params);
    }

    @Override
    @Transactional
    public void deleteConfig(Integer configId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", configId);
        namedParameterJdbcTemplate.update(SQL_DELETE_CONFIG, params);
    }

    @Override
    public List<Config> getConfigs() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_CONFIG, new ConfigMapper());
    }
}
