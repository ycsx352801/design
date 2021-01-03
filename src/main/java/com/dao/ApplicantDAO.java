package com.dao;

import com.bean.*;
import com.utils.DBUtils;

import java.util.List;

public class ApplicantDAO {
    //保存注册对象
    public static boolean saveApplicant(Applicant applicant) {
        String sql="insert into applicant(APPLICANT_EMAIL,APPLICANT_PWD,APPLICANT_REGISTDATE)"+
                "values(?,?,?)";
        return DBUtils.save(sql,applicant.getApplicantEmail(),applicant.getApplicantPwd(),applicant.getApplicantRegistdate());
    }

    //保存用户信息
    public static boolean saveUser(User user) {
        String sql="insert into user(USER_ID,USER_NAME,USER_EMAIL,USER_PWD,USER_PHONE,USER_REGISTDATE)" +
                "values(?,?,?,?,?,?)";
        return DBUtils.save(sql,user.getUser_id(),user.getUser_name(),user.getUser_email(),user.getUser_pwd(),user.getUser_phone(),user.getUser_registdate());
    }

    //根据邮箱和密码查询用户
    public static Integer getApplicantByEmailAndPass(String applicantEmail, String applicantPwd) {
        String sql="select * from applicant where APPLICANT_EMAIL='"+applicantEmail+"' and APPLICANT_PWD='"+applicantPwd+"'";
        return DBUtils.getCount(sql);
    }

    //查询是否有相同的邮箱
    public static Integer selectApplicantEmailCount(String applicantEmail) {
        String sql="select * from applicant where applicant_email='"+applicantEmail+"'";
        return DBUtils.getCount(sql);
    }

    //删除applicant表格数据
    public static boolean deleteApplicantEmail(String email) {
        String sql="delete from applicant where applicant_email=?";
        return DBUtils.delete(sql,email);
    }

    //根据邮箱查询用户信息表中的信息
    public static User selectUser(String email){
        String sql="select user_name,user_email,user_pwd,user_phone,user_purchased,user_unpurchased,user_registdate from user "+
                "where user_email=?";
        return DBUtils.getSingleObj(User.class,sql,email);
    }

    //修改用户信息
    public static Integer updateUser(String name,String password,String phone,String email){
        String sql="update user set user_name=?,user_pwd=?,user_phone=? " +
                "where user_email=?";
        return DBUtils.update(sql,name,password,phone,email);
    }

    //修改用户未购买订单信息信息
    public static Integer updateUnUser(Integer num,String email){
        String sql="update user set user_unpurchased=? " +
                "where user_email=?";
        return DBUtils.update(sql,num,email);
    }

    //修改用户购买订单信息信息
    public static Integer updatePUser(Integer num,String email){
        String sql="update user set user_purchased=? " +
                "where user_email=?";
        return DBUtils.update(sql,num,email);
    }
}
