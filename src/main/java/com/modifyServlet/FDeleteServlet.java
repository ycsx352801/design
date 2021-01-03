package com.modifyServlet;

import com.bean.Flower;
import com.dao.FlowerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/FDeleteServlet")
public class FDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String name=request.getParameter("name");
        FlowerDAO flowerDAO=new FlowerDAO();
        boolean i=flowerDAO.deleteFlower(name);
        if(i){
            List<Flower> list=flowerDAO.selectFlower();
            request.setAttribute("list",list);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/webpage/delete.jsp").forward(request,response);
        }
    }
}
