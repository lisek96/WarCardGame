package service.user;

import model.user.SessionUser;
import model.user.Stats;
import model.user.User;
import repository.user.UserDAO;
import service.activationLink.ActivationLinkInterface;
import service.utilites.Helper;
import service.utilites.PasswordEncoder;
import service.utilites.ThrowingComparator;

import javax.inject.Inject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    @Override
    public int getRanking(int idUser) {
        int[] winsAndLoses = userDAO.getWinsAndLoses(idUser);
        int wins=winsAndLoses[0], loses=winsAndLoses[1];
        return evaluateRanking(wins, loses);
    }

    @Override
    public Stats getStats(int idUser) {
        int[] winsAndLoses = userDAO.getWinsAndLoses(idUser);
        int wins=winsAndLoses[0], loses=winsAndLoses[1];
        int ranking=evaluateRanking(wins, loses), matches = evaluateNumberOfMatches(wins, loses);
        double winPercentage = evaluateWinPercentage(wins, loses);
        return new Stats(wins, loses, matches, winPercentage, ranking);
    }
    @Override
    public Stats getStats(int wins, int loses) {
        int ranking=evaluateRanking(wins, loses), matches = evaluateNumberOfMatches(wins, loses);
        double winPercentage = evaluateWinPercentage(wins, loses);
        return new Stats(wins, loses, matches, winPercentage, ranking);
    }

    @Override
    public void incrementWins(int idUser) {
        userDAO.incrementWins(idUser);
    }

    @Override
    public void incrementLoses(int idUser) {
        userDAO.incrementLoses(idUser);
    }

    @Override
    public List<Stats> createRanking(int topUsers) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ResultSet rs = userDAO.getLoginWinsLosesOfUsers(topUsers);
        List<List<String>> listOfRows = Helper.getAllRowsFromResultSetIntoStringList(rs, 3);
        List<Stats> listOfStats = loginWinsLosesToStats(listOfRows);
        List<Stats> sortedListByRanking = sortListOfStatsByStatsAttribute("Ranking", listOfStats);


        return null;
    }

    public List<Stats> sortListOfStatsByStatsAttribute(String statsArg, List<Stats> listOfStats) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = Stats.class.getMethod("get"+statsArg);
        List<Stats> listOfStatsDuplicate = new ArrayList<>(listOfStats);
        Collections.sort(listOfStatsDuplicate, (ThrowingComparator<Stats>) (s1, s2) -> (int) m.invoke(s2) - (int) m.invoke(s1));
        return listOfStatsDuplicate;
    }


    private List<Stats> loginWinsLosesToStats(List<List<String>> list){
        List<Stats> statsList = new ArrayList<>();

        for(List<String> innerList : list){
            Stats stats = getStats(Integer.parseInt(innerList.get(1)), Integer.parseInt(innerList.get(2)));
            stats.setLogin(innerList.get(0));
            statsList.add(stats);
        }
        return statsList;
    }


    private int evaluateRanking(int wins, int loses){
        return 1500+((wins-loses)*25);
    }

    private double evaluateWinPercentage(int wins, int loses){
        return wins/(wins+loses);
    }

    private int evaluateNumberOfMatches(int wins ,int loses){
        return wins+loses;
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
