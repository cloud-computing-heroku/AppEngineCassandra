package com.example.hello.controller;

import com.example.hello.service.AccountService;
import com.example.hello.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

    @RequestMapping(value = "/admin")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "admin/login-page";
    }

    @RequestMapping(value = "/logout")
    public String logoutSuccess(Model model) {
        return "redirect:/login?message=logout";
    }

    @RequestMapping(value = "/forget")
    public String forget(Model model) {
        return "admin/forget-page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
//        model.addAttribute("user", new UserEntity());
        return "admin/register-page";
    }

/*    @Autowired
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
    }*/
}
