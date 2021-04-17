package ru.agk13145.sciencejournal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ApplicationWithDetails extends Application {
    List<AuthorWithDetails> listAuthors;

    public List<AuthorWithDetails> getListAuthors() {
        return listAuthors;
    }

    public void setListAuthors(List<AuthorWithDetails> listAuthors) {
        this.listAuthors = listAuthors;
    }
}
