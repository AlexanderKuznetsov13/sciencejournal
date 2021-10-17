package ru.agk13145.sciencejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.model.Journal;
import ru.agk13145.sciencejournal.service.JournalService;

import java.util.List;

@Controller
@RequestMapping(value = "/journals", produces = "application/json;charset=UTF-8")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Journal>> getJournals() {
        List<Journal> journals = journalService.getJournals();
        return new ResponseEntity<>(journals, HttpStatus.OK);
    }

    @GetMapping(value = "/{journalId}")
    @ResponseBody
    public ResponseEntity<Journal> getJournal(@PathVariable Integer journalId) {
        Journal journal = journalService.getJournal(journalId);
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Journal> createJournal(@RequestBody Journal journal) {
        Integer journalId = journalService.createJournal(journal);
        journal = journalService.getJournal(journalId);
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }

    @PutMapping(value = "/{journalId}")
    @ResponseBody
    public ResponseEntity<Journal> updateJournal(@PathVariable Integer journalId, @RequestBody Journal journal) {
        journal.setId(journalId);
        journalService.updateJournal(journal);
        return new ResponseEntity<>(journal, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{journalId}")
    public ResponseEntity<Integer> deleteJournal(@PathVariable Integer journalId) {
        journalService.deleteJournal(journalId);
        return new ResponseEntity<>(journalId, HttpStatus.OK);
    }

}
