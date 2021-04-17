package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.AuthorByAffiliationDao;
import ru.agk13145.sciencejournal.model.AuthorByAffiliation;
import ru.agk13145.sciencejournal.model.mapper.AuthorByAffiliationMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorByAffiliationDaoImp implements AuthorByAffiliationDao {

    private final static String SQL_SELECT_CONFIG = "SELECT ID, AUTHOR_ID, AFFILIATION_ID, CREATION_DATE, LAST_MODIFICATION FROM sciencejournal.authorsByAffiliations " +
            "WHERE id = :id";

    private final static String SQL_CREATE_CONFIG = "INSERT INTO " +
            "sciencejournal.authorsByAffiliations(author_id, affiliation_id, creation_date, last_modification) VALUES (:author_id, :affiliation_id, now(), now() )";

    private final static String SQL_UPDATE_CONFIG = "UPDATE sciencejournal.authorsByAffiliations " +
            "SET author_id = :author_id, affiliation_id=:affiliation_id, last_modification = now()  WHERE id = :id";

    private final static String SQL_DELETE_CONFIG = "DELETE FROM sciencejournal.authorsByAffiliations WHERE id = :id";

    private final static String SQL_SELECT_ALL_CONFIG = "SELECT ID, AUTHOR_ID, AFFILIATION_ID, CREATION_DATE, LAST_MODIFICATION  FROM sciencejournal.authorsByAffiliations ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public AuthorByAffiliation getAuthorByAffiliation(Integer authorByAffiliationId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", authorByAffiliationId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_CONFIG, paramMap, new AuthorByAffiliationMapper());
    }

    @Override
    @Transactional
    public Integer createAuthorByAffiliation(AuthorByAffiliation authorByAffiliation) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("author_id", authorByAffiliation.getAuthorId());
        namedParameters.addValue("affiliation_id", authorByAffiliation.getAffiliationId());
        namedParameterJdbcTemplate.update(SQL_CREATE_CONFIG, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateAuthorByAffiliation(AuthorByAffiliation authorByAffiliation) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", authorByAffiliation.getId());
        params.put("author_id", authorByAffiliation.getAuthorId());
        params.put("affiliation_id", authorByAffiliation.getAffiliationId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_CONFIG, params);
    }

    @Override
    @Transactional
    public void deleteAuthorByAffiliation(Integer authorByAffiliationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", authorByAffiliationId);
        namedParameterJdbcTemplate.update(SQL_DELETE_CONFIG, params);
    }

    @Override
    public List<AuthorByAffiliation> getAuthorByAffiliations() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_CONFIG, new AuthorByAffiliationMapper());
    }
}
