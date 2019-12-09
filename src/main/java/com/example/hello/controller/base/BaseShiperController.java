package com.example.hello.controller.base;

import com.example.hello.model.Shiper;
import com.example.hello.service.ShiperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class BaseShiperController {

    @Autowired
    private ShiperService shiperService;

    @RequestMapping(value = "/shiper-info")
    public String getAll(Model model) {
        model.addAttribute("shiperList", this.shiperService.getAllShiper());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Shiper");
        return "shiper-info";
    }

    @RequestMapping(value = "/shiper-details/{i}")
    public String detailShiper() {
        return "shiper-details";
    }

    @RequestMapping(value = "/shiper-do-create")
    public String doCreateShiper() {
        return "redirect:/admin/shiper-info";
    }

    @RequestMapping(value = "/shiper-create")
    public String createShiper() {
        return "shiper-create";
    }

    @RequestMapping(value = "/shiper-update/{id}")
    public String updateShiper() {
        return "shiper-update";
    }

    @RequestMapping(value = "/shiper-do-update/{id}")
    public String doUpdateShiper() {
        return "redirect:/admin/shiper-info";
    }

    @RequestMapping(value = "/shiper-delete/{id}")
    public String deleteShiper() {
        return "redirect:/admin/shiper-info";
    }
}
