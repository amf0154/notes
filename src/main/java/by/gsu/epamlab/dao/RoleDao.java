package by.gsu.epamlab.dao;

import by.gsu.epamlab.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Gleb on 29.04.2017.
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}
