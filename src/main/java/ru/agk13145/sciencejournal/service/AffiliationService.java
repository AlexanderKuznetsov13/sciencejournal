package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.Affiliation;

import java.util.List;

public interface AffiliationService {
    Affiliation getAffiliation(Integer affiliationId);

    Integer createAffiliation(Affiliation affiliation);

    void updateAffiliation(Affiliation affiliation);

    void deleteAffiliation(Integer affiliationId);

    List<Affiliation> getAffiliations();
}
