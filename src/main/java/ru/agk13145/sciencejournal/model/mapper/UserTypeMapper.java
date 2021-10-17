package ru.agk13145.sciencejournal.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.agk13145.sciencejournal.model.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTypeMapper implements RowMapper<UserType> {

    @Override
    public UserType mapRow(ResultSet resultSet, int i) throws SQLException {
        UserType usertype = new UserType();
        usertype.setId(resultSet.getInt("ID"));
        usertype.setName(resultSet.getString("NAME"));
        usertype.setDescription(resultSet.getString("DESCRIPTION"));
        return usertype;
    }
}
