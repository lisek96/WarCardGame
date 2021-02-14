package service.user;

import repository.user.UserDAO;
import service.utilites.PasswordEncoder;

import javax.inject.Inject;

public class UserService {
    @Inject
    private PasswordEncoder passwordEncoder;
    @Inject
    private UserDAO userDAO;


    String checkAvailabilityAndReturnInfo(String login, String email){



        return "available";
    }


    String checkLoginDataCorrectness(String login, String password){



        return "correct";
    }






}
