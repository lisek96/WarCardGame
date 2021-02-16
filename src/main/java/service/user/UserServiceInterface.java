package service.user;

import model.User;

import java.security.NoSuchAlgorithmException;

public interface UserServiceInterface {
    String checkAvailabilityAndReturnInfo(String login, String email);
    void registerUser(String login, String password, String email) throws NoSuchAlgorithmException;
    void activateUser();
}
