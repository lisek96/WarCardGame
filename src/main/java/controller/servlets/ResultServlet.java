package controller.servlets;

import com.google.gson.Gson;
import model.game.Result;
import model.user.SessionUser;
import service.game.GameService;
import service.user.UserService;
import service.user.UserServiceInterface;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")

public class ResultServlet extends HttpServlet {
    @Inject
    GameService gameService;
    @Inject
    UserServiceInterface userServiceInterface;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionUser user = (SessionUser) request.getSession().getAttribute("user");
        BufferedReader br =
                new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = br.readLine();
        Gson g = new Gson();
        Result result = g.fromJson(json, Result.class);
        String winner = result.getWinner();
        try {
            gameService.setGameResult(result);
            if (!winner.equals("computer"))
                userServiceInterface.incrementWins(user.getId());
            else
                userServiceInterface.incrementLoses(user.getId());
        }catch (SQLException e){
            e.printStackTrace();
        };

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
