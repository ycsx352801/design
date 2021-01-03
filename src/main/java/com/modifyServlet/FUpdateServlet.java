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

@WebServlet(urlPatterns = "/FUpdateServlet")
public class FUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String i=request.getParameter("id");
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String num=request.getParameter("number");
        String pr=request.getParameter("price");
        //字符串转换为数字
        Integer id=new Integer(i);
        Integer number=new Integer(num);
        double price=new Double(pr);
        FlowerDAO flowerDAO=new FlowerDAO();
        Integer j=flowerDAO.updateFlower(id,name,type,number,price);
        if (j>0) {
            List<Flower> list=flowerDAO.selectFlower();
            request.setAttribute("list",list);
            request.setAttribute("email",email);
            request.getRequestDispatcher("/webpage/update.jsp").forward(request,response);
        }
    }
}
