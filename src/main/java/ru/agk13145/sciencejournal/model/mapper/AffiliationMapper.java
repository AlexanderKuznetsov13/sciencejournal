package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.Affiliation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AffiliationMapper implements RowMapper<Affiliation> {
    @Override
    public Affiliation mapRow(ResultSet resultSet, int i) throws SQLException {
        Affiliation affiliation = new Affiliation();
        affiliation.setId(resultSet.getInt("ID"));
        affiliation.setName(resultSet.getString("NAME"));
        return affiliation;
    }
}
