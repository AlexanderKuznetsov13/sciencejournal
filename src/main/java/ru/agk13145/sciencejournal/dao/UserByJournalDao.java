package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.UserByJournal;

import java.util.List;

public interface UserByJournalDao {
    UserByJournal getUserByJournal(Integer userByJournalId);

    Integer createUserByJournal(UserByJournal userByJournal);

    void updateUserByJournal(UserByJournal userByJournal);

    void deleteUserByJournal(Integer userByJournalId);

    List<UserByJournal> getUserByJournals();

}
