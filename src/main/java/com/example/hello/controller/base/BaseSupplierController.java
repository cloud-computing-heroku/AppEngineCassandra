package com.example.hello.controller.base;

import com.example.hello.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseSupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "/supplier")
    public String getAll(Model model) {
        model.addAttribute("supplierList", this.supplierService.getAllSupplier());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Supplier");
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
