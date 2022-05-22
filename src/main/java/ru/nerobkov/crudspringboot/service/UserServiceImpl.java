package ru.nerobkov.crudspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nerobkov.crudspringboot.dao.UserDao;
import ru.nerobkov.crudspringboot.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public void update(long id, User user) {
        userDao.update(id, user);
    }

}
