package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.ApplicationStatusType;
import ru.agk13145.sciencejournal.model.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationStatusTypeMapper implements RowMapper<ApplicationStatusType> {

    @Override
    public ApplicationStatusType mapRow(ResultSet resultSet, int i) throws SQLException {
        ApplicationStatusType applicationStatusType = new ApplicationStatusType();
        applicationStatusType.setId(resultSet.getInt("ID"));
        applicationStatusType.setName(resultSet.getString("NAME"));
        applicationStatusType.setDescription(resultSet.getString("DESCRIPTION"));
        return applicationStatusType;
    }
}
