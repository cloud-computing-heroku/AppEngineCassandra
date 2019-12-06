package com.example.hello.controller;

import com.example.hello.service.AccountService;
import com.example.hello.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("accountList", this.accountService.getAllAccount());
        return "home";
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("listCustomer", this.customerService.getAllCustomer());
        return "index";
    }
}
