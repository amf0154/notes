package by.gsu.epamlab.dao;

import by.gsu.epamlab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Gleb on 29.04.2017.
 */
public interface UserDao extends JpaRepository<User, Long>{
    User findByUsername(String username);

}
