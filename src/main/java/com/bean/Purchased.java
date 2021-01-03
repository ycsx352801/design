package com.bean;

import java.util.Date;

public class Purchased {
    private Integer purchased_id;
    private String purchased_name;
    private String purchased_email;
    private String purchased_phone;
    private String purchased_fname;
    private Integer purchased_number;
    private double purchased_price;
    private double purchased_toprice;
    private Date purchased_registdate;

    public Purchased(){}
    public Purchased(Unpurchased unpurchased,Date purchased_registdate){
        this.purchased_id=unpurchased.getUnpurchased_id();
        this.purchased_name=unpurchased.getUnpurchased_name();
        this.purchased_email=unpurchased.getUnpurchased_email();
        this.purchased_phone=unpurchased.getUnpurchased_phone();
        this.purchased_fname=unpurchased.getUnpurchased_fname();
        this.purchased_number=unpurchased.getUnpurchased_number();
        this.purchased_price=unpurchased.getUnpurchased_price();
        this.purchased_toprice=unpurchased.getUnpurchased_toprice();
        this.purchased_registdate=purchased_registdate;
    }

    public Integer getPurchased_id() {
        return purchased_id;
    }

    public void setPurchased_id(Integer purchased_id) {
        this.purchased_id = purchased_id;
    }

    public String getPurchased_name() {
        return purchased_name;
    }

    public void setPurchased_name(String purchased_name) {
        this.purchased_name = purchased_name;
    }

    public String getPurchased_email() {
        return purchased_email;
    }

    public void setPurchased_email(String purchased_email) {
        this.purchased_email = purchased_email;
    }

    public String getPurchased_phone() {
        return purchased_phone;
    }

    public void setPurchased_phone(String purchased_phone) {
        this.purchased_phone = purchased_phone;
    }

    public String getPurchased_fname() {
        return purchased_fname;
    }

    public void setPurchased_fname(String purchased_fname) {
        this.purchased_fname = purchased_fname;
    }

    public Integer getPurchased_number() {
        return purchased_number;
    }

    public void setPurchased_number(Integer purchased_number) {
        this.purchased_number = purchased_number;
    }

    public double getPurchased_price() {
        return purchased_price;
    }

    public void setPurchased_price(double purchased_price) {
        this.purchased_price = purchased_price;
    }

    public double getPurchased_toprice() {
        return purchased_toprice;
    }

    public void setPurchased_toprice(double purchased_toprice) {
        this.purchased_toprice = purchased_toprice;
    }

    public Date getPurchased_registdate() {
        return purchased_registdate;
    }

    public void setPurchased_registdate(Date purchased_registdate) {
        this.purchased_registdate = purchased_registdate;
    }

    @Override
    public String toString() {
        return "Purchased{" +
                "purchased_id=" + purchased_id +
                ", purchased_name='" + purchased_name + '\'' +
                ", purchased_email='" + purchased_email + '\'' +
                ", purchased_phone='" + purchased_phone + '\'' +
                ", purchased_fname='" + purchased_fname + '\'' +
                ", purchased_number=" + purchased_number +
                ", purchased_price=" + purchased_price +
                ", purchased_toprice=" + purchased_toprice +
                ", purchased_registdate=" + purchased_registdate +
                '}';
    }
}
