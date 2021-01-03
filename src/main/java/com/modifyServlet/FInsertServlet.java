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

@WebServlet(urlPatterns = "/FInsertServlet")
public class FInsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String num=request.getParameter("number");
        String pr=request.getParameter("price");
        //字符串转换为数字
        Integer number=new Integer(num);
        double price=new Double(pr);
        FlowerDAO flowerDAO=new FlowerDAO();
        Flower flower=new Flower(null,name,type,number,price);
        boolean i=flowerDAO.saveFlower(flower);
        if (i) {
            List<Flower> list=flowerDAO.selectFlower();
            request.setAttribute("list",list);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/webpage/insert.jsp").forward(request,response);
        }
    }
}
