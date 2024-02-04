package main.java.dev.thallesrafael.jdbc.model;

public class Product {

    private Integer code;

    private String name;

    private double price;


   public Product(){};

    public Product(Integer code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


}
