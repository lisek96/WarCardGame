package controller.servlets;

import model.user.SessionUser;
import model.user.User;
import service.utilites.DealerInterface;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Optional;


@WebServlet(name = "Dealer", urlPatterns = "/deal")
public class Deal extends HttpServlet {
    @Inject
    DealerInterface dealerInterface;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        while ((json = br.readLine()) != null){
            System.out.println(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionUser user = (SessionUser) request.getSession().getAttribute("user");
        String login = user != null ? user.getLogin() : "default login";
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        printWriter.write(dealerInterface.dealCards()+"\r\n");
        printWriter.write(login);
        printWriter.flush();
    }
}
