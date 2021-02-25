package controller.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Play", urlPatterns = "/play")
public class Play extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardNumbersString = request.getParameter("cardsNumber");
        int cardNumbers;
        try {
            cardNumbers = Integer.parseInt(cardNumbersString);
            if (!(cardNumbers > 0 && cardNumbers < 27)) {
                response.sendRedirect("/WarCardGame_war_exploded/play?cardsNumber=26");
            } else
                request.getRequestDispatcher("/play.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("/WarCardGame_war_exploded/play?cardsNumber=26");
        }
    }
}
