package com.example.hello.service;

import com.example.hello.model.Account;
import com.example.hello.model.AccountRole;
import com.example.hello.repository.AccountRepository;
import com.example.hello.repository.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account user = this.accountRepository.findAccountByUsername(s);

        if (user == null) {
            System.err.println("User not found!");
            throw new UsernameNotFoundException("User + " + s + " was not found in the database");
        }

        System.err.println("Found User = " + user);

        // Get Role
        Optional<AccountRole> role = this.accountRoleRepository.findAccountRoleByUsername(user.getUsername());
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (role != null) {
            GrantedAuthority auth = new SimpleGrantedAuthority(role.get().getRolename());
            grantList.add(auth);
            System.err.println("role = " + role);
        }
        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantList);
        return userDetails;
    }
}
