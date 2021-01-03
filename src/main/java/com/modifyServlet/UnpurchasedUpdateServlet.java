package com.modifyServlet;

import com.bean.Purchased;
import com.bean.Unpurchased;
import com.dao.ApplicantDAO;
import com.dao.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

//更改购买未购买订单中的东西
@WebServlet(urlPatterns = "/UnpurchasedUpdateServlet")
public class UnpurchasedUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String fname=request.getParameter("fname");
        OrderDAO orderDAO=new OrderDAO();
        Unpurchased unpurchased=orderDAO.selectUnpurchasedFname(email,fname);
        boolean i=orderDAO.deleteUnpurchased(fname,email);
        if(i){
            Purchased purchased=new Purchased(unpurchased,new Date());
            boolean j=orderDAO.savePurchased(purchased);
            if(j){
                List<Unpurchased> list=orderDAO.selectUnpurchased(email);
                List<Purchased> li=orderDAO.selectPurchased(email);
                Integer k=new ApplicantDAO().updatePUser(li.size(),email);
                request.setAttribute("list",list);
                request.setAttribute("email",email);
                request.getRequestDispatcher("/webpage/unpurchased.jsp").forward(request,response);
            }
        }
    }
}
