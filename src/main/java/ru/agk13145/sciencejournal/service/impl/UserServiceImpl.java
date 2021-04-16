package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agk13145.sciencejournal.dao.UserDao;
import ru.agk13145.sciencejournal.model.User;
import ru.agk13145.sciencejournal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(Integer userId) {
        return userDao.getUser(userId);
    }
}
