package repository.activationLink;

import model.activactionLink.ActivationLink;

import java.io.Serializable;

public interface ActivationLinkDAO extends Serializable {
    void create(ActivationLink activationLink);
    void deleteByToken(String token);
    Integer getIDUserByToken(String token);
}
