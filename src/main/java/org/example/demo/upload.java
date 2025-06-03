package org.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
@WebServlet("/upload")
@MultipartConfig(location = "/home/kong/demo/target/file")
public class upload extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Part myfile = req.getPart("myfile");
        String fileName = req.getParameter("filename");
        if (fileName.isEmpty()) {
            fileName = myfile.getName();
        }
        myfile.write("/home/kong/target/file/" + fileName);
        System.out.println(fileName);
        resp.sendRedirect("file1.html");
    }
}
