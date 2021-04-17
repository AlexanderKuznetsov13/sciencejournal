package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.AuthorDao;
import ru.agk13145.sciencejournal.model.Author;
import ru.agk13145.sciencejournal.model.mapper.AuthorMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AuthorDaoImp implements AuthorDao {

    private final static String SQL_SELECT_AUTHOR = "SELECT ID, FIRST_NAME, LAST_NAME, MIDDLE_NAME, DATE_OF_BIRTH, ORCID FROM sciencejournal.author " +
            "WHERE id = :id";

    private final static String SQL_CREATE_AUTHOR = "INSERT INTO " +
            "sciencejournal.author(first_name, last_name, middle_name, date_of_birth , orcid) " +
            "VALUES (:first_name,:last_name, :middle_name, :date_of_birth, :orcid)";

    private final static String SQL_UPDATE_AUTHOR = "UPDATE sciencejournal.author " +
            "SET first_name = :first_name, last_name =:last_name, middle_name = :middle_name," +
            "date_of_birth = :date_of_birth, orcid = :orcid WHERE id = :id";

    private final static String SQL_DELETE_AUTHOR = "DELETE FROM sciencejournal.author WHERE id = :id";

    private final static String SQL_SELECT_ALL_AUTHOR = "SELECT ID, FIRST_NAME, LAST_NAME, MIDDLE_NAME, DATE_OF_BIRTH, ORCID  FROM sciencejournal.author ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Author getAuthor(Integer authorId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", authorId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_AUTHOR, paramMap, new AuthorMapper());
    }

    @Override
    @Transactional
    public Integer createAuthor(Author author) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("last_name", author.getLastName());
        namedParameters.addValue("first_name", author.getFirstName());
        namedParameters.addValue("middle_name", author.getMiddleName());
        namedParameters.addValue("date_of_birth", author.getDateOfBirth());
        namedParameters.addValue("orcid", author.getOrcid());
        namedParameterJdbcTemplate.update(SQL_CREATE_AUTHOR, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", author.getId());
        params.put("last_name", author.getLastName());
        params.put("first_name", author.getFirstName());
        params.put("middle_name", author.getMiddleName());
        params.put("date_of_birth", author.getDateOfBirth());
        params.put("orcid", author.getOrcid());
        namedParameterJdbcTemplate.update(SQL_UPDATE_AUTHOR, params);
    }

    @Override
    @Transactional
    public void deleteAuthor(Integer authorId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", authorId);
        namedParameterJdbcTemplate.update(SQL_DELETE_AUTHOR, params);
    }

    @Override
    public List<Author> getAuthors() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_AUTHOR, new AuthorMapper());
    }
}
