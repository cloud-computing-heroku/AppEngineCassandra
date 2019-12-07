package com.example.hello.model;

import com.datastax.driver.core.DataType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("account_role")
public class AccountRole {
    @PrimaryKey("id")
    @CassandraType(type = DataType.Name.UUID)
    private UUID id;

    @Column("username")
    private String username;

    @Column("rolename")
    private String rolename;

    public AccountRole() {
    }

    public AccountRole(UUID id, String username, String rolename) {
        this.id = id;
        this.username = username;
        this.rolename = rolename;
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

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
