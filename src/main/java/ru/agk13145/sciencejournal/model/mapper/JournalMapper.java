package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.Journal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalMapper implements RowMapper<Journal> {

    @Override
    public Journal mapRow(ResultSet resultSet, int i) throws SQLException {
        Journal journal = new Journal();
        journal.setId(resultSet.getInt("ID"));
        journal.setName(resultSet.getString("NAME"));
        journal.setTopicId(resultSet.getInt("TOPIC_ID"));
        journal.setLanguageId(resultSet.getInt("LANGUAGE_ID"));
        journal.setIssn(resultSet.getString("ISSN"));
        return journal;
    }
}
