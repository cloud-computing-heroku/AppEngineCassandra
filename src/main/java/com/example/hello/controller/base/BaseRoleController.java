package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseRoleController {
    @RequestMapping(value = "/role")
    public String getAll() {
        return "admin/role-info";
    }

    @RequestMapping(value = "/role/details/{i}")
    public String detailRole() {
        return "admin/role-details";
    }

    @RequestMapping(value = "/role/do-create")
    public String doCreateRole() {
        return "redirect:/role";
    }

    @RequestMapping(value = "/role/create")
    public String createRole() {
        return "admin/role-create";
    }

    @RequestMapping(value = "/role/update/{id}")
    public String updateRole() {
        return "admin/role-update";
    }

    @RequestMapping(value = "/role/do-update/{id}")
    public String doUpdateRole() {
        return "redirect:/role";
    }

    @RequestMapping(value = "/role/delete/{id}")
    public String deleteRole() {
        return "redirect:/role";
    }
}
