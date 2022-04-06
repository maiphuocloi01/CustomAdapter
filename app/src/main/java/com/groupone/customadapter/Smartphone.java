package com.groupone.customadapter;

public class Smartphone {
    private int id;
    private String name;
    private String type;
    private long price;
    private int operation;

    public Smartphone(int id, String name, String type, long price, int operation) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.operation = operation;
    }

    public Smartphone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return  "Tên: " + name +
                ", Phân loại: " + type +
                ", Giá: " + price;
    }
}
