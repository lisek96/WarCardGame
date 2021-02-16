package service.user;

import model.User;
import repository.SQL_Server_DBConnectionProvider;
import repository.user.UserDAO;
import service.activationLink.ActivationLinkService;
import service.utilites.PasswordEncoder;

import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;

public class UserService implements UserServiceInterface{
    @Inject
    private PasswordEncoder passwordEncoder;
    @Inject
    private UserDAO userDAO;
    @Inject
    ActivationLinkService activationLinkService;

    public void registerUser(String login, String password, String email) {
        String[] passwordAndSalt;
        try {
            passwordAndSalt=passwordEncoder.provideEncryptedPasswordAndSalt(password, null);
            User user = new User(login, passwordAndSalt[1], passwordAndSalt[0], email);
            userDAO.create(user);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }


    public String checkAvailabilityAndReturnInfo(String login, String email){
        Integer loginCheck = userDAO.getIDByLogin(login);
        if(loginCheck!=null) return "Login not available, try again";
        Integer emailCheck = userDAO.getIDByEmail(email);
        if(emailCheck!=null) return "Email not available, try again";
        else
            return "available";
    }




    public void activateUser(){

    }






}
