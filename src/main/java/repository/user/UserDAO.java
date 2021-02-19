package repository.user;

import model.user.User;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

public interface UserDAO extends Serializable {
    void create(User user);
    Integer getIDByLogin(String login);
    Integer getIDByEmail(String email);
    String getEmailByLogin(String login);
    String getPasswordByLogin(String login);
    String getSaltByLogin(String login);
    void setActivated(boolean status,int id);
    boolean isUserActivated(String login);
}
