package com.example.hello.model;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table("customer")
public class Customer {

    @Column("id")
    @PrimaryKey("id")
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    @Column("fullname")
    private String fullname;

    @Column("date_birth")
    @CassandraType(type = DataType.Name.DATE)
    private LocalDate dateOfBirth;

    @Column("gender")
    private String gender;

    @Column("phone")
    private String phone;

    @Column("mail")
    private String mail;

    @Column("address")
    private String address;

    @Column("created_at")
    @CassandraType(type = DataType.Name.DATE)
    private LocalDate createdAt;

    public Customer() {
    }

    public Customer(UUID id, String fullname, LocalDate dateOfBirth, String gender, String phone, String mail, String address, LocalDate createdAt) {
        this.id = id;
        this.fullname = fullname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
