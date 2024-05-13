package katacademy.userscrud.repository;

import katacademy.userscrud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

public class UserRepositoryImp implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void createUser(User user) {

        entityManager.persist(user);
        entityManager.flush();

    }

    @Override
    @Transactional
    public void updateUser(User user) {

        entityManager.merge(user);
        entityManager.flush();

    }

    @Override
    @Transactional(readOnly = true)
    public User readUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public User deleteUser(long id) {
        User user = readUser(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
        return user;
    }
}
