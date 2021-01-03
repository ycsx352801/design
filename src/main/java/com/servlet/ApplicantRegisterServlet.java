package com.servlet;

import com.bean.Applicant;
import com.bean.User;
import com.dao.ApplicantDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/*
注册
 */
@WebServlet(urlPatterns = "/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
    //提交邮箱和密码并存入数据库
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //获取前端提交的邮箱和密码
        String applicantEmail=request.getParameter("applicantEmail");
        String applicantPwd=request.getParameter("applicantPwd");
        //插入到数据库中,对数据进行封装，自己封装成一个对象
        Applicant applicant=new Applicant(null,applicantEmail,applicantPwd,new Date());
        //保存applicant到数据库 ApplicantDAO
        ApplicantDAO applicantDAO=new ApplicantDAO();
        //判断是否有相同的邮箱
        Integer count=applicantDAO.selectApplicantEmailCount(applicantEmail);
        if(count>0){
            //数据库中已有此邮箱，给客户端一个提示
            PrintWriter writer=response.getWriter();
            writer.write("该邮箱已被注册");
            writer.flush();
            writer.close();
        }else{
            //flag是否注册成功
            boolean flag1=applicantDAO.saveApplicant(applicant);
            //注册成功就跳转到登录界面（重定向），失败就返回注册界面（请求转发）
            if(flag1){
                //添加user表数据
                User user=new User(applicant,applicantDAO);
                boolean flag2=applicantDAO.saveUser(user);
                if(flag2){
                    response.sendRedirect("/design/webpage/login.html");
                }else{
                    applicantDAO.deleteApplicantEmail(applicantEmail);
                }
            }else{
                response.sendRedirect("/design/webpage/register.html");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
