package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.ConfigByJournal;

import java.util.List;

public interface ConfigByJournalDao {
    ConfigByJournal getConfigByJournal(Integer configByJournalId);

    Integer createConfigByJournal(ConfigByJournal configByJournal);

    void updateConfigByJournal(ConfigByJournal configByJournal);

    void deleteConfigByJournal(Integer configByJournalId);

    List<ConfigByJournal> getConfigByJournals();

}
