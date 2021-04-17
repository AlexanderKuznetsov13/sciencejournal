package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.JournalDao;
import ru.agk13145.sciencejournal.model.Journal;
import ru.agk13145.sciencejournal.service.JournalService;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    JournalDao journalDao;

    @Override
    public Journal getJournal(Integer journalId) {
        return journalDao.getJournal(journalId);
    }

    @Override
    @Transactional
    public Integer createJournal(Journal journal) {
        return journalDao.createJournal(journal);
    }

    @Override
    @Transactional
    public void updateJournal(Journal journal) {
        journalDao.updateJournal(journal);
    }

    @Override
    @Transactional
    public void deleteJournal(Integer journalId) {
        journalDao.deleteJournal(journalId);
    }

    @Override
    public List<Journal> getJournals() {
        return journalDao.getJournals();
    }
}
