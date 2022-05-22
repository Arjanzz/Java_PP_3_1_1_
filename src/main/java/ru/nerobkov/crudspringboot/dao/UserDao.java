package ru.nerobkov.crudspringboot.dao;

import ru.nerobkov.crudspringboot.models.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(long id);
    void saveUser(User user);
    void deleteById(long id);
    void update(long id, User user);
}
