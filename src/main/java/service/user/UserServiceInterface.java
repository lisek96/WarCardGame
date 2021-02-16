package service.user;

import model.SessionUser;
import model.User;

import java.security.NoSuchAlgorithmException;

public interface UserServiceInterface {
    String checkAvailabilityAndReturnInfo(String login, String email);
    void registerUser(String login, String password, String email) throws NoSuchAlgorithmException;
    void activateUser();
    String tryToAuthUserAndReturnInfo(String login, String password);
    SessionUser createUserForSessionAfterSuccessfulLogin(String login);
}
