package com.example.hello.controller.base;

import com.example.hello.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class BaseRoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role-info")
    public String getAll(Model model) {
        model.addAttribute("roleList", this.roleService.getAllRole());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Admin");
        model.addAttribute("sub_active", "Role");
        return "admin/role-info";
    }

    @RequestMapping(value = "/role/details/{i}")
    public String detailRole() {
        return "admin-role-details";
    }

    @RequestMapping(value = "/role-do-create")
    public String doCreateRole() {
        return "redirect:/admin/role-info";
    }

    @RequestMapping(value = "/role-create")
    public String createRole() {
        return "admin-role-create";
    }

    @RequestMapping(value = "/role-update/{id}")
    public String updateRole() {
        return "admin-role-update";
    }

    @RequestMapping(value = "/role-do-update/{id}")
    public String doUpdateRole() {
        return "redirect:/admin/role-info";
    }

    @RequestMapping(value = "/role-delete/{id}")
    public String deleteRole() {
        return "redirect:/admin/role-info";
    }
}
