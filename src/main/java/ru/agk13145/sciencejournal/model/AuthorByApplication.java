package ru.agk13145.sciencejournal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class AuthorByApplication {
    private Integer id;
    private Integer applicationId;
    private Integer authorByAffiliationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getAuthorByAffiliationId() {
        return authorByAffiliationId;
    }

    public void setAuthorByAffiliationId(Integer authorByAffiliationId) {
        this.authorByAffiliationId = authorByAffiliationId;
    }
}
