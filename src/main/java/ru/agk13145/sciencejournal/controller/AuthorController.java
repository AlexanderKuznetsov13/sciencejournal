package ru.agk13145.sciencejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.model.Author;
import ru.agk13145.sciencejournal.service.AuthorService;

import java.util.List;

@Controller
@RequestMapping(value = "/authors", produces = "application/json;charset=UTF-8")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Author>> getAuthors() {
        List<Author> authors = authorService.getAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping(value = "/{authorId}")
    @ResponseBody
    public ResponseEntity<Author> getAuthor(@PathVariable Integer authorId) {
        Author author = authorService.getAuthor(authorId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        Integer authorId = authorService.createAuthor(author);
        author = authorService.getAuthor(authorId);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PutMapping(value = "/{authorId}")
    @ResponseBody
    public ResponseEntity<Author> updateAuthor(@PathVariable Integer authorId, @RequestBody Author author) {
        author.setId(authorId);
        authorService.updateAuthor(author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{authorId}")
    public ResponseEntity<Integer> deleteAuthor(@PathVariable Integer authorId) {
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>(authorId, HttpStatus.OK);
    }

}
