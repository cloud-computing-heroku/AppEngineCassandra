package com.example.hello.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("order_details")
public class OrderDetails {

    @PrimaryKey("id")
    private String id;

    @Column("product_id")
    private String productId;

    @Column("unit_price")
    private double unitPrice;

    @Column("amount")
    private int amount;

    public OrderDetails() {
    }

    public OrderDetails(String id, String productId, double unitPrice, int amount) {
        this.id = id;
        this.productId = productId;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
