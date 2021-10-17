package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.UserTypeDao;
import ru.agk13145.sciencejournal.model.UserType;
import ru.agk13145.sciencejournal.service.UserTypeService;

import java.util.List;

@Service
public class UserTypesServiceImp implements UserTypeService {

    @Autowired
    UserTypeDao usertypeDao;

    @Override
    public UserType getUserType(Integer usertypeId) {
        return usertypeDao.getUserType(usertypeId);
    }

    @Override
    @Transactional
    public Integer createUserType(UserType usertype) {
        return usertypeDao.createUserType(usertype);
    }

    @Override
    @Transactional
    public void updateUserType(UserType usertype) {
        usertypeDao.updateUserType(usertype);
    }

    @Override
    @Transactional
    public void deleteUserType(Integer usertypeId) {
        usertypeDao.deleteUserType(usertypeId);
    }


    @Override
    public List<UserType> getUserTypes() {
        return usertypeDao.getUserTypes();
    }
}
