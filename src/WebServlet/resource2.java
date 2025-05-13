package WebServlet;

import Mysql.sql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONObject;
@WebServlet(name = "resource2",urlPatterns = "/WebServlet/resource2")
public class resource2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        sql s = new sql();
        ResultSet r = s.select1();
        try {
            JSONObject json = new JSONObject();
            Integer n=0;
            while (r.next()){
                json.put(n.toString(),r.getString("detail"));
                n++;
            }
            System.out.println(json.toString());
            out.println(json.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}