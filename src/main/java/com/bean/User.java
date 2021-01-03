package com.bean;

import com.dao.ApplicantDAO;

import java.util.Date;

public class User {
    //和数据库中的user表的列对应
    private Integer user_id;
    private String user_name;
    private String user_email;
    private String user_pwd;
    private String user_phone;
    private Integer user_purchased;
    private Integer user_unpurchased;
    private Date user_registdate;

    public User(){}

    public User(Applicant app,ApplicantDAO ad){
        this.user_id= ad.selectApplicantEmailCount(app.getApplicantEmail());
        this.user_email=app.getApplicantEmail();
        this.user_pwd=app.getApplicantPwd();
        this.user_registdate=app.getApplicantRegistdate();
        this.user_name="未设置";
        this.user_phone="未填写";
        this.user_purchased=0;
        this.user_unpurchased=0;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_password) {
        this.user_pwd = user_password;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public Date getUser_registdate() {
        return user_registdate;
    }

    public void setUser_registdate(Date user_registdate) {
        this.user_registdate = user_registdate;
    }

    public Integer getUser_purchased() {
        return user_purchased;
    }

    public void setUser_purchased(Integer user_purchased) {
        this.user_purchased = user_purchased;
    }

    public Integer getUser_unpurchased() {
        return user_unpurchased;
    }

    public void setUser_unpurchased(Integer user_unpurchased) {
        this.user_unpurchased = user_unpurchased;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_purchased=" + user_purchased +
                ", user_unpurchased=" + user_unpurchased +
                ", user_registdate=" + user_registdate +
                '}';
    }
}
