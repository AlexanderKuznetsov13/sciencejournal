package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.Config;

import java.util.List;

public interface ConfigDao {
    Config getConfig(Integer configId);

    Integer createConfig(Config config);

    void updateConfig(Config config);

    void deleteConfig(Integer configId);

    List<Config> getConfigs();

}
