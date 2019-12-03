package com.example.hello.controller;

import com.datastax.driver.core.utils.UUIDs;
import com.example.hello.model.Account;
import com.example.hello.response.AccountResponse;
import com.example.hello.response.AccountResponseData;
import com.example.hello.service.AccountServiceImpl;
import com.example.hello.utils.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class HomeController {
    @Autowired
    private AccountServiceImpl accountService;

    private AccountResponse accountResponse = null;
    private AccountResponseData data = null;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        List<Account> list = this.accountService.getAllAccount();
        accountResponse = new AccountResponse();
//        data = new AccountResponseData();
        accountResponse.setAccountList(list);
//        data.setData(accountResponse);
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccount(@PathVariable String username) {
        Account account = this.accountService.getAccountByUsername(username);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account, UriComponentsBuilder ucBuilder) {
        if (this.accountService.isAccountExist(account)) {
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A account with username " + account.getUsername() + " already exist."), HttpStatus.CONFLICT);
        }
        account.setId(UUIDs.timeBased());
        this.accountService.saveAccount(account);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/account/{username}").buildAndExpand(account.getUsername()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/account/{username}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAccount(@RequestBody Account account, @PathVariable String username) {
        if (!this.accountService.isAccountExist(account)) {
            return new ResponseEntity<>(new CustomErrorType("Unable to update. A account with username " + account.getUsername() + " not found!"), HttpStatus.NOT_FOUND);
        }
        Account userCurrent = this.accountService.getAccountByUsername(username);
        userCurrent.setFullname(account.getFullname());
        userCurrent.setPassword(account.getPassword());
        this.accountService.saveAccount(userCurrent);
        return new ResponseEntity<>(userCurrent, HttpStatus.OK);
    }

    @RequestMapping(value = "/account/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAccount(@PathVariable String username) {
        if (this.accountService.deleteAccountByUsername(username)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(new CustomErrorType("Unable to delete. Account with username " + username + " not found!"), HttpStatus.NOT_FOUND);
    }
}
