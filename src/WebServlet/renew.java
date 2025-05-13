package WebServlet;

import Mysql.sql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "renew",urlPatterns = "/WebServlet/renew")
public class renew extends HttpServlet  {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String email= request.getParameter("email");
        String name = request.getParameter("name");
        String toward = request.getParameter("position");
        String address = request.getParameter("address");
        String birth = request.getParameter("birth");
        String tel = request.getParameter("tel");
        System.out.println(email+" "+name+" "+toward+" "+address+" "+birth+" "+tel);
        sql s =new sql();
        PrintWriter out = response.getWriter();
        if(s.change_line(email,name,toward,address,birth,tel)){
            System.out.println("修改成功");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>修改成功</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(\"history.go(-1)\", 0);");
            out.println("</script>");
            out.println("<SCRIPT language=javascript>");
            out.println("function go()");
            out.println("{alert('你已成功修改');}");
            out.println("setTimeout(\"go()\",0);");
            out.println("</SCRIPT>");
            out.println("</html>");
            out.close();
        }
    }
}
