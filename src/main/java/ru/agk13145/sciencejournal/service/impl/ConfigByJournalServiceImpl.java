package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agk13145.sciencejournal.dao.ConfigByJournalDao;
import ru.agk13145.sciencejournal.model.ConfigByJournal;
import ru.agk13145.sciencejournal.service.ConfigByJournalService;

import java.util.List;

@Service
public class ConfigByJournalServiceImpl implements ConfigByJournalService {

    @Autowired
    ConfigByJournalDao configByJournalDao;

    @Override
    public ConfigByJournal getConfigByJournal(Integer configByJournalId) {
        return configByJournalDao.getConfigByJournal(configByJournalId);
    }

    @Override
    public Integer createConfigByJournal(ConfigByJournal configByJournal) {
        return configByJournalDao.createConfigByJournal(configByJournal);
    }

    @Override
    public void updateConfigByJournal(ConfigByJournal configByJournal) {
        configByJournalDao.updateConfigByJournal(configByJournal);
    }

    @Override
    public void deleteConfigByJournal(Integer configByJournalId) {
        configByJournalDao.deleteConfigByJournal(configByJournalId);
    }

    @Override
    public List<ConfigByJournal> getConfigByJournals() {
        return configByJournalDao.getConfigByJournals();
    }
}
