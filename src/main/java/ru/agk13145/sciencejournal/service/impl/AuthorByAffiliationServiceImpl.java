package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agk13145.sciencejournal.dao.AuthorByAffiliationDao;
import ru.agk13145.sciencejournal.model.AuthorByAffiliation;
import ru.agk13145.sciencejournal.service.AuthorByAffiliationService;

import java.util.List;

public class AuthorByAffiliationServiceImpl implements AuthorByAffiliationService {
    @Autowired
    AuthorByAffiliationDao authorByAffiliationDao;

    @Override
    public AuthorByAffiliation getAuthorByAffiliation(Integer authorByAffiliationId) {
        return authorByAffiliationDao.getAuthorByAffiliation(authorByAffiliationId);
    }

    @Override
    public Integer createAuthorByAffiliation(AuthorByAffiliation authorByAffiliation) {
        return authorByAffiliationDao.createAuthorByAffiliation(authorByAffiliation);
    }

    @Override
    public void updateAuthorByAffiliation(AuthorByAffiliation authorByAffiliation) {
        authorByAffiliationDao.updateAuthorByAffiliation(authorByAffiliation);
    }

    @Override
    public void deleteAuthorByAffiliation(Integer authorByAffiliationId) {
        authorByAffiliationDao.deleteAuthorByAffiliation(authorByAffiliationId);
    }

    @Override
    public List<AuthorByAffiliation> getAuthorByAffiliations() {
        return authorByAffiliationDao.getAuthorByAffiliations();
    }
}
