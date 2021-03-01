package repository.user;

import model.user.Stats;
import model.user.User;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public interface UserDAO extends Serializable {
    void create(User user);
    Integer getIDByLogin(String login);
    Integer getIDByEmail(String email);
    String[] getIdAndEmailByLogin(String login);
    String getEmailByLogin(String login);
    String getPasswordByLogin(String login);
    String getSaltByLogin(String login);
    void setActivated(boolean status,int id);
    boolean isUserActivated(String login);
    int[] getWinsAndLoses(int UserId);
    void incrementWins(int idUser);
    void incrementLoses(int idUser);
    List<List<String>> getLoginWinsLosesOfUsers(int howMany);
}
