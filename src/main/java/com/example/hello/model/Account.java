package com.example.hello.model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("account")
public class Account {
    @Column("id")
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    @PrimaryKey("username")
    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("fullname")
    private String fullname;

    @Column("enabled")
    private boolean enabled;

    public Account() {
    }

    public Account(UUID id, String username, String password, String fullname, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.enabled = enabled;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
