package controller.servlets;

import model.SessionUser;
import model.User;
import service.user.UserService;
import service.utilites.PasswordEncoder;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    @Inject
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Iterator<String> xx = request.getAttributeNames().asIterator();
        while (xx.hasNext()) {
            request.setAttribute(xx.next(), null);
        }
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String loginAttemptInfo = userService.tryToAuthUserAndReturnInfo(login, password);
        SessionUser user;
        if (loginAttemptInfo.equals("authed")) {
            user = userService.createUserForSessionAfterSuccessfulLogin(login);
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("loginAttemptInfo", loginAttemptInfo);
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("xx");
    }
}
