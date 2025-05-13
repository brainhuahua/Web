package WebServlet;

import Mysql.sql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig
@WebServlet(name = "photoupload",urlPatterns = "/WebServlet/photoupload")
public class photoupload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("图片来了");
        Part filePart = request.getPart("myFile");

        // 获取文件的名称
        String fileName = filePart.getSubmittedFileName();
        System.out.println(fileName);
        // 设置文件保存的路径
        String uploadPath = getServletContext().getRealPath("/") + "resume/img";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();  // 如果目录不存在，则创建它
        }
        sql s =new sql();
        s.change_photo(fileName);
        // 保存文件
        if (fileName != null && !fileName.isEmpty()) {
            File file = new File(uploadPath + File.separator + fileName);
            filePart.write(file.getAbsolutePath());  // 将文件保存到指定路径
            response.sendRedirect("../resume/edit.html");

            out.close();
        } else {
            response.getWriter().println("未选择文件！");
        }
    }

}
