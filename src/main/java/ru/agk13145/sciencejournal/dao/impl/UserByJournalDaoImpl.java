package ru.agk13145.sciencejournal.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.UserByJournalDao;
import ru.agk13145.sciencejournal.model.UserByJournal;
import ru.agk13145.sciencejournal.model.mapper.UserByJournalMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserByJournalDaoImpl implements UserByJournalDao {

    private final static String SQL_SELECT_USERBYJOURNAL = "SELECT ID, USER_ID, USER_TYPE_ID, JOURNAL_ID FROM sciencejournal.usersbyjournal " +
            "WHERE id = :id";

    private final static String SQL_CREATE_USERBYJOURNAL = "INSERT INTO " +
            "sciencejournal.usersbyjournal(user_id, user_type_id, journal_id) VALUES (:name, :user_id, :user_type_id, :journal_id)";

    private final static String SQL_UPDATE_USERBYJOURNAL = "UPDATE sciencejournal.usersbyjournal " +
            "SET user_id = :user_id, user_type_id = :user_type_id, journal_id = :journal_id  WHERE id = :id";

    private final static String SQL_DELETE_USERBYJOURNAL = "DELETE FROM sciencejournal.usersbyjournal WHERE id = :id";

    private final static String SQL_SELECT_ALL_USERBYJOURNALS = "SELECT ID, USER_ID, USER_TYPE_ID, JOURNAL_ID FROM sciencejournal.usersbyjournal ORDER BY id ASC";


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public UserByJournal getUserByJournal(Integer userByJournalId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", userByJournalId);
        return namedParameterJdbcTemplate.queryForObject(SQL_SELECT_USERBYJOURNAL, paramMap, new UserByJournalMapper());
    }

    @Override
    @Transactional
    public Integer createUserByJournal(UserByJournal userByJournal) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("user_id", userByJournal.getUserId());
        namedParameters.addValue("user_type_id", userByJournal.getUserTypeId());
        namedParameters.addValue("journal_id", userByJournal.getJournalId());
        namedParameterJdbcTemplate.update(SQL_CREATE_USERBYJOURNAL, namedParameters, generatedKeyHolder);
        return (Integer) generatedKeyHolder.getKeys().get("id");
    }

    @Override
    @Transactional
    public void updateUserByJournal(UserByJournal userByJournal) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", userByJournal.getId());
        params.put("user_id", userByJournal.getUserId());
        params.put("user_type_id", userByJournal.getUserTypeId());
        params.put("journal_id", userByJournal.getJournalId());
        namedParameterJdbcTemplate.update(SQL_UPDATE_USERBYJOURNAL, params);
    }

    @Override
    @Transactional
    public void deleteUserByJournal(Integer userByJournalId) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", userByJournalId);
        namedParameterJdbcTemplate.update(SQL_DELETE_USERBYJOURNAL, params);
    }

    @Override
    public List<UserByJournal> getUserByJournals() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL_USERBYJOURNALS, new UserByJournalMapper());
    }
}
