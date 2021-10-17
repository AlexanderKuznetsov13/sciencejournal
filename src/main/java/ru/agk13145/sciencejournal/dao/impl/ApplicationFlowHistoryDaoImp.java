package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.ApplicationFlowHistoryDao;
import ru.agk13145.sciencejournal.model.ApplicationFlowHistory;
import ru.agk13145.sciencejournal.model.mapper.ApplicationFlowHistoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ApplicationFlowHistoryDaoImp implements ApplicationFlowHistoryDao {

    private final static String SQL_SELECT_APPLICATIONFLOWHISTORY = "SELECT ID, USER_ID, APPLICATION_ID, APPLICATION_STATUS_ID, IS_DONE, CREATION_DATE, LAST_MODIFICATION FROM sciencejournal.applicationFlowHistory " +
            "WHERE id = :id";

    private final static String SQL_CREATE_APPLICATIONFLOWHISTORY = "INSERT INTO " +
            "sciencejournal.applicationFlowHistory(user_id, application_id, application_status_id, is_done, creation_date, last_modification) VALUES (:user_id, :application_id, :application_status_id, :is_done, now(), now())";

    private final static String SQL_UPDATE_APPLICATIONFLOWHISTORY = "UPDATE sciencejournal.applicationFlowHistory " +
            "SET user_id = :user_id, application_id=:application_id, application_status_id = :application_status_id, is_done=:is_done, last_modification=now() WHERE id = :id";

    private final static String SQL_DELETE_APPLICATIONFLOWHISTORY = "DELETE FROM sciencejournal.applicationFlowHistory WHERE id = :id";

    private final static String SQL_SELECT_ALL_APPLICATIONFLOWHISTORY = "SELECT ID, USER_ID, APPLICATION_ID, APPLICATION_STATUS_ID, IS_DONE, CREATION_DATE, LAST_MODIFICATION  FROM sciencejournal.applicationFlowHistory ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public ApplicationFlowHistory getApplicationFlowHistory(Integer applicationFlowHistoryId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", applicationFlowHistoryId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_APPLICATIONFLOWHISTORY, paramMap, new ApplicationFlowHistoryMapper());
    }

    @Override
    @Transactional
    public Integer createApplicationFlowHistory(ApplicationFlowHistory applicationFlowHistory) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("user_id", applicationFlowHistory.getUserId());
        namedParameters.addValue("application_id", applicationFlowHistory.getApplicationId());
        namedParameters.addValue("application_status_id", applicationFlowHistory.getApplicationStatusTypeId());
        namedParameters.addValue("is_done", applicationFlowHistory.getDone());
        namedParameterJdbcTemplate.update(SQL_CREATE_APPLICATIONFLOWHISTORY, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateApplicationFlowHistory(ApplicationFlowHistory applicationFlowHistory) {
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", applicationFlowHistory.getUserId());
        params.put("application_id", applicationFlowHistory.getApplicationId());
        params.put("application_status_id", applicationFlowHistory.getApplicationStatusTypeId());
        params.put("is_done", applicationFlowHistory.getDone());
        namedParameterJdbcTemplate.update(SQL_UPDATE_APPLICATIONFLOWHISTORY, params);
    }

    @Override
    @Transactional
    public void deleteApplicationFlowHistory(Integer applicationFlowHistoryId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", applicationFlowHistoryId);
        namedParameterJdbcTemplate.update(SQL_DELETE_APPLICATIONFLOWHISTORY, params);
    }

    @Override
    public List<ApplicationFlowHistory> getApplicationFlowHistorys() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_APPLICATIONFLOWHISTORY, new ApplicationFlowHistoryMapper());
    }
}
