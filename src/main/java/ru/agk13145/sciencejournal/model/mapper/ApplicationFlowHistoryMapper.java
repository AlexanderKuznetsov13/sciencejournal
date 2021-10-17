package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.ApplicationFlowHistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ApplicationFlowHistoryMapper implements RowMapper<ApplicationFlowHistory> {
    @Override
    public ApplicationFlowHistory mapRow(ResultSet resultSet, int i) throws SQLException {
        ApplicationFlowHistory applicationFlowHistory = new ApplicationFlowHistory();
        applicationFlowHistory.setId(resultSet.getInt("ID"));
        applicationFlowHistory.setUserId(resultSet.getInt("USER_ID"));
        applicationFlowHistory.setApplicationId(resultSet.getInt("APPLICATION_ID"));
        applicationFlowHistory.setApplicationStatusTypeId(resultSet.getInt("APPLICATION_STATUS_TYPE_ID"));
        applicationFlowHistory.setStatusTypeId(resultSet.getInt("STATUS_TYPE_ID"));
        applicationFlowHistory.setDone(resultSet.getBoolean("IS_DONE"));
        applicationFlowHistory.setCreationDate(resultSet.getObject("CREATION_DATE", LocalDateTime.class));
        applicationFlowHistory.setLastModification(resultSet.getObject("LAST_MODIFICATION", LocalDateTime.class));
        return applicationFlowHistory;
    }
}
