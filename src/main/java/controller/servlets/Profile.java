package controller.servlets;

import com.google.gson.Gson;
import controller.utils;
import model.user.SessionUser;
import model.user.Stats;
import service.user.UserService;
import service.user.UserServiceInterface;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Profile",urlPatterns = "/profile/*")
public class Profile extends HttpServlet {
    @Inject
    UserServiceInterface userServiceInterface;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getPathInfo().substring(1);
        Stats stats = null;
        String email;
        int idUser;
        if(login.equals("")) {
            System.out.println("myProfile");
            SessionUser sessionUser = (SessionUser) request.getSession().getAttribute("user");
            idUser=sessionUser.getId();
            login=sessionUser.getLogin();
            email=sessionUser.getEmail();
            stats=userServiceInterface.getStats(idUser);
            stats.setLogin(login); stats.setEmail(email);
        }
        else{
            String[] idAndLogin = userServiceInterface.getIdAndEmailByLogin(login);
            if(idAndLogin == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            stats=userServiceInterface.getStats(Integer.parseInt(idAndLogin[0]));
            stats.setLogin(idAndLogin[0]); stats.setEmail(idAndLogin[1]);
        }


        String json = utils.provideJson(stats);
        System.out.println(json);
        PrintWriter printWriter = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        printWriter.write(json);
        printWriter.flush();
        System.out.println("Sent");
    }
}
