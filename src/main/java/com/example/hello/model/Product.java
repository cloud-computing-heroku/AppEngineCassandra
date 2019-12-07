package com.example.hello.model;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("product")
public class Product {

    @PrimaryKey("id")
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    @Column("name")
    private String name;

    @Column("supplier_name")
    private String supplierName;

    @Column("producer_name")
    private String producerName;

    @Column("type_name")
    private String typeName;

    @Column("cost")
    private double cost;

    @Column("sale")
    private double sale;

    @Column("remain")
    private double remain;

    @Column("amount")
    private double amount;

    @Column("created_at")
    @CassandraType(type = DataType.Name.DATE)
    private LocalDate createdAt;

    public Product() {
    }

    public Product(UUID id, String name, String supplierName, String producerName, String typeName, double cost, double sale, double remain, double amount, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.supplierName = supplierName;
        this.producerName = producerName;
        this.typeName = typeName;
        this.cost = cost;
        this.sale = sale;
        this.remain = remain;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
