package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.Affiliation;

import java.util.List;

public interface AffiliationDao {
    Affiliation getAffiliation(Integer affiliationId);

    Integer createAffiliation(Affiliation affiliation);

    void updateAffiliation(Affiliation affiliation);

    void deleteAffiliation(Integer affiliationId);

    List<Affiliation> getAffiliations();

}
