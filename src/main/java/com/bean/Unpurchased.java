package com.bean;

import java.util.Date;

public class Unpurchased {
    private Integer unpurchased_id;
    private String unpurchased_name;
    private String unpurchased_email;
    private String unpurchased_phone;
    private String unpurchased_fname;
    private Integer unpurchased_number;
    private double unpurchased_price;
    private double unpurchased_toprice;

    public Unpurchased(){}
    public Unpurchased(Integer unpurchased_id,Integer unpurchased_number,User user,Flower flower){
        this.unpurchased_id=unpurchased_id;
        this.unpurchased_name=user.getUser_name();
        this.unpurchased_email=user.getUser_email();
        this.unpurchased_phone=user.getUser_phone();
        this.unpurchased_fname=flower.getFlower_name();
        this.unpurchased_number=unpurchased_number;
        this.unpurchased_price=flower.getFlower_price();
        this.unpurchased_toprice=flower.getFlower_price()*unpurchased_number;
    }

    public Integer getUnpurchased_id() {
        return unpurchased_id;
    }

    public void setUnpurchased_id(Integer unpurchased_id) {
        this.unpurchased_id = unpurchased_id;
    }

    public String getUnpurchased_name() {
        return unpurchased_name;
    }

    public void setUnpurchased_name(String unpurchased_name) {
        this.unpurchased_name = unpurchased_name;
    }

    public String getUnpurchased_email() {
        return unpurchased_email;
    }

    public void setUnpurchased_email(String unpurchased_email) {
        this.unpurchased_email = unpurchased_email;
    }

    public String getUnpurchased_phone() {
        return unpurchased_phone;
    }

    public void setUnpurchased_phone(String unpurchased_phone) {
        this.unpurchased_phone = unpurchased_phone;
    }

    public String getUnpurchased_fname() {
        return unpurchased_fname;
    }

    public void setUnpurchased_fname(String unpurchased_fname) {
        this.unpurchased_fname = unpurchased_fname;
    }

    public Integer getUnpurchased_number() {
        return unpurchased_number;
    }

    public void setUnpurchased_number(Integer unpurchased_number) {
        this.unpurchased_number = unpurchased_number;
    }

    public double getUnpurchased_price() {
        return unpurchased_price;
    }

    public void setUnpurchased_price(double unpurchased_price) {
        this.unpurchased_price = unpurchased_price;
    }

    public double getUnpurchased_toprice() {
        return unpurchased_toprice;
    }

    public void setUnpurchased_toprice(double unpurchased_toprice) {
        this.unpurchased_toprice = unpurchased_toprice;
    }

    @Override
    public String toString() {
        return "Unpurchased{" +
                "unpurchased_id=" + unpurchased_id +
                ", unpurchased_name='" + unpurchased_name + '\'' +
                ", unpurchased_email='" + unpurchased_email + '\'' +
                ", unpurchased_phone='" + unpurchased_phone + '\'' +
                ", unpurchased_fname='" + unpurchased_fname + '\'' +
                ", unpurchased_number=" + unpurchased_number +
                ", unpurchased_price=" + unpurchased_price +
                ", unpurchased_toprice=" + unpurchased_toprice +
                '}';
    }
}
