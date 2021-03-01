package controller.servlets;

import com.google.gson.Gson;
import controller.utils;
import model.user.Stats;
import service.user.UserService;
import service.user.UserServiceInterface;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Ranking", urlPatterns = "/ranking")
public class Ranking extends HttpServlet {
    @Inject
    UserServiceInterface userServiceInterface;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Stats> ranking = userServiceInterface.createRanking(10);
            String json = utils.provideJson(ranking);
            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            printWriter.write(json);
            printWriter.flush();
            System.out.println(json);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | SQLException e) {
            e.printStackTrace();
        }
    }
}
