package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agk13145.sciencejournal.dao.AuthorDao;
import ru.agk13145.sciencejournal.model.Author;
import ru.agk13145.sciencejournal.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorDao authorDao;

    @Override
    public Author getAuthor(Integer authorId) {
        return authorDao.getAuthor(authorId);
    }

    @Override
    public Integer createAuthor(Author author) {
        return authorDao.createAuthor(author);
    }

    @Override
    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }

    @Override
    public void deleteAuthor(Integer authorId) {
        authorDao.deleteAuthor(authorId);
    }

    @Override
    public List<Author> getAuthors() {
        return authorDao.getAuthors();
    }
}
