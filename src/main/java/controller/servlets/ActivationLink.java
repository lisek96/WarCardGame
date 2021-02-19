package controller.servlets;

import service.activationLink.ActivationLinkService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ActivationLink", urlPatterns = "/activate/*")
public class ActivationLink extends HttpServlet {
    @Inject
    ActivationLinkService activationLinkService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getPathInfo().substring(1);
        String info = activationLinkService.actOnCall(token);
        request.setAttribute("linkInfo", info);
        request.getRequestDispatcher("/activationLink.jsp").forward(request,response);
    }
}
