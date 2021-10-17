package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.Language;

import java.util.List;

public interface LanguageService {
    Language getLanguage(Integer languageId);

    Integer createLanguage(Language language);

    void updateLanguage(Language language);

    void deleteLanguage(Integer languagecId);

    List<Language> getLanguages();
}
