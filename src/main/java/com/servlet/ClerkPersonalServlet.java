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

@WebServlet(urlPatterns = "/ClerkPersonalServlet")
public class ClerkPersonalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        ApplicantDAO applicantDAO=new ApplicantDAO();
        User user=applicantDAO.selectUser(email);
        String date=new DateUtils().format(user.getUser_registdate());
        request.setAttribute("user",user);
        request.setAttribute("date",date);
        request.getRequestDispatcher("/webpage/clerkPersonal.jsp").forward(request,response);
    }
}
