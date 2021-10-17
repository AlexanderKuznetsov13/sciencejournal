package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthor(Integer authorId);

    Integer createAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(Integer authorId);

    List<Author> getAuthors();
}
