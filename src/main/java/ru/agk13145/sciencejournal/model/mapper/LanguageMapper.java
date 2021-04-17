package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.Language;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageMapper implements RowMapper<Language> {

    @Override
    public Language mapRow(ResultSet resultSet, int i) throws SQLException {
        Language language = new Language();
        language.setId(resultSet.getInt("ID"));
        language.setName(resultSet.getString("NAME"));
        return language;
    }
}
