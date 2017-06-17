package by.gsu.epamlab.service;

/**
 * Created by Gleb on 29.04.2017.
 */
public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String password);
}
