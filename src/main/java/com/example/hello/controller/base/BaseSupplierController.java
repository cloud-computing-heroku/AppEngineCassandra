package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseSupplierController {

    @RequestMapping(value = "/supplier")
    public String getAll() {
        return "supplier-info";
    }

    @RequestMapping(value = "/supplier/details/{i}")
    public String detailSupplier() {
        return "supplier-details";
    }

    @RequestMapping(value = "/supplier/do-create")
    public String doCreateSupplier() {
        return "redirect:/supplier";
    }

    @RequestMapping(value = "/supplier/create")
    public String createSupplier() {
        return "supplier-create";
    }

    @RequestMapping(value = "/supplier/update/{id}")
    public String updateSupplier() {
        return "supplier-update";
    }

    @RequestMapping(value = "/supplier/do-update/{id}")
    public String doUpdateSupplier() {
        return "redirect:/supplier";
    }

    @RequestMapping(value = "/supplier/delete/{id}")
    public String deleteSupplier() {
        return "redirect:/supplier";
    }
}
