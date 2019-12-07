package com.example.hello.controller.base;

import com.example.hello.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseAccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/account")
    public String getAll(Model model) {
        model.addAttribute("accountList", this.accountService.getAllAccount());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Admin");
        model.addAttribute("sub_active", "Account");
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
