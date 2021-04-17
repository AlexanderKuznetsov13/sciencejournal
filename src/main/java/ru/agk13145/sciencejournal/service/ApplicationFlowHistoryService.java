package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.ApplicationFlowHistory;

import java.util.List;

public interface ApplicationFlowHistoryService {
    ApplicationFlowHistory getApplicationFlowHistory(Integer applicationFlowHistoryId);

    Integer createApplicationFlowHistory(ApplicationFlowHistory applicationFlowHistory);

    void updateApplicationFlowHistory(ApplicationFlowHistory applicationFlowHistory);

    void deleteApplicationFlowHistory(Integer applicationFlowHistoryId);

    List<ApplicationFlowHistory> getApplicationFlowHistorys();
}
