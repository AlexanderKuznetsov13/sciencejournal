package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.ApplicationFlowHistoryDao;
import ru.agk13145.sciencejournal.model.ApplicationFlowHistory;
import ru.agk13145.sciencejournal.service.ApplicationFlowHistoryService;

import java.util.List;

@Service
public class ApplicationFlowHistoryServiceImpl implements ApplicationFlowHistoryService {
    @Autowired
    ApplicationFlowHistoryDao applicationFlowHistoryDao;

    @Override
    public ApplicationFlowHistory getApplicationFlowHistory(Integer applicationFlowHistoryId) {
        return applicationFlowHistoryDao.getApplicationFlowHistory(applicationFlowHistoryId);
    }

    @Override
    @Transactional
    public Integer createApplicationFlowHistory(ApplicationFlowHistory applicationFlowHistory) {
        return applicationFlowHistoryDao.createApplicationFlowHistory(applicationFlowHistory);
    }

    @Override
    @Transactional
    public void updateApplicationFlowHistory(ApplicationFlowHistory applicationFlowHistory) {
        applicationFlowHistoryDao.updateApplicationFlowHistory(applicationFlowHistory);
    }

    @Override
    @Transactional
    public void deleteApplicationFlowHistory(Integer applicationFlowHistoryId) {
        applicationFlowHistoryDao.deleteApplicationFlowHistory(applicationFlowHistoryId);
    }

    @Override
    public List<ApplicationFlowHistory> getApplicationFlowHistorys() {
        return applicationFlowHistoryDao.getApplicationFlowHistorys();
    }
}
