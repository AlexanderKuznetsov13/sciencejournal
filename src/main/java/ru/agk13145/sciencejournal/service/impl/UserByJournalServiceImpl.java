package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.UserByJournalDao;
import ru.agk13145.sciencejournal.model.UserByJournal;
import ru.agk13145.sciencejournal.service.UserByJournalService;

import java.util.List;

@Service
public class UserByJournalServiceImpl implements UserByJournalService {

    @Autowired
    UserByJournalDao userByJournalDao;

    @Override
    public UserByJournal getUserByJournal(Integer userByJournalId) {
        return userByJournalDao.getUserByJournal(userByJournalId);
    }

    @Override
    @Transactional
    public Integer createUserByJournal(UserByJournal userByJournal) {
        return userByJournalDao.createUserByJournal(userByJournal);
    }

    @Override
    @Transactional
    public void updateUserByJournal(UserByJournal userByJournal) {
        userByJournalDao.updateUserByJournal(userByJournal);
    }

    @Override
    @Transactional
    public void deleteUserByJournal(Integer userByJournalId) {
        userByJournalDao.deleteUserByJournal(userByJournalId);
    }

    @Override
    public List<UserByJournal> getUserByJournals() {
        return userByJournalDao.getUserByJournals();
    }
}
