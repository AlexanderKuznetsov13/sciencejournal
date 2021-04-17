package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.ConfigByJournalDao;
import ru.agk13145.sciencejournal.model.ConfigByJournal;
import ru.agk13145.sciencejournal.model.mapper.ConfigByJournalMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ConfigByJournalDaoImp implements ConfigByJournalDao {

    private final static String SQL_SELECT_CONFIGBYJOURNAL = "SELECT ID, CONFIG_ID, JOURNAL_ID, VALUE FROM sciencejournal.configsbyjournal " +
            "WHERE id = :id";

    private final static String SQL_CREATE_CONFIGBYJOURNAL = "INSERT INTO " +
            "sciencejournal.configsbyjournal(config_id, journal_id, value) VALUES (:config_id, :journal_id, :value)";

    private final static String SQL_UPDATE_CONFIGBYJOURNAL = "UPDATE sciencejournal.configsbyjournal " +
            "SET config_id = :config_id, journal_id=:journal_id, value = :value WHERE id = :id";

    private final static String SQL_DELETE_CONFIGBYJOURNAL = "DELETE FROM sciencejournal.configsbyjournal WHERE id = :id";

    private final static String SQL_SELECT_ALL_CONFIGBYJOURNAL = "SELECT ID, CONFIG_ID, JOURNAL_ID, VALUE  FROM sciencejournal.configsbyjournal ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public ConfigByJournal getConfigByJournal(Integer configByJournalId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", configByJournalId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_CONFIGBYJOURNAL, paramMap, new ConfigByJournalMapper());
    }

    @Override
    @Transactional
    public Integer createConfigByJournal(ConfigByJournal configByJournal) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("config_id", configByJournal.getConfigId());
        namedParameters.addValue("journal_id", configByJournal.getJournalId());
        namedParameters.addValue("value", configByJournal.getValue());
        namedParameterJdbcTemplate.update(SQL_CREATE_CONFIGBYJOURNAL, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateConfigByJournal(ConfigByJournal configByJournal) {
        Map<String, Object> params = new HashMap<>();
        params.put("config_id", configByJournal.getConfigId());
        params.put("journal_id", configByJournal.getJournalId());
        params.put("value", configByJournal.getValue());
        namedParameterJdbcTemplate.update(SQL_UPDATE_CONFIGBYJOURNAL, params);
    }

    @Override
    @Transactional
    public void deleteConfigByJournal(Integer configByJournalId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", configByJournalId);
        namedParameterJdbcTemplate.update(SQL_DELETE_CONFIGBYJOURNAL, params);
    }

    @Override
    public List<ConfigByJournal> getConfigByJournals() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_CONFIGBYJOURNAL, new ConfigByJournalMapper());
    }
}
