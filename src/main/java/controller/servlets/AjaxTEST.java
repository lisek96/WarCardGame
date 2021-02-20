package controller.servlets;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;

@WebServlet(name = "AjaxTEST", urlPatterns = "/ajax")
public class AjaxTEST extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        while ((json = br.readLine()) != null){
            System.out.println(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        printWriter.write("FroMServlet");
        printWriter.flush();
    }
}
