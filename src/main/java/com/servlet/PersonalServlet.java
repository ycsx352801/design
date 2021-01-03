package com.servlet;

import com.bean.User;
import com.dao.ApplicantDAO;
import com.utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//跳转个人中心界面
@WebServlet(urlPatterns = "/PersonalServlet")
public class PersonalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //跳转页面
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        ApplicantDAO applicantDAO=new ApplicantDAO();
        User user=applicantDAO.selectUser(email);
        String date=new DateUtils().format(user.getUser_registdate());
        request.setAttribute("user",user);
        request.setAttribute("date",date);
        request.getRequestDispatcher("/webpage/personal.jsp").forward(request,response);
    }
}
