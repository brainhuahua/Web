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
@WebServlet(name = "resource1",urlPatterns = "/WebServlet/resource1")
public class resource1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        PrintWriter out = response.getWriter();
        sql s = new sql();
        ResultSet r = s.select(email);
        try {
            while (r.next()){
                JSONObject json = new JSONObject();
                json.put("email", r.getString("email"));
                json.put("name", r.getString("name"));
                json.put("position", r.getString("toward"));
                json.put("address", r.getString("address"));
                json.put("birth", r.getString("birth"));
                json.put("tel", r.getString("tel"));
                json.put("photourl", r.getString("photourl"));
                // 输出JSON字符串
                System.out.println(json.toString());
                out.println(json.toString());
//                out.println("name:"+r.getString("name"));
//                out.println("position:"+r.getString("toward"));
//                out.println("address:"+r.getString("address"));
//                out.println("birth:"+r.getString("birth"));
//                out.println("tel:"+r.getString("tel"));
                break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
