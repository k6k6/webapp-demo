package org.example.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
@WebServlet("/s2")
@MultipartConfig
public class servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        try {
            database reg = new database();
            reg.showConnect();
           if(reg.select(uname,pwd)==1)
           {
               req.getRequestDispatcher("file1.html").forward(req,resp);
           }
           else{
               req.getRequestDispatcher("fail.html").forward(req,resp);
           }
        } catch (java.sql.SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
