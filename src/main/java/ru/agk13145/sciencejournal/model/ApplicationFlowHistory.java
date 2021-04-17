package ru.agk13145.sciencejournal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ApplicationFlowHistory {
    private Integer id;
    private Integer userId;
    private Integer applicationId;
    private Integer applicationStatusTypeId;
    private Integer StatusTypeId;
    private Boolean isDone;
    private LocalDateTime creationDate;
    private LocalDateTime lastModification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getApplicationStatusTypeId() {
        return applicationStatusTypeId;
    }

    public void setApplicationStatusTypeId(Integer applicationStatusTypeId) {
        this.applicationStatusTypeId = applicationStatusTypeId;
    }

    public Integer getStatusTypeId() {
        return StatusTypeId;
    }

    public void setStatusTypeId(Integer statusTypeId) {
        StatusTypeId = statusTypeId;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getLastModification() {
        return lastModification;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setLastModification(LocalDateTime lastModification) {
        this.lastModification = lastModification;
    }
}
