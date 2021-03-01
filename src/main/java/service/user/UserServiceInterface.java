package service.user;

import model.user.SessionUser;
import model.user.Stats;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public interface UserServiceInterface extends Serializable {
    String checkAvailabilityAndReturnInfo(String login, String email);
    void registerUser(String login, String password, String email) throws NoSuchAlgorithmException;
    String tryToAuthUserAndReturnInfo(String login, String password);
    SessionUser createUserForSessionAfterSuccessfulLogin(String login);
    String getEmailByLogin(String login);
    int getRanking(int UserId);
    Stats getStats(int idUser);
    Stats getStats(int wins, int loses);
    void incrementWins(int idUser);
    void incrementLoses(int idUser);
    List<Stats> createRanking(int topUsers) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    void changePassword(int idUser);
    void changeEmail(int idUser);
    void changeLogin(int idUser);
    void changeAvatarPath(int idUser);
    String[] getIdAndEmailByLogin(String login);
}
