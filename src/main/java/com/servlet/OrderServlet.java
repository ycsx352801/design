package com.servlet;

import com.bean.Purchased;
import com.dao.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        OrderDAO orderDAO=new OrderDAO();
        List<Purchased> list=orderDAO.selectSPurchased();
        request.setAttribute("list",list);
        request.setAttribute("email",email);
        request.getRequestDispatcher("/webpage/purchased.jsp").forward(request,response);
    }
}
