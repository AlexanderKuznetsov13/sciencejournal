package ru.agk13145.sciencejournal.dao;


import ru.agk13145.sciencejournal.model.Language;

import java.util.List;

public interface LanguageDao {

    Language getLanguage(Integer LanguageId);

    Integer createLanguage(Language language);

    void updateLanguage(Language language);

    void deleteLanguage(Integer LanguageId);

    List<Language> getLanguages();

}
