package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Controller")
public class Controller extends HttpServlet{
    private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();

        Integer hits = (Integer) context.getAttribute("hits");

        if (hits == null) {
            hits = 0;
        } else {
            hits++;
        }

        context.setAttribute("hits",hits);

        PrintWriter out = resp.getWriter();
        out.println("Hits: " + hits);
    }
}
