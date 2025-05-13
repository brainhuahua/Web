package WebServlet;

import Mysql.sql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login",urlPatterns = "/WebServlet/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+" "+password);
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        sql s =new sql();
        if(s.login(username,password)){
            System.out.println("登录成功");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>response</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script>alert('登录成功');</script>\"");
            out.println("<meta http-equiv=\"refresh\" content=\"0;url=/resume/edit.html\">");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }else {
            System.out.println("登录失败");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>登陆失败</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(\"history.go(-1)\", 0);");
            out.println("</script>");
            out.println("<SCRIPT language=javascript>");
            out.println("function go()");
            out.println("{alert('密码错误');}");
            out.println("setTimeout(\"go()\",0);");
            out.println("</SCRIPT>");
            out.println("</html>");
            out.close();
        }


    }
}
