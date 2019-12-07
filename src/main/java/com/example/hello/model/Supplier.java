package com.example.hello.model;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("supplier")
public class Supplier {
    @PrimaryKey("id")
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    @Column("name")
    private String name;

    @Column("phone")
    private String phone;

    @Column("mail")
    private String mail;

    @Column("address")
    private String address;

    @Column("created_at")
    @CassandraType(type = DataType.Name.DATE)
    private LocalDate createdAt;

    public Supplier() {
    }

    public Supplier(UUID id, String name, String phone, String mail, String address, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
