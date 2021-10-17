package ru.agk13145.sciencejournal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ApplicationWithDetails extends Application {
    List<AuthorWithDetails> listAuthors;
    User user;
    Journal journal;
    ApplicationStatusType applicationStatusType;

    public ApplicationStatusType getApplicationStatusType() {
        return applicationStatusType;
    }

    public void setApplicationStatusType(ApplicationStatusType applicationStatusType) {
        this.applicationStatusType = applicationStatusType;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public List<AuthorWithDetails> getListAuthors() {
        return listAuthors;
    }

    public void setListAuthors(List<AuthorWithDetails> listAuthors) {
        this.listAuthors = listAuthors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
