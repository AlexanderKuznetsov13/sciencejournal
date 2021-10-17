package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.Application;
import ru.agk13145.sciencejournal.model.ApplicationWithDetails;

import java.util.List;

public interface ApplicationService {
    Application getApplication(Integer applicationId);

    ApplicationWithDetails getApplicationWithDetails(Integer applicationId);

    Integer createApplication(Application application);

    void updateApplication(Application application);

    void deleteApplication(Integer applicationId);

    List<Application> getApplications();
}
