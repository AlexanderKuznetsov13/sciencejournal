package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agk13145.sciencejournal.dao.AffiliationDao;
import ru.agk13145.sciencejournal.model.Affiliation;
import ru.agk13145.sciencejournal.service.AffiliationService;

import java.util.List;

@Service
public class AffiliationServiceImpl implements AffiliationService {

    @Autowired
    AffiliationDao affiliationDao;

    @Override
    public Affiliation getAffiliation(Integer affiliationId) {
        return affiliationDao.getAffiliation(affiliationId);
    }

    @Override
    public Integer createAffiliation(Affiliation affiliation) {
        return affiliationDao.createAffiliation(affiliation);
    }

    @Override
    public void updateAffiliation(Affiliation affiliation) {
        affiliationDao.updateAffiliation(affiliation);
    }

    @Override
    public void deleteAffiliation(Integer affiliationId) {
        affiliationDao.deleteAffiliation(affiliationId);
    }

    @Override
    public List<Affiliation> getAffiliations() {
        return affiliationDao.getAffiliations();
    }
}
