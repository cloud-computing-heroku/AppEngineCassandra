package com.example.hello.repository;

import com.example.hello.model.AccountRole;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRoleRepository extends CassandraRepository<AccountRole, UUID> {
}
