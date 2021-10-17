package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.ApplicationStatusTypeDao;
import ru.agk13145.sciencejournal.model.ApplicationStatusType;
import ru.agk13145.sciencejournal.model.mapper.ApplicationStatusTypeMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ApplicationStatusTypeDaoImp implements ApplicationStatusTypeDao {

    private final static String SQL_SELECT_APPLICATIONSTATUSTYPE = "SELECT ID, NAME, DESCRIPTION FROM sciencejournal.applicationstatustypes " +
            "WHERE id = :id";

    private final static String SQL_CREATE_APPLICATIONSTATUSTYPE = "INSERT INTO " +
            "sciencejournal.ApplicationStatusTypes(name, description) VALUES (:name,:description )";

    private final static String SQL_UPDATE_APPLICATIONSTATUSTYPE = "UPDATE sciencejournal.applicationstatustypes " +
            "SET name = :name, description=:description WHERE id = :id";

    private final static String SQL_DELETE_APPLICATIONSTATUSTYPE = "DELETE FROM sciencejournal.applicationstatustypes WHERE id = :id";

    private final static String SQL_SELECT_ALL_APPLICATIONSTATUSTYPE = "SELECT ID, NAME, DESCRIPTION  FROM sciencejournal.applicationstatustypes ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public ApplicationStatusType getApplicationStatusType(Integer applicationStatusTypeId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", applicationStatusTypeId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_APPLICATIONSTATUSTYPE, paramMap, new ApplicationStatusTypeMapper());
    }

    @Override
    @Transactional
    public Integer createApplicationStatusType(ApplicationStatusType applicationStatusType) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", applicationStatusType.getName());
        namedParameters.addValue("description", applicationStatusType.getDescription());
        namedParameterJdbcTemplate.update(SQL_CREATE_APPLICATIONSTATUSTYPE, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateApplicationStatusType(ApplicationStatusType applicationStatusType) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", applicationStatusType.getId());
        params.put("name", applicationStatusType.getName());
        params.put("description", applicationStatusType.getDescription());
        namedParameterJdbcTemplate.update(SQL_UPDATE_APPLICATIONSTATUSTYPE, params);
    }

    @Override
    @Transactional
    public void deleteApplicationStatusType(Integer applicationStatusTypeId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", applicationStatusTypeId);
        namedParameterJdbcTemplate.update(SQL_DELETE_APPLICATIONSTATUSTYPE, params);
    }

    @Override
    public List<ApplicationStatusType> getApplicationStatusTypes() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_APPLICATIONSTATUSTYPE, new ApplicationStatusTypeMapper());
    }
}
