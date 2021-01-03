package com.servlet;

import com.bean.User;
import com.dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//跳转到主页
@WebServlet(urlPatterns = "/HomepageServlet")
public class HomepageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        request.setAttribute("email",email);
        request.getRequestDispatcher("/webpage/homepagejsp.jsp").forward(request,response);
    }
}
