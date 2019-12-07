package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseAccountController {

    @RequestMapping(value = "/account")
    public String getAll() {
        return "admin/account-info";
    }

    @RequestMapping(value = "/account/details/{i}")
    public String detailAccount() {
        return "admin/account-details";
    }

    @RequestMapping(value = "/account/create")
    public String createAccount() {
        return "admin/account-create";
    }

    @RequestMapping(value = "/account/do-create")
    public String doCreateAccount() {
        return "redirect:/account";
    }

    @RequestMapping(value = "/account/update/{id}")
    public String updateAccount() {
        return "admin/account-update";
    }

    @RequestMapping(value = "/account/do-update/{id}")
    public String doUpdateAccount() {
        return "redirect:/account";
    }

    @RequestMapping(value = "/account/delete/{id}")
    public String deleteAccount() {
        return "redirect:/account";
    }
}
