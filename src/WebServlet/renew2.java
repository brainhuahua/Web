package WebServlet;
import Mysql.sql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "renew2",urlPatterns = "/WebServlet/renew2")
public class renew2 extends HttpServlet  {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String opreate= request.getParameter("opreate");
        String oldcontent = request.getParameter("oldcontent");
        String newcontent = request.getParameter("newcontent");
        System.out.println("修改");
        System.out.println(opreate);
        System.out.println(oldcontent);
        System.out.println(newcontent);
        sql s =new sql();
        PrintWriter out = response.getWriter();
        if(s.change_resource(oldcontent,newcontent,Integer.parseInt(opreate))){
            System.out.println("修改成功");
            JSONObject json = new JSONObject();
            json.put("status","success");
            out.println(json.toString());
            out.close();
        }
    }
}