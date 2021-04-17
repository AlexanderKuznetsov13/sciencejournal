package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.AuthorByApplication;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorByApplicationMapper implements RowMapper<AuthorByApplication> {
    @Override
    public AuthorByApplication mapRow(ResultSet resultSet, int i) throws SQLException {
        AuthorByApplication authorByApplication = new AuthorByApplication();
        authorByApplication.setId(resultSet.getInt("ID"));
        authorByApplication.setApplicationId(resultSet.getInt("APPLICATION_ID"));
        authorByApplication.setAuthorByAffiliationId(resultSet.getInt("AUTHORS_BY_AFFILIATION_ID"));
        return authorByApplication;
    }
}
