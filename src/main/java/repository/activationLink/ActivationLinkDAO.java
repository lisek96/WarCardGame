package repository.activationLink;

import model.ActivationLink;

public interface ActivationLinkDAO {
    void create(ActivationLink activationLink);
    void deleteByToken(String token);
    Integer getIDUserByToken(String token);
}
