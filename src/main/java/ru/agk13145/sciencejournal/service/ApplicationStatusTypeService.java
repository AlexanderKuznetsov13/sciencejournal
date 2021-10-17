package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.ApplicationStatusType;

import java.util.List;

public interface ApplicationStatusTypeService {
    ApplicationStatusType getApplicationStatusType(Integer applicationStatusTypeId);

    Integer createApplicationStatusType(ApplicationStatusType applicationStatusType);

    void updateApplicationStatusType(ApplicationStatusType applicationStatusType);

    void deleteApplicationStatusType(Integer applicationStatusTypeId);

    List<ApplicationStatusType> getApplicationStatusTypes();
}
