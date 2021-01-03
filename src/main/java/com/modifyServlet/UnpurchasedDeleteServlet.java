package com.modifyServlet;

import com.bean.Flower;
import com.bean.Purchased;
import com.bean.Unpurchased;
import com.dao.ApplicantDAO;
import com.dao.FlowerDAO;
import com.dao.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

//取消未购买订单
@WebServlet(urlPatterns = "/UnpurchasedDeleteServlet")
public class UnpurchasedDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String fname=request.getParameter("fname");
        OrderDAO orderDAO=new OrderDAO();
        Unpurchased unpurchased=orderDAO.selectUnpurchasedFname(email,fname);
        boolean i=orderDAO.deleteUnpurchased(fname,email);
        if(i){
            FlowerDAO flowerDAO=new FlowerDAO();
            Flower flower=flowerDAO.selectFlowerName(fname);
            Integer num=unpurchased.getUnpurchased_number()+flower.getFlower_number();
            Integer j=flowerDAO.updateFlower(flower.getFlower_id(),flower.getFlower_name(),flower.getFlower_type(),num,flower.getFlower_price());
            if(j>0){
                List<Unpurchased> list=orderDAO.selectUnpurchased(email);
                Integer k=new ApplicantDAO().updateUnUser(list.size(),email);
                request.setAttribute("list",list);
                request.setAttribute("email",email);
                request.getRequestDispatcher("/webpage/unpurchased.jsp").forward(request,response);
            }
        }
    }
}
