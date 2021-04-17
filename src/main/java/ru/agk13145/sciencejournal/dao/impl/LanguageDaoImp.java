package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.LanguageDao;
import ru.agk13145.sciencejournal.model.Language;
import ru.agk13145.sciencejournal.model.mapper.LanguageMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LanguageDaoImp implements LanguageDao {

    private final static String SQL_SELECT_LANGUAGE = "SELECT ID, NAME FROM sciencejournal.languages " +
            "WHERE id = :id";

    private final static String SQL_CREATE_LANGUAGE = "INSERT INTO " +
            "sciencejournal.languages(name) VALUES (:name)";

    private final static String SQL_UPDATE_LANGUAGE = "UPDATE sciencejournal.languages " +
            "SET name = :name WHERE id = :id";

    private final static String SQL_DELETE_LANGUAGE = "DELETE FROM sciencejournal.languages WHERE id = :id";

    private final static String SQL_SELECT_ALL_LANGUAGES = "SELECT ID, NAME FROM sciencejournal.languages ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Language getLanguage(Integer languageId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", languageId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_LANGUAGE, paramMap, new LanguageMapper());
    }

    @Override
    @Transactional
    public Integer createLanguage(Language language) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", language.getName());
        namedParameterJdbcTemplate.update(SQL_CREATE_LANGUAGE, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateLanguage(Language language) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", language.getId());
        params.put("name", language.getName());
        namedParameterJdbcTemplate.update(SQL_UPDATE_LANGUAGE, params);
    }

    @Override
    @Transactional
    public void deleteLanguage(Integer languageId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", languageId);
        namedParameterJdbcTemplate.update(SQL_DELETE_LANGUAGE, params);
    }

    @Override
    public List<Language> getLanguages() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_LANGUAGES, new LanguageMapper());
    }
}
