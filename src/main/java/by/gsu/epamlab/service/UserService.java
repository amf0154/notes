package by.gsu.epamlab.service;

import by.gsu.epamlab.model.User;

/**
 * Created by Gleb on 30.04.2017.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
