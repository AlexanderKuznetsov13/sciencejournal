package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.AuthorByApplicationDao;
import ru.agk13145.sciencejournal.model.AuthorByApplication;
import ru.agk13145.sciencejournal.model.mapper.AuthorByApplicationMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorByApplicationDaoImp implements AuthorByApplicationDao {

    private final static String SQL_SELECT_AUTHORBYAPPLICATION = "SELECT ID, APPLICATION_ID, AUTHOR_BY_AFFILIATION_ID FROM sciencejournal.authorbyapplication " +
            "WHERE id = :id";

    private final static String SQL_CREATE_AUTHORBYAPPLICATION = "INSERT INTO " +
            "sciencejournal.authorbyapplication(application_id, author_by_affiliation_id) VALUES (:application_id, :author_by_affiliation_id)";

    private final static String SQL_UPDATE_AUTHORBYAPPLICATION = "UPDATE sciencejournal.authorbyapplication " +
            "SET application_id = :application_id, author_by_affiliation_id=:author_by_affiliation_id WHERE id = :id";

    private final static String SQL_DELETE_AUTHORBYAPPLICATION = "DELETE FROM sciencejournal.authorbyapplication WHERE id = :id";

    private final static String SQL_SELECT_ALL_AUTHORBYAPPLICATION = "SELECT ID, APPLICATION_ID, AUTHOR_BY_AFFILIATION_ID  FROM sciencejournal.authorbyapplication ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public AuthorByApplication getAuthorByApplication(Integer authorByApplicationId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", authorByApplicationId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_AUTHORBYAPPLICATION, paramMap, new AuthorByApplicationMapper());
    }

    @Override
    @Transactional
    public Integer createAuthorByApplication(AuthorByApplication authorByApplication) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("application_id", authorByApplication.getApplicationId());
        namedParameters.addValue("author_by_affiliation_id", authorByApplication.getAuthorByAffiliationId());
        namedParameterJdbcTemplate.update(SQL_CREATE_AUTHORBYAPPLICATION, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateAuthorByApplication(AuthorByApplication authorByApplication) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", authorByApplication.getId());
        params.put("application_id", authorByApplication.getApplicationId());
        params.put("author_by_affiliation_id", authorByApplication.getAuthorByAffiliationId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_AUTHORBYAPPLICATION, params);
    }

    @Override
    @Transactional
    public void deleteAuthorByApplication(Integer authorByApplicationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", authorByApplicationId);
        namedParameterJdbcTemplate.update(SQL_DELETE_AUTHORBYAPPLICATION, params);
    }

    @Override
    public List<AuthorByApplication> getAuthorByApplications() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_AUTHORBYAPPLICATION, new AuthorByApplicationMapper());
    }
}
