package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// 和 web.xml 配置一样
@WebServlet(  name = "GetJsonServlet2",urlPatterns = "/GetJsonServlet2")
public class GetJsonServlet2 extends HttpServlet {
    //service 可以接收get也可以接收post请求

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);
        //web,controller是提供json数据的

        //使用fastjson把对象转换成json数据
        List<Student> students =  new ArrayList<>();
        Student s1 = new Student();
        s1.setId(001);
        s1.setAge(21);
        s1.setName("求怕累");
        students.add(s1);

        Student s2 = new Student();
        s2.setId(002);
        s2.setAge(30);
        s2.setName("铁山靠");
        students.add(s2);

        Student s3 = new Student();
        s3.setId(003);
        s3.setAge(55);
        s3.setName("和尚");
        students.add(s3);


        String s = JSON.toJSONString(students);
        System.out.println("s = " + s); //把对象转换成json格式的字符串


        //输出到前端
        //解决乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //开始输出
        PrintWriter writer =  resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
