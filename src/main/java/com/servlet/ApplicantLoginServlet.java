package com.servlet;

import com.bean.Applicant;
import com.bean.User;
import com.dao.ApplicantDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
登录
 */
@WebServlet(urlPatterns = "/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端提交的邮箱和密码
        String applicantEmail=request.getParameter("applicantEmail");
        String applicantPwd=request.getParameter("applicantPwd");
        //根据email和密码查询申请人
        ApplicantDAO applicantDAO=new ApplicantDAO();
        Integer count=applicantDAO.getApplicantByEmailAndPass(applicantEmail,applicantPwd);
        if(count!=0){
            String[] str=applicantEmail.split("@");
            if(str[1].equals("itoffer.cn")) {
                User user=applicantDAO.selectUser(applicantEmail);
                request.setAttribute("user",user);
                request.getRequestDispatcher("/webpage/clerkPersonal.jsp").forward(request, response);
            }else {
                request.setAttribute("email",applicantEmail);
                request.getRequestDispatcher("/webpage/homepagejsp.jsp").forward(request, response);
            }
        }else{
            response.sendRedirect("/design/webpage/login.html");
        }
    }
}
