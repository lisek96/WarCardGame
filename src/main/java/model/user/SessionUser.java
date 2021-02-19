package model.user;

public class SessionUser {
    private long id;
    private String login;
    private String email;

    public SessionUser(long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
