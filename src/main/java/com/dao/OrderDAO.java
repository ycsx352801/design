package com.dao;

import com.bean.Purchased;
import com.bean.Unpurchased;
import com.utils.DBUtils;

import java.util.List;

public class OrderDAO {
    //保存未购买订单
    public static boolean saveUnpurchased(Unpurchased unpurchased){
        String sql="insert into unpurchased(unpurchased_name,unpurchased_email,unpurchased_phone,unpurchased_fname,unpurchased_number,unpurchased_price,unpurchased_toprice)" +
                "values(?,?,?,?,?,?,?)";
        return DBUtils.save(sql, unpurchased.getUnpurchased_name(),unpurchased.getUnpurchased_email(),unpurchased.getUnpurchased_phone(),unpurchased.getUnpurchased_fname(),unpurchased.getUnpurchased_number(),unpurchased.getUnpurchased_price(),unpurchased.getUnpurchased_toprice());
    }

    //查看未购买订单
    public static List<Unpurchased> selectUnpurchased(String email){
        String sql="select unpurchased_id,unpurchased_name,unpurchased_email,unpurchased_phone,unpurchased_fname,unpurchased_number,unpurchased_price,unpurchased_toprice from unpurchased where unpurchased_email=?";
        return DBUtils.getList(Unpurchased.class,sql,email);
    }

    //根据鲜花名称和用户邮箱查看未购买订单
    public static Unpurchased selectUnpurchasedFname(String email,String fname){
        String sql="select unpurchased_id,unpurchased_name,unpurchased_email,unpurchased_phone,unpurchased_fname,unpurchased_number,unpurchased_price,unpurchased_toprice from unpurchased where unpurchased_email=? and unpurchased_fname=?";
        return DBUtils.getSingleObj(Unpurchased.class,sql,email,fname);
    }

    //修改未购买订单的同名字鲜花数量和总价
    public static Integer updateUnpurchasedFname(String email,String fname,Integer number,double toprice){
        String sql="update unpurchased set unpurchased_number=?,unpurchased_toprice=? where unpurchased_fname=? and unpurchased_email=?";
        return DBUtils.update(sql,number,toprice,fname,email);
    }

    //根据鲜花名称和邮箱删除未购买订单
    public static boolean deleteUnpurchased(String fname,String email) {
        String sql="delete from unpurchased where unpurchased_fname=? and unpurchased_email=?";
        return DBUtils.delete(sql,fname,email);
    }

    //保存购买订单
    public static boolean savePurchased(Purchased purchased){
        String sql="insert into purchased(purchased_name,purchased_email,purchased_phone,purchased_fname,purchased_number,purchased_price,purchased_toprice,purchased_registdate)" +
                "values(?,?,?,?,?,?,?,?)";
        return DBUtils.save(sql, purchased.getPurchased_name(),purchased.getPurchased_email(),purchased.getPurchased_phone(),purchased.getPurchased_fname(),purchased.getPurchased_number(),purchased.getPurchased_price(),purchased.getPurchased_toprice(),purchased.getPurchased_registdate());
    }

    //查看购买订单
    public static List<Purchased> selectPurchased(String email){
        String sql="select purchased_id,purchased_name,purchased_email,purchased_phone,purchased_fname,purchased_number,purchased_price,purchased_toprice,purchased_registdate from purchased where purchased_email=?";
        return DBUtils.getList(Purchased.class,sql,email);
    }

    //查看全部购买订单
    public static List<Purchased> selectSPurchased(){
        String sql="select purchased_id,purchased_name,purchased_email,purchased_phone,purchased_fname,purchased_number,purchased_price,purchased_toprice,purchased_registdate from purchased";
        return DBUtils.getList(Purchased.class,sql);
    }
}
