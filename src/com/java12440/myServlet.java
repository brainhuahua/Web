package com.java12440;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "myServlet",urlPatterns = "/myServlet")
public class myServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取浏览器发送来的数据
//        String number = req.getParameter("number");
//
//        //将获取到的数据转换成数字
//        Integer integer = Integer.decode(number);
//        int i = integer +200;
//
//        //将数据发送回浏览器,因为servlet没有界面,所以发送回去还得写一点html页面,不然浏览器上就是空白的
//        resp.getWriter().write("<html><h1>"+i+"</h1></html>");
        System.out.println("请求来了");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

    }
}
