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

@WebServlet(name = "forgotpass",urlPatterns = "/WebServlet/forgotpass")
public class forgotpass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        System.out.println(username+" "+email);
        sql sql = new sql();
        PrintWriter out = response.getWriter();

        if(sql.forgotpass(username,email).equals("-1")){
            System.out.println("找回失败");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>找回失败</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(\"history.go(-1)\", 0);");
            out.println("</script>");
            out.println("<SCRIPT language=javascript>");
            out.println("function go()");
            String al = "{alert('"+"你的密码或账号错误!"+"');}";
            out.println(al);
            out.println("setTimeout(\"go()\",0);");
            out.println("</SCRIPT>");
            out.println("</html>");
            out.close();
        }else {
            System.out.println("找回成功");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>找回成功</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<SCRIPT language=javascript>");
            out.println("function go()");
            String al = "{alert('"+"你的密码是:"+sql.forgotpass(username,email)+"');}";
            out.println(al);
            out.println("setTimeout(\"go()\",0);");
            out.println("</SCRIPT>");
            out.println("<script type=\"text/javascript\">");
            out.println("setTimeout(\"location.href = '/login'\", 0);");
            out.println("</script>");

            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }
}
