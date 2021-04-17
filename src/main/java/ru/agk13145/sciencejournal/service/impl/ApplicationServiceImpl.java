package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agk13145.sciencejournal.dao.ApplicationDao;
import ru.agk13145.sciencejournal.model.Application;
import ru.agk13145.sciencejournal.service.ApplicationService;

import java.util.List;

public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationDao applicationDao;

    @Override
    public Application getApplication(Integer applicationId) {
        return applicationDao.getApplication(applicationId);
    }

    @Override
    public Integer createApplication(Application application) {
        return applicationDao.createApplication(application);
    }

    @Override
    public void updateApplication(Application application) {
        applicationDao.updateApplication(application);
    }

    @Override
    public void deleteApplication(Integer applicationId) {
        applicationDao.deleteApplication(applicationId);
    }

    @Override
    public List<Application> getApplications() {
        return applicationDao.getApplications();
    }
}
