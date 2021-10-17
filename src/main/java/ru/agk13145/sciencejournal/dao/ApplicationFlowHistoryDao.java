package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.ApplicationFlowHistory;

import java.util.List;

public interface ApplicationFlowHistoryDao {
    ApplicationFlowHistory getApplicationFlowHistory(Integer applicationFlowHistoryId);

    Integer createApplicationFlowHistory(ApplicationFlowHistory applicationFlowHistory);

    void updateApplicationFlowHistory(ApplicationFlowHistory applicationFlowHistory);

    void deleteApplicationFlowHistory(Integer applicationFlowHistoryId);

    List<ApplicationFlowHistory> getApplicationFlowHistorys();

}
