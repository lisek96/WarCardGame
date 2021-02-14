package repository.user;

import model.User;

public interface UserDAO {
    void create(User user);
    Integer getIDByLogin(String login);
    Integer getIDByEmail(String email);
    String getPasswordByLogin(String login);
    String getSaltByLogin(String login);
    void setActivated(boolean status, long id);
}
