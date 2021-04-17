package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.AuthorByApplication;

import java.util.List;

public interface AuthorByApplicationService {
    AuthorByApplication getAuthorByApplication(Integer authorByApplicationId);

    Integer createAuthorByApplication(AuthorByApplication authorByApplication);

    void updateAuthorByApplication(AuthorByApplication authorByApplication);

    void deleteAuthorByApplication(Integer authorByApplicationId);

    List<AuthorByApplication> getAuthorByApplications();
}
