package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.ConfigByJournal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigByJournalMapper implements RowMapper<ConfigByJournal> {

    @Override
    public ConfigByJournal mapRow(ResultSet resultSet, int i) throws SQLException {
        ConfigByJournal configByJournal = new ConfigByJournal();
        configByJournal.setId(resultSet.getInt("ID"));
        configByJournal.setConfigId(resultSet.getInt("CONFIG_ID"));
        configByJournal.setJournalId(resultSet.getInt("JOURNAL_ID"));
        configByJournal.setValue(resultSet.getString("VALUE"));
        return configByJournal;
    }
}
