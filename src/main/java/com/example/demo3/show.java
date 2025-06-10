package com.example.demo3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/show")
public class show extends ViewBaseServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("D:/software/idea/demo3/target/file");
        File[] files = file.listFiles();
// 此处针对列表中的文件进行遍历，调用getName方法即可获取文件名
// 下面以thymeleaf渲染为例，传递files对象
        req.setAttribute("allfiles", files);
        super.processTemplate("file1", req, resp);

    }
}
