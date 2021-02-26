package controller.servlets;

import com.google.gson.Gson;
import model.game.Result;
import service.game.GameService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@WebServlet(name = "ResultServlet", urlPatterns = "/result")

public class ResultServlet extends HttpServlet {
    @Inject
    GameService gameService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = br.readLine();
        Gson g = new Gson();
        Result result = g.fromJson(json, Result.class);
        gameService.setGameResult(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
