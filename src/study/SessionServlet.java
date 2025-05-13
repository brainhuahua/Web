package study;

import jakarta.servlet.annotation.WebServlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "SessionServlet",urlPatterns = "/studyServer/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("SessionServlet processRequest");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String[] items = {"电视机","电冰箱","电脑"};
        HttpSession sess = request.getSession(true);
        Integer itemCount = (Integer)sess.getAttribute("itemCount");
        System.out.println(itemCount);
        if(itemCount == null){
             itemCount = new Integer(0);
        }
        System.out.println(itemCount);
        System.out.println(request.getParameter("item"));
        try {
            String[] itemSelected;
            String itemName;
            System.out.println(request.getParameter("item"));
            itemSelected = request.getParameterValues("item");
            if(itemSelected != null){
                 for(int i = 0;i < itemSelected.length;i++){
                      itemName = itemSelected[i];
                      itemCount = new Integer(itemCount.intValue() + 1);
                      sess.setAttribute("Item" + itemCount,itemName);
                      sess.setAttribute("itemCount",itemCount);
                 }
            }
            System.out.println(itemSelected);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet src.SessionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1>购物车</h1>");
            out.println("一共选择了 " + itemCount + " 件商品：<br>");
            for(int i = 1;i <= itemCount.intValue();i++){
                 String item = (String)sess.getAttribute("Item" + i);
                 out.println(items[Integer.parseInt(item)]);
                 out.println("<br>");
            }
            out.println("<a href = \"cart.html\">继续购物</a>");
            out.println("</center></body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }

}