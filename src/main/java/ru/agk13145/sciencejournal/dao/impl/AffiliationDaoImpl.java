package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.AffiliationDao;
import ru.agk13145.sciencejournal.model.Affiliation;
import ru.agk13145.sciencejournal.model.mapper.AffiliationMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AffiliationDaoImpl implements AffiliationDao {

    private final static String SQL_SELECT_AFFILIATION = "SELECT ID, NAME FROM sciencejournal.affiliation " +
            "WHERE id = :id";

    private final static String SQL_CREATE_AFFILIATION = "INSERT INTO " +
            "sciencejournal.affiliation(name) VALUES (:name)";

    private final static String SQL_UPDATE_AFFILIATION = "UPDATE sciencejournal.affiliation " +
            "SET name = :name WHERE id = :id";

    private final static String SQL_DELETE_AFFILIATION = "DELETE FROM sciencejournal.affiliation WHERE id = :id";

    private final static String SQL_SELECT_ALL_AFFILIATIONS = "SELECT ID, NAME FROM sciencejournal.affiliation ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Affiliation getAffiliation(Integer affiliationId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", affiliationId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_AFFILIATION, paramMap, new AffiliationMapper());
    }

    @Override
    @Transactional
    public Integer createAffiliation(Affiliation affiliation) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", affiliation.getName());
        namedParameterJdbcTemplate.update(SQL_CREATE_AFFILIATION, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateAffiliation(Affiliation affiliation) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", affiliation.getId());
        params.put("name", affiliation.getName());
        namedParameterJdbcTemplate.update(SQL_UPDATE_AFFILIATION, params);
    }

    @Override
    @Transactional
    public void deleteAffiliation(Integer affiliationId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", affiliationId);
        namedParameterJdbcTemplate.update(SQL_DELETE_AFFILIATION, params);
    }

    @Override
    public List<Affiliation> getAffiliations() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_AFFILIATIONS, new AffiliationMapper());
    }
}
