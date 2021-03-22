package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(Long id, String name, int age, long phone);
    void deleteById(Long id);
    List<User> listUsers();
}
