package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.Application;

import java.util.List;

public interface ApplicationDao {
    Application getApplication(Integer applicationId);

    Integer createApplication(Application application);

    void updateApplication(Application application);

    void deleteApplication(Integer applicationId);

    List<Application> getApplications();

}
