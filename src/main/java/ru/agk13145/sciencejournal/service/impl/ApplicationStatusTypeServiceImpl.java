package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agk13145.sciencejournal.dao.ApplicationStatusTypeDao;
import ru.agk13145.sciencejournal.model.ApplicationStatusType;
import ru.agk13145.sciencejournal.service.ApplicationStatusTypeService;

import java.util.List;

@Service
public class ApplicationStatusTypeServiceImpl implements ApplicationStatusTypeService {

    @Autowired
    ApplicationStatusTypeDao applicationStatusTypeDao;

    @Override
    public ApplicationStatusType getApplicationStatusType(Integer applicationStatusTypeId) {
        return applicationStatusTypeDao.getApplicationStatusType(applicationStatusTypeId);
    }

    @Override
    public Integer createApplicationStatusType(ApplicationStatusType applicationStatusType) {
        return applicationStatusTypeDao.createApplicationStatusType(applicationStatusType);
    }

    @Override
    public void updateApplicationStatusType(ApplicationStatusType applicationStatusType) {
        applicationStatusTypeDao.updateApplicationStatusType(applicationStatusType);
    }

    @Override
    public void deleteApplicationStatusType(Integer applicationStatusTypeId) {
        applicationStatusTypeDao.deleteApplicationStatusType(applicationStatusTypeId);
    }

    @Override
    public List<ApplicationStatusType> getApplicationStatusTypes() {
        return applicationStatusTypeDao.getApplicationStatusTypes();
    }
}
