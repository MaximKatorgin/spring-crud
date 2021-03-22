package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(Long id, String name, int age, long phone) {
        userDao.update(new User(name, age, phone), id);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
