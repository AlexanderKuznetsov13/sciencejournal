package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.Journal;

import java.util.List;

public interface JournalService {
    Journal getJournal(Integer journalId);

    Integer createJournal(Journal journal);

    void updateJournal(Journal journal);

    void deleteJournal(Integer journalId);

    List<Journal> getJournals();
}
