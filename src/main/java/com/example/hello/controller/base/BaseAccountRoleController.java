package com.example.hello.controller.base;

import com.example.hello.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class BaseAccountRoleController {

    @Autowired
    private AccountRoleService accountRoleService;

    @RequestMapping(value = "/account-role-info")
    public String getAll(Model model) {
        model.addAttribute("accountRoleList", this.accountRoleService.getAllAccountRole());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Admin");
        model.addAttribute("sub_active", "Grant Privilege");
        return "admin/account-role-info";
    }

    @RequestMapping(value = "/account-role-details/{i}")
    public String detailRole() {
        return "admin/account-role-details";
    }

    @RequestMapping(value = "/account-role-do-create")
    public String doCreateAccount() {
        return "redirect:/admin/account-role-info";
    }

    @RequestMapping(value = "/account-role-create")
    public String createRole() {
        return "admin/account-role-create";
    }

    @RequestMapping(value = "/account-role-update/{id}")
    public String updateRole() {
        return "admin/account-role-update";
    }

    @RequestMapping(value = "/account-role-do-update/{id}")
    public String doUpdateRole() {
        return "redirect:/admin/account-role-info";
    }

    @RequestMapping(value = "/account-role-delete/{id}")
    public String deleteRole() {
        return "redirect:/admin/account-role-info";
    }
}
