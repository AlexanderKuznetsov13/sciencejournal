package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.Journal;

import java.util.List;

public interface JournalDao {
    Journal getJournal(Integer journalId);

    Integer createJournal(Journal journal);

    void updateJournal(Journal journal);

    void deleteJournal(Integer journalId);

    List<Journal> getJournals();

}
