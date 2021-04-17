package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agk13145.sciencejournal.dao.*;
import ru.agk13145.sciencejournal.model.*;
import ru.agk13145.sciencejournal.service.ApplicationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationDao applicationDao;

    @Autowired
    AuthorByApplicationDao authorByApplicationDao;

    @Autowired
    AuthorByAffiliationDao authorByAffiliationDao;

    @Autowired
    AuthorDao authorDao;

    @Autowired
    AffiliationDao affiliationDao;

    @Override
    public Application getApplication(Integer applicationId) {
        return applicationDao.getApplication(applicationId);
    }

    @Override
    public ApplicationWithDetails getApplicationWithDetails(Integer applicationId) {
        Application application = applicationDao.getApplication(applicationId);

        ApplicationWithDetails applicationWithDetails = new ApplicationWithDetails();
        applicationWithDetails.setListAuthors(new ArrayList<>());
        applicationWithDetails.setId(application.getId());
        applicationWithDetails.setTitle(application.getTitle());
        applicationWithDetails.setJournalId(application.getJournalId());
        applicationWithDetails.setUserId(application.getUserId());
        applicationWithDetails.setCreationDate(application.getCreationDate());
        applicationWithDetails.setLastModification(application.getLastModification());
        applicationWithDetails.setApplicationStatusId(application.getApplicationStatusId());

        List<AuthorWithDetails> listOfAuthors = new ArrayList<>();
        List<AuthorByApplication> listOfAuthorsByAffiliation = authorByApplicationDao.findByApplicationId(applicationId);

        for (AuthorByApplication item: listOfAuthorsByAffiliation) {
            AuthorByAffiliation authorByAffiliation = authorByAffiliationDao.getAuthorByAffiliation(item.getAuthorByAffiliationId());
            Author author = authorDao.getAuthor(authorByAffiliation.getAuthorId());
            Affiliation affiliation = affiliationDao.getAffiliation(authorByAffiliation.getAffiliationId());

            AuthorWithDetails authorWithDetails = new AuthorWithDetails();
            authorWithDetails.setId(author.getId());
            authorWithDetails.setFirstName(author.getFirstName());
            authorWithDetails.setLastName(author.getLastName());
            authorWithDetails.setMiddleName(author.getMiddleName());
            authorWithDetails.setDateOfBirth(author.getDateOfBirth());
            authorWithDetails.setOrcid(author.getOrcid());

            authorWithDetails.setAffiliation(affiliation);
            listOfAuthors.add(authorWithDetails);
        }

        applicationWithDetails.setListAuthors(listOfAuthors);

        return applicationWithDetails;
    }

    @Override
    public Integer createApplication(Application application) {
        return applicationDao.createApplication(application);
    }

    @Override
    public void updateApplication(Application application) {
        applicationDao.updateApplication(application);
    }

    @Override
    public void deleteApplication(Integer applicationId) {
        applicationDao.deleteApplication(applicationId);
    }

    @Override
    public List<Application> getApplications() {
        return applicationDao.getApplications();
    }
}
