package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.User;

public interface UserDao {

    /**
     * Получение валюты по идентификатору
     *
     * @return валюту
     */
    User getUser(Integer userId);


}
