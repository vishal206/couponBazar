package com.example.couponbazar;

public class ManageSales {
    private String brand,benefits,code;
    private Integer price;

    public ManageSales() {
    }

    public ManageSales(String brand, String benefits, String code, Integer price) {
        this.brand = brand;
        this.benefits = benefits;
        this.code = code;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
