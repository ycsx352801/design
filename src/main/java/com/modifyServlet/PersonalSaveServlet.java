package com.modifyServlet;

import com.bean.User;
import com.dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//修改个人信息
@WebServlet(urlPatterns = "/PersonalSaveServlet")
public class PersonalSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        //修改个人信息
        ApplicantDAO applicantDAO=new ApplicantDAO();
        Integer flag=applicantDAO.updateUser(name,password,phone,email);
        if(flag!=0){
            User user=applicantDAO.selectUser(email);
            request.setAttribute("user",user);
            String[] str=email.split("@");
            if(str[1].equals("itoffer.cn")){
                request.getRequestDispatcher("/webpage/clerkPersonal.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/webpage/personal.jsp").forward(request,response);
            }
        }
    }
}
