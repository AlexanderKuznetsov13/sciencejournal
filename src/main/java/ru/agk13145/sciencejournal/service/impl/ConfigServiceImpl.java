package ru.agk13145.sciencejournal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.agk13145.sciencejournal.dao.ConfigDao;
import ru.agk13145.sciencejournal.model.Config;
import ru.agk13145.sciencejournal.service.ConfigService;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigDao configDao;

    @Override
    public Config getConfig(Integer configId) {
        return configDao.getConfig(configId);
    }

    @Override
    public Integer createConfig(Config config) {
        return configDao.createConfig(config);
    }

    @Override
    public void updateConfig(Config config) {
        configDao.updateConfig(config);
    }

    @Override
    public void deleteConfig(Integer configId) {
        configDao.deleteConfig(configId);
    }

    @Override
    public List<Config> getConfigs() {
        return configDao.getConfigs();
    }
}
