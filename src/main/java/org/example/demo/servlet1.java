package org.example.demo;
import org.example.demo.database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/s1")
public class servlet1 extends HttpServlet {

    private Object ClassNotFoundException;
    private Object SQLException;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        try {
            database reg = new database();
            reg.showConnect();
            reg.insert(uname,pwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
req.getRequestDispatcher("login.html").forward(req,resp);

    }

}