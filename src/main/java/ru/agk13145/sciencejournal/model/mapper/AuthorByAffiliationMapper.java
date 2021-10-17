package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.AuthorByAffiliation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AuthorByAffiliationMapper implements RowMapper<AuthorByAffiliation> {
    @Override
    public AuthorByAffiliation mapRow(ResultSet resultSet, int i) throws SQLException {
        AuthorByAffiliation authorByAffiliation = new AuthorByAffiliation();
        authorByAffiliation.setId(resultSet.getInt("ID"));
        authorByAffiliation.setAuthorId(resultSet.getInt("AUTHOR_ID"));
        authorByAffiliation.setAffiliationId(resultSet.getInt("AFFILIATION_ID"));
        authorByAffiliation.setCreationDate(resultSet.getObject("CREATION_DATE", LocalDateTime.class));
        authorByAffiliation.setLastModification(resultSet.getObject("LAST_MODIFICATION", LocalDateTime.class));
        return authorByAffiliation;
    }
}
