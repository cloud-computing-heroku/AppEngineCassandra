package com.example.hello.controller.base;

import com.example.hello.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class BaseStatusController {

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/status-info")
    public String getAll(Model model) {
        model.addAttribute("statusList", this.statusService.getAllStatus());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Status");
        return "status-info";
    }

    @RequestMapping(value = "/status-details/{i}")
    public String detailStatus() {
        return "status-details";
    }

    @RequestMapping(value = "/status-do-create")
    public String doCreateStatus() {
        return "redirect:/admin/status-info";
    }

    @RequestMapping(value = "/status-create")
    public String createStatus() {
        return "status-create";
    }

    @RequestMapping(value = "/status-update/{id}")
    public String updateStatus() {
        return "status-update";
    }

    @RequestMapping(value = "/status-do-update/{id}")
    public String doUpdateStatus() {
        return "redirect:/admin/status-info";
    }

    @RequestMapping(value = "/status-delete/{id}")
    public String deleteStatus() {
        return "redirect:/admin/status-info";
    }
}
