package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.UserByJournal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserByJournalMapper implements RowMapper<UserByJournal> {

    @Override
    public UserByJournal mapRow(ResultSet resultSet, int i) throws SQLException {
        UserByJournal userByJournal = new UserByJournal();
        userByJournal.setId(resultSet.getInt("ID"));
        userByJournal.setUserId(resultSet.getInt("USER_ID"));
        userByJournal.setUserTypeId(resultSet.getInt("USER_TYPE_ID"));
        userByJournal.setJournalId(resultSet.getInt("JOURNAL_ID"));
        return userByJournal;
    }
}
