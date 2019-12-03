package com.example.hello.repository;

import com.example.hello.model.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {
    Account findAccountByUsername(String username);

    boolean deleteAccountByUsername(String username);
}
