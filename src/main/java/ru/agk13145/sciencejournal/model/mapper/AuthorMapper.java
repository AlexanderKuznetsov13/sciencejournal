package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.Affiliation;
import ru.agk13145.sciencejournal.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {
        Author author = new Author();
        author.setId(resultSet.getInt("ID"));
        author.setFirstName(resultSet.getString("FIRST_NAME"));
        author.setLastName(resultSet.getString("LAST_NAME"));
        author.setMiddleName(resultSet.getString("MIDDLE_NAME"));
        author.setDateOfBirth(resultSet.getObject("DATE_OF_BIRTH", LocalDateTime.class));
        author.setOrcid(resultSet.getString("ORCID"));
        return author;
    }
}
