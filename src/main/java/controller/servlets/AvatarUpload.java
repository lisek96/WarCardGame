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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{

        final SessionUser user = (SessionUser) request.getSession().getAttribute("user");
        final String path =  "C:\\War\\WarCardGame\\src\\main\\webapp\\avatars\\" + user.getLogin() + ".jpg"; // need to rework this path
        try {
            File avatar = new File(path);
            final Part filePart = request.getPart("file");
            avatar.createNewFile();
            OutputStream out = new FileOutputStream(avatar);
            InputStream fileContent = filePart.getInputStream();
            byte[] bytes = fileContent.readAllBytes();
            System.out.println(bytes.length);
            out.write(bytes);
            out.flush();
            fileContent.close();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
