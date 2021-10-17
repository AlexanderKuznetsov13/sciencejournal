package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agk13145.sciencejournal.dao.LanguageDao;
import ru.agk13145.sciencejournal.model.Language;
import ru.agk13145.sciencejournal.service.LanguageService;

import java.util.List;

@Service
public class LanguageServiceImp implements LanguageService {

    @Autowired
    LanguageDao languageDao;

    @Override
    public Language getLanguage(Integer languageId) { return languageDao.getLanguage(languageId); }

    @Override
    @Transactional
    public Integer createLanguage(Language language) {
        return languageDao.createLanguage(language);
    }

    @Override
    @Transactional
    public void updateLanguage(Language language) {
        languageDao.updateLanguage(language);
    }

    @Override
    @Transactional
    public void deleteLanguage(Integer languageId) {
        languageDao.deleteLanguage(languageId);
    }

    @Override
    public List<Language> getLanguages() {
        return languageDao.getLanguages();
    }
}
