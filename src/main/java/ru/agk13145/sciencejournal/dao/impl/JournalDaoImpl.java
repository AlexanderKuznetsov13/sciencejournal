package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.JournalDao;
import ru.agk13145.sciencejournal.model.Journal;
import ru.agk13145.sciencejournal.model.mapper.JournalMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JournalDaoImpl implements JournalDao {

    private final static String SQL_SELECT_JOURNAL = "SELECT ID, NAME, TOPIC_ID, LANGUAGE_ID, ISSN FROM sciencejournal.journals " +
            "WHERE id = :id";

    private final static String SQL_CREATE_JOURNAL = "INSERT INTO " +
            "sciencejournal.journals(name, topic_id, language_id, issn) VALUES (:name, :topic_id, :language_id, :issn  )";

    private final static String SQL_UPDATE_JOURNAL = "UPDATE sciencejournal.journals " +
            "SET name = :name WHERE id = :id";

    private final static String SQL_DELETE_JOURNAL = "DELETE FROM sciencejournal.journals WHERE id = :id";

    private final static String SQL_SELECT_ALL_JOURNALS = "SELECT ID, NAME, TOPIC_ID, LANGUAGE_ID, ISSN FROM sciencejournal.journals ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Journal getJournal(Integer journalId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", journalId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_JOURNAL, paramMap, new JournalMapper());
    }

    @Override
    @Transactional
    public Integer createJournal(Journal journal) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", journal.getName());
        namedParameters.addValue("topic_id", journal.getTopicId());
        namedParameters.addValue("language_id", journal.getLanguageId());
        namedParameters.addValue("issn", journal.getIssn());
        namedParameterJdbcTemplate.update(SQL_CREATE_JOURNAL, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateJournal(Journal journal) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", journal.getId());
        params.put("name", journal.getName());
        namedParameterJdbcTemplate.update(SQL_UPDATE_JOURNAL, params);
    }

    @Override
    @Transactional
    public void deleteJournal(Integer journalId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", journalId);
        namedParameterJdbcTemplate.update(SQL_DELETE_JOURNAL, params);
    }

    @Override
    public List<Journal> getJournals() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_JOURNALS, new JournalMapper());
    }
}
