package model.activactionLink;

public class ActivationLink {
    long idLink;
    long idUser;
    String token;
    String expirationDate;
    public ActivationLink(long idUser, String token, String expirationDate) {
        this.idUser = idUser;
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public long getIdLink() {
        return idLink;
    }

    public void setIdLink(long idLink) {
        this.idLink = idLink;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
