package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.AuthorByAffiliation;

import java.util.List;

public interface AuthorByAffiliationService {
    AuthorByAffiliation getAuthorByAffiliation(Integer authorByAffiliationId);

    Integer createAuthorByAffiliation(AuthorByAffiliation authorByAffiliation);

    void updateAuthorByAffiliation(AuthorByAffiliation authorByAffiliation);

    void deleteAuthorByAffiliation(Integer authorByAffiliationId);

    List<AuthorByAffiliation> getAuthorByAffiliations();
}
