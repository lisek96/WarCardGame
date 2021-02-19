package service.activationLink;

import model.user.User;

import java.io.Serializable;

public interface ActivationLinkInterface extends Serializable {
    String generateToken();
    void send(String toEmail, String token);
    void createAndSend(User user);
    String actOnCall(String token);
    void delete(String token);
}
