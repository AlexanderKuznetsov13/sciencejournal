package ru.agk13145.sciencejournal.service;

import ru.agk13145.sciencejournal.model.Config;

import java.util.List;

public interface ConfigService {
    Config getConfig(Integer configId);

    Integer createConfig(Config config);

    void updateConfig(Config config);

    void deleteConfig(Integer configId);

    List<Config> getConfigs();
}
