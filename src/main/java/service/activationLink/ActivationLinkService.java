package service.activationLink;


import model.activactionLink.ActivationLink;
import model.user.User;
import repository.activationLink.ActivationLinkDAO;
import repository.user.UserDAO;
import service.utilites.MailService;
import javax.inject.Inject;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.time.LocalDate;
import java.util.Properties;
import java.util.UUID;


public class ActivationLinkService implements ActivationLinkInterface {
    @Inject
    UserDAO userDAO;
    @Inject
    ActivationLinkDAO activationLinkDAO;

    @Override
    public String generateToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void send(String toEmail, String token) {
        final String fromEmail = "warcardgame.activation@gmail.com";
        final String password = "warcardgame";
        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
        MailService.sendEmail(session, toEmail, "Activation from WCG",
                "<p><a href=\"http://localhost:8080/WarCardGame_war_exploded/activate/" +
                        token + "\">Click to activate your account.</a></p>");
    }

    @Override
    public void createAndSend(User user) {
        String token = generateToken();
        long idUser = userDAO.getIDByLogin(user.getLogin());
        ActivationLink activationLink = new ActivationLink(idUser, token,
                LocalDate.now().plusDays(7).toString());
        activationLinkDAO.create(activationLink);
        send(user.getEmail(), token);
    }

    @Override
    public String actOnCall(String token) {
        Integer idUser = activationLinkDAO.getIDUserByToken(token);
        if (idUser == null) return "Invalid link.";
        userDAO.setActivated(true, idUser);
        delete(token);
        return "Thank you! Your account is now activated.";
    }

    @Override
    public void delete(String token) {
        activationLinkDAO.deleteByToken(token);
    }
}
