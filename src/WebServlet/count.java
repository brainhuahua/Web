package WebServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
@WebServlet(name = "count",urlPatterns = "/WebServlet/count")
public class count extends HttpServlet {

    static int count_num=0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        count_num++;
        System.out.println(count_num);

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(String.valueOf(count_num));
    }
}
