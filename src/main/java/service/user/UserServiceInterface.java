package service.user;

import model.user.SessionUser;
import model.user.Stats;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

public interface UserServiceInterface extends Serializable {
    String checkAvailabilityAndReturnInfo(String login, String email);
    void registerUser(String login, String password, String email) throws NoSuchAlgorithmException;
    String tryToAuthUserAndReturnInfo(String login, String password);
    SessionUser createUserForSessionAfterSuccessfulLogin(String login);
    int getRanking(int UserId);
    Stats getStats(int idUser);
    void incrementWins(int idUser);
    void incrementLoses(int idUser);
}
