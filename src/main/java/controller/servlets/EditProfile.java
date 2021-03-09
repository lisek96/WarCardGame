package controller.servlets;

import model.user.SessionUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditProfile", urlPatterns = "/editProfile")
public class EditProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final SessionUser sessionUser = (SessionUser) request.getSession().getAttribute("user");
        final String data = request.getParameter("data");
        final String figure = request.getParameter("figure");

        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
