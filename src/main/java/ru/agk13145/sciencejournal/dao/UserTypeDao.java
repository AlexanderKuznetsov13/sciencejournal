package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.UserType;

import java.util.List;

public interface UserTypeDao {
    UserType getUserType(Integer UsertypeId);

    Integer createUserType(UserType usertype);

    void updateUserType(UserType usertype);

    void deleteUserType(Integer UsertypeId);

    List<UserType> getUserTypes();

}
