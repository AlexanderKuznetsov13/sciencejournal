package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.Affiliation;
import ru.agk13145.sciencejournal.model.ApplicationStatusType;
import ru.agk13145.sciencejournal.model.Author;

import java.util.List;

public interface ApplicationStatusTypeDao {
    ApplicationStatusType getApplicationStatusType(Integer applicationStatusTypeId);

    Integer createApplicationStatusType(ApplicationStatusType applicationStatusType);

    void updateApplicationStatusType(ApplicationStatusType applicationStatusType);

    void deleteApplicationStatusType(Integer applicationStatusTypeId);

    List<ApplicationStatusType> getApplicationStatusTypes();
}
