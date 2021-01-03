package com.modifyServlet;

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

//加入购物车
@WebServlet(urlPatterns = "/ChoiceSaveServlet")
public class ChoiceSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname=request.getParameter("fname");
        String num=request.getParameter("number");
        String email=request.getParameter("email");
        String picture=request.getParameter("picture");
        //字符串转化为数字
        Integer number=new Integer(num);

        FlowerDAO flowerDAO=new FlowerDAO();
        OrderDAO orderDAO=new OrderDAO();
        ApplicantDAO applicantDAO=new ApplicantDAO();
        Flower flower=flowerDAO.selectFlowerName(fname);
        User user=applicantDAO.selectUser(email);
        Unpurchased unpurchased=new Unpurchased(null,number,user,flower);
        Unpurchased un=OrderDAO.selectUnpurchasedFname(email,fname);
        if(un!=null){
            Integer a=un.getUnpurchased_number()+unpurchased.getUnpurchased_number();
            double b=un.getUnpurchased_price()*a;
            Integer j=orderDAO.updateUnpurchasedFname(email,fname,a,b);
        }else{
            orderDAO.saveUnpurchased(unpurchased);
        }
        Integer n=flower.getFlower_number()-number;
        Integer i=flowerDAO.updateFlower(flower.getFlower_id(),flower.getFlower_name(),flower.getFlower_type(),n,flower.getFlower_price());
        List<Unpurchased> list=orderDAO.selectUnpurchased(email);
        Integer k=applicantDAO.updateUnUser(list.size(),email);
        if(i!=null&&i>0){
            request.setAttribute("flower",flower);
            request.setAttribute("email",email);
            request.setAttribute("picture",picture);
            RequestDispatcher dispatcher=request.getRequestDispatcher("/webpage/choice.jsp");
            dispatcher.forward(request,response);
        }
    }
}
