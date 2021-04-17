package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.UserByJournal;

import java.util.List;

public interface UserByJournalService {

    UserByJournal getUserByJournal(Integer userByJournalId);

    Integer createUserByJournal(UserByJournal userByJournal);

    void updateUserByJournal(UserByJournal userByJournal);

    void deleteUserByJournal(Integer userByJournalId);

    List<UserByJournal> getUserByJournals();
}
