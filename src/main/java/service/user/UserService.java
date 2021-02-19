package service.user;

import model.activactionLink.ActivationLink;
import model.user.SessionUser;
import model.user.User;
import repository.user.UserDAO;
import service.activationLink.ActivationLinkInterface;
import service.activationLink.ActivationLinkService;
import service.utilites.PasswordEncoder;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

public class UserService implements UserServiceInterface {
    @Inject
    private PasswordEncoder passwordEncoder;
    @Inject
    private UserDAO userDAO;
    @Inject
    ActivationLinkInterface activationLinkInterface;

    @Override
    public void registerUser(String login, String password, String email) {
        String[] passwordAndSalt;
        try {
            passwordAndSalt = passwordEncoder.provideEncryptedPasswordAndSalt(password, null);
            User user = new User(login, passwordAndSalt[1], passwordAndSalt[0], email);
            userDAO.create(user);
            activationLinkInterface.createAndSend(user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String checkAvailabilityAndReturnInfo(String login, String email) {
        Integer loginCheck = userDAO.getIDByLogin(login);
        if (loginCheck != null) return "Login not available, try again";
        Integer emailCheck = userDAO.getIDByEmail(email);
        if (emailCheck != null) return "Email not available, try again";
        else
            return "available";
    }

    @Override
    public String tryToAuthUserAndReturnInfo(String login, String inputPassword) {
        Integer loginCheck = userDAO.getIDByLogin(login);

        if (loginCheck == null) return "Login doesn't exists, try again";

        String hashedPassword = userDAO.getPasswordByLogin(login);
        String salt = userDAO.getSaltByLogin(login);
        boolean isPasswordCorrect = validateUserPassword(hashedPassword, salt, inputPassword);

        if (isPasswordCorrect == false) return "Wrong password, try again";
        if (userDAO.isUserActivated(login) == false) return "This account is not activated. Activate your account.";
        return "authed";
    }

    public SessionUser createUserForSessionAfterSuccessfulLogin(String login) {
        String email = userDAO.getEmailByLogin(login);
        Integer id = userDAO.getIDByLogin(login);
        SessionUser sessionUser = new SessionUser(id, login, email);
        return sessionUser;
    }

    private boolean validateUserPassword(String hashedPassword, String salt, String inputPassword) {
        try {
            String[] encryptedPasswordAndSalt = passwordEncoder.provideEncryptedPasswordAndSalt(inputPassword, salt);
            if (encryptedPasswordAndSalt[0].equals(hashedPassword)) return true;
            else return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }


}
