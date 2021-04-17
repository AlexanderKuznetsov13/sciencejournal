package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.ApplicationDao;
import ru.agk13145.sciencejournal.model.Application;
import ru.agk13145.sciencejournal.model.mapper.ApplicationMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ApplicationDaoImpl implements ApplicationDao {

    private final static String SQL_SELECT_APPLICATION = "SELECT ID, TITLE, USER_ID, JOURNAL_ID, APPLICATION_STATUS_ID, CREATION_DATE, LAST_MODIFICATION FROM sciencejournal.application " +
            "WHERE id = :id";

    private final static String SQL_CREATE_APPLICATION = "INSERT INTO " +
            "sciencejournal.application(title, user_id, journal_id, application_status_id, creation_date, last_modification) VALUES (:title, :user_id, :journal_id, :application_status_id, now(), now())";

    private final static String SQL_UPDATE_APPLICATION = "UPDATE sciencejournal.application " +
            "SET title = :title, user_id = :user_id, journal_id = :journal_id, application_status_id = :application_status_id, last_modification = now() WHERE id = :id";

    private final static String SQL_DELETE_APPLICATION = "DELETE FROM sciencejournal.application WHERE id = :id";

    private final static String SQL_SELECT_ALL_APPLICATIONS = "SELECT ID, TITLE, USER_ID, JOURNAL_ID, APPLICATION_STATUS_ID, CREATION_DATE, LAST_MODIFICATION FROM sciencejournal.application ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Application getApplication(Integer applicationId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", applicationId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_APPLICATION, paramMap, new ApplicationMapper());
    }

    @Override
    @Transactional
    public Integer createApplication(Application application) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("title", application.getTitle());
        namedParameters.addValue("user_id", application.getUserId());
        namedParameters.addValue("journal_id", application.getJournalId());
        namedParameters.addValue("application_status_id", application.getApplicationStatusId());
        namedParameterJdbcTemplate.update(SQL_CREATE_APPLICATION, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateApplication(Application application) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", application.getId());
        params.put("title", application.getTitle());
        params.put("user_id", application.getUserId());
        params.put("journal_id", application.getJournalId());
        params.put("application_status_id", application.getApplicationStatusId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_APPLICATION, params);
    }

    @Override
    @Transactional
    public void deleteApplication(Integer applicationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", applicationId);
        namedParameterJdbcTemplate.update(SQL_DELETE_APPLICATION, params);
    }

    @Override
    public List<Application> getApplications() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_APPLICATIONS, new ApplicationMapper());
    }
}
