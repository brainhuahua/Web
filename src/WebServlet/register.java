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

@WebServlet(name = "register",urlPatterns = "/WebServlet/register")
public class register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(email+" "+username+" "+password);
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        sql s = new sql();
        if(s.register(email,username,password)){
            System.out.println("注册成功");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>注册成功</p>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(\"history.go(-1)\", 0);");
            out.println("</script>");
            out.println("<SCRIPT language=javascript>");
            out.println("function go()");
            out.println("{alert('注册成功');}");
            out.println("setTimeout(\"go()\",0);");
            out.println("</SCRIPT>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(\"location.href = '/login'\", 0);");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }else{
            System.out.println("注册失败");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>register error</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p></p>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(\"history.go(-1)\", 0);");
            out.println("</script>");
            out.println("<SCRIPT language=javascript>");
            out.println("function go()");
            out.println("{alert('注册失败');}");
            out.println("setTimeout(\"go()\",0);");
            out.println("</SCRIPT>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
}
