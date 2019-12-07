package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseAccountRoleController {

    @RequestMapping(value = "/account-role")
    public String getAll() {
        return "admin/role-info";
    }

    @RequestMapping(value = "/account-role/details/{i}")
    public String detailRole() {
        return "admin/account-role-details";
    }

    @RequestMapping(value = "/account-role/do-create")
    public String doCreateAccount() {
        return "redirect:/account-role";
    }

    @RequestMapping(value = "/account-role/create")
    public String createRole() {
        return "admin/account-role-create";
    }

    @RequestMapping(value = "/account-role/update/{id}")
    public String updateRole() {
        return "admin/account-role-update";
    }

    @RequestMapping(value = "/account-role/do-update/{id}")
    public String doUpdateRole() {
        return "redirect:/account-role";
    }

    @RequestMapping(value = "/account-role/delete/{id}")
    public String deleteRole() {
        return "redirect:/account-role";
    }
}
