package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.UserType;

import java.util.List;

public interface UsertypeService {
    UserType getUserType(Integer usertypeId);

    Integer createUserType(UserType usertype);

    void updateUserType(UserType usertype);

    void deleteUserType(Integer usertypeId);

    List<UserType> getUserTypes();
}
