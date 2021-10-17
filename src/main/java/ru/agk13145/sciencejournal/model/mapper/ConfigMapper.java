package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.Config;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigMapper implements RowMapper<Config> {

    @Override
    public Config mapRow(ResultSet resultSet, int i) throws SQLException {
        Config config = new Config();
        config.setId(resultSet.getInt("ID"));
        config.setName(resultSet.getString("NAME"));
        config.setDescription(resultSet.getString("DESCRIPTION"));
        return config;
    }
}
