package com.bean;

public class Flower {
    private Integer flower_id;
    private String flower_name;
    private String flower_type;
    private Integer flower_number;
    private double flower_price;
    public Flower(){}
    public Flower(Integer flower_id,String flower_name,String flower_type,Integer flower_number,double flower_price){
        this.flower_id=flower_id;
        this.flower_name=flower_name;
        this.flower_type=flower_type;
        this.flower_number=flower_number;
        this.flower_price=flower_price;
    }

    public Integer getFlower_id() {
        return flower_id;
    }

    public void setFlower_id(Integer flower_id) {
        this.flower_id = flower_id;
    }

    public String getFlower_name() {
        return flower_name;
    }

    public void setFlower_name(String flower_name) {
        this.flower_name = flower_name;
    }

    public String getFlower_type() {
        return flower_type;
    }

    public void setFlower_type(String flower_type) {
        this.flower_type = flower_type;
    }

    public Integer getFlower_number() {
        return flower_number;
    }

    public void setFlower_number(Integer flower_number) {
        this.flower_number = flower_number;
    }

    public double getFlower_price() {
        return flower_price;
    }

    public void setFlower_price(double flower_price) {
        this.flower_price = flower_price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "flower_id=" + flower_id +
                ", flower_name='" + flower_name + '\'' +
                ", flower_type='" + flower_type + '\'' +
                ", flower_number=" + flower_number +
                ", flower_price=" + flower_price +
                '}';
    }
}
