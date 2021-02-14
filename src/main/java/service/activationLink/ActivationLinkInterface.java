package service.activationLink;

public interface ActivationLinkInterface {
    String generateToken();
    void send();
    void create();
    void delete();
}
