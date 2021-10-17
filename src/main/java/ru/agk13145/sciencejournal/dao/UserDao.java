package ru.agk13145.sciencejournal.dao;

import ru.agk13145.sciencejournal.model.User;

public interface UserDao {

    /**
     * Получение пользователя по идентификатору
     *
     * @return пользователя
     */
    User getUser(Integer userId);


}
