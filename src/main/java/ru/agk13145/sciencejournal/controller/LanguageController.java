package ru.agk13145.sciencejournal.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.config.annotation.LoggingController;
import ru.agk13145.sciencejournal.model.Language;
import ru.agk13145.sciencejournal.service.LanguageService;

import java.util.List;

@Controller
@RequestMapping(value = "/languages", produces = "application/json;charset=UTF-8")
public class LanguageController {

    private static Logger logger = LoggerFactory.getLogger(LanguageController.class);

    @Autowired
    private LanguageService languageService;

    @GetMapping
    @ResponseBody
    @LoggingController
    public ResponseEntity<List<Language>> getLanguages() {
        logger.debug("get languages");
        List<Language> languages = languageService.getLanguages();
        return new ResponseEntity<>(languages, HttpStatus.OK);
    }

    @GetMapping(value = "/{languageId}")
    @ResponseBody
    @LoggingController
    public ResponseEntity<Language> getLanguage(@PathVariable Integer languageId) {
        logger.debug("get language - {}", languageId);
        Language language = languageService.getLanguage(languageId);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        logger.debug("create language - {}", language);
        Integer languageId = languageService.createLanguage(language);
        language = languageService.getLanguage(languageId);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @PutMapping(value = "/{languageId}")
    @ResponseBody
    public ResponseEntity<Language> updateLanguage(@PathVariable Integer languageId, @RequestBody Language language) {
        logger.debug("update language - {}", language);
        language.setId(languageId);
        languageService.updateLanguage(language);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{languageId}")
    public ResponseEntity<Integer> deleteLanguage(@PathVariable Integer languageId) {
        logger.debug("delete language - {}", languageId);
        languageService.deleteLanguage(languageId);
        return new ResponseEntity<>(languageId, HttpStatus.OK);
    }

}
