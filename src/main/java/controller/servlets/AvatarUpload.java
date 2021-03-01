package controller.servlets;

import model.user.SessionUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet(name = "AvatarUpload", urlPatterns = "/upload")
@MultipartConfig
public class AvatarUpload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final SessionUser user = (SessionUser) request.getSession().getAttribute("user");
        final String path =  "C:\\War\\WarCardGame\\src\\main\\webapp\\avatars\\" + user.getLogin() + ".jpg"; // need to rework this path
        final Part filePart = request.getPart("file");

        File avatar = new File(path);avatar.createNewFile();
        OutputStream out = new FileOutputStream(avatar);
        InputStream fileContent = filePart.getInputStream();
        byte[] bytes = fileContent.readAllBytes();
        out.write(bytes);

        fileContent.close();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
