package controller.servlets;

import service.user.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@WebServlet(name = "Register", urlPatterns = "/Register")
public class Register extends HttpServlet {
    @Inject
    UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Iterator<String> xx = request.getAttributeNames().asIterator();
        while (xx.hasNext()) {
            request.setAttribute(xx.next(), null);
        }

        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String info = userService.checkAvailabilityAndReturnInfo(login, email);
        if (!info.equals("available"))
            request.setAttribute("failRegistrationAttempt", info);
        else {
            userService.registerUser(login, password, email);
            String message = "Registration went well. Activation link was sent to your email.";
            request.setAttribute("succRegistrationAttempt", message);
        }
        request.getRequestDispatcher("/").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/").forward(request, response);
    }
}
