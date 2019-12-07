package com.example.hello.controller.base;

import com.example.hello.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseRoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role")
    public String getAll(Model model) {
        model.addAttribute("roleList", this.roleService.getAllRole());
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
