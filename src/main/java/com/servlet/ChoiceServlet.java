package com.servlet;

import com.bean.Flower;
import com.bean.Unpurchased;
import com.bean.User;
import com.dao.ApplicantDAO;
import com.dao.FlowerDAO;
import com.dao.OrderDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//添加购物车界面
@WebServlet(urlPatterns = "/ChoiceServlet")
public class ChoiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname=request.getParameter("fname");
        String email=request.getParameter("email");
        String picture=request.getParameter("picture");
        FlowerDAO flowerDAO=new FlowerDAO();
        Flower flower=flowerDAO.selectFlowerName(fname);
        request.setAttribute("flower",flower);
        request.setAttribute("email",email);
        request.setAttribute("picture",picture);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/webpage/choice.jsp");
        dispatcher.forward(request,response);
    }
}
