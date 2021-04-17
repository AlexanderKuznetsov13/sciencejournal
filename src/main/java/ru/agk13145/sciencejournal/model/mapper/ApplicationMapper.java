package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.Application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ApplicationMapper implements RowMapper<Application> {
    @Override
    public Application mapRow(ResultSet resultSet, int i) throws SQLException {
        Application application = new Application();
        application.setId(resultSet.getInt("ID"));
        application.setTitle(resultSet.getString("TITLE"));
        application.setUserId(resultSet.getInt("TITLE"));
        application.setJournalId(resultSet.getInt("JOURNAL_ID"));
        application.setCreationDate(resultSet.getObject("CREATION_DATE", LocalDateTime.class));
        application.setLastModification(resultSet.getObject("LAST_MODIFICATION_DATE", LocalDateTime.class));
        return application;
    }
}
