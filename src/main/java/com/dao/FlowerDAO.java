package com.dao;

import com.bean.Flower;
import com.utils.DBUtils;

import java.util.List;

public class FlowerDAO {
    //添加鲜花信息
    public static boolean saveFlower(Flower flower){
        String sql="insert into flower(FLOWER_NAME,FLOWER_TYPE,FLOWER_NUMBER,FLOWER_PRICE)" +
                "values(?,?,?,?)";
        return DBUtils.save(sql, flower.getFlower_name(),flower.getFlower_type(),flower.getFlower_number(),flower.getFlower_price());
    }

    //查看全部鲜花信息
    public static List<Flower> selectFlower(){
        String sql="select flower_id,flower_name,flower_type,flower_number,flower_price from flower";
        return DBUtils.getList(Flower.class,sql);
    }

    //根据名字查看鲜花信息
    public static Flower selectFlowerName(String name){
        String sql="select flower_id,flower_name,flower_type,flower_number,flower_price from flower where flower_name=?";
        return DBUtils.getSingleObj(Flower.class,sql,name);
    }

    //根据种类查看鲜花信息
    public static Flower selectFlowerType(String type){
        String sql="select flower_id,flower_name,flower_type,flower_number,flower_price from flower where flower_type=?";
        return DBUtils.getSingleObj(Flower.class,sql,type);
    }

    //修改鲜花信息
    public static Integer updateFlower(Integer id,String name,String type,Integer number,double price){
        String sql="update flower set flower_name=?,flower_type=?,flower_number=?,flower_price=?" +
                "where flower_id=?";
        return DBUtils.update(sql,name,type,number,price,id);
    }

    //删除鲜花信息
    public static boolean deleteFlower(String name) {
        String sql="delete from flower where flower_name=?";
        return DBUtils.delete(sql,name);
    }
}
