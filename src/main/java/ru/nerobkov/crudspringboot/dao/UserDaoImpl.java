package ru.nerobkov.crudspringboot.dao;

import org.springframework.stereotype.Repository;
import ru.nerobkov.crudspringboot.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(long id) {
        User user = findById(id);
        entityManager.remove(user);
    }

    @Override
    public void update(long id, User user) {
        User userToBeUpdated = findById(id);
        userToBeUpdated.setName(user.getName());
        userToBeUpdated.setLastName(user.getLastName());
    }
}
