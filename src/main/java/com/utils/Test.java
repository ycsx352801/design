package com.utils;


import com.bean.Flower;
import com.bean.Purchased;
import com.bean.Unpurchased;
import com.bean.User;
import com.dao.ApplicantDAO;
import com.dao.FlowerDAO;
import com.dao.OrderDAO;

import java.util.*;

/*
封装思路
1、通过反射创建一个对象
2、通过反射，给对象属性赋值
3、表的列名和对象属性名称对应
如：user 列 USER_NAME
    User 对象 username
* */

public class Test {
    public static void main(String[] args) throws Exception{
        //添加未购买订单
        /*ApplicantDAO applicantDAO=new ApplicantDAO();
        User user=applicantDAO.selectUser("123456@qq.com");
        String fname="一鹿有你";
        Flower flower=applicantDAO.selectFlowerName(fname);
        System.out.println(user);
        System.out.println(flower);
        Unpurchased unpurchased=new Unpurchased(null,fname,2,user,flower);
        Unpurchased un=applicantDAO.selectUnpurchasedFname("123456@qq.com",fname);
        if(un!=null){
            Integer a=un.getUnpurchased_number()+unpurchased.getUnpurchased_number();
            double b=un.getUnpurchased_price()*a;
            Integer j=applicantDAO.updateUnpurchasedFname(fname,a,b);
        }else{
            applicantDAO.saveUnpurchased(unpurchased);
        }
        List<Unpurchased> list=applicantDAO.selectUnpurchased("123456@qq.com");
        System.out.println(list);
        System.out.println(un);*/

        //添加购买订单，同时删除未购买订单
        /*ApplicantDAO applicantDAO=new ApplicantDAO();
        List<Unpurchased> list=applicantDAO.selectUnpurchased("123456@qq.com");
        Unpurchased unpurchased=(Unpurchased) list;
        System.out.println(unpurchased);
        Purchased purchased=new Purchased(unpurchased,new Date());
        boolean i=applicantDAO.savePurchased(purchased);
        if(i){
            applicantDAO.deleteUnpurchased(unpurchased.getUnpurchased_fname());
            List<Purchased> list1=applicantDAO.selectPurchased("123456@qq.com");
            System.out.println(list1);
        }*/

        //修改鲜花信息
        /*ApplicantDAO applicantDAO=new ApplicantDAO();
        String name="一鹿有你";
        Integer i=applicantDAO.updateFlower(2,name,"礼物",3,200);
        Flower flower=applicantDAO.selectFlowerName(name);
        System.out.println(flower);*/

        //删除鲜花信息
        /*ApplicantDAO applicantDAO=new ApplicantDAO();
        String name="一鹿有你";
        boolean i=applicantDAO.deleteFlower(name);
        if(i){
            List<Flower> flower1=applicantDAO.selectFlower();
            System.out.println(flower1);
        }*/
        /*String fname="一鹿有你";
        String num="1";
        String email="123@qq.com";
        //String picture=request.getParameter("picture");
        //字符串转为数子
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
            Integer j=orderDAO.updateUnpurchasedFname(fname,a,b);
        }else{
            orderDAO.saveUnpurchased(unpurchased);
        }
        Integer i=flowerDAO.updateFlower(flower.getFlower_id(),flower.getFlower_name(),flower.getFlower_type(),number,flower.getFlower_price());
        if(i!=null&&i>0){
            System.out.println(unpurchased);
            System.out.println(flower);
        }*/
        String s="qst@itoffer.cn";
        String[] str=s.split("@");
        if(str[1].equals("itoffer.cn"))
            System.out.println(str[1]);
    }
}
