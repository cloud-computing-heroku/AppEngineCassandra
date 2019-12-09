package com.example.hello.controller.base;

import com.example.hello.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class BaseProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/product-type-info")
    public String getAll(Model model) {
        model.addAttribute("productTypeList", this.productTypeService.getAllProductType());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Product Type");
        return "product-type-info";
    }

    @RequestMapping(value = "/product-type-details/{i}")
    public String detailProductType() {
        return "product-type-details";
    }

    @RequestMapping(value = "/product-type-create")
    public String createProductType() {
        return "product-type-create";
    }

    @RequestMapping(value = "/product-type-do-create")
    public String doCreateProduct() {
        return "redirect:/admin/product-type-info";
    }

    @RequestMapping(value = "/product-type-update/{id}")
    public String updateProductType() {
        return "product-type-update";
    }

    @RequestMapping(value = "/product-type-do-update/{id}")
    public String doUpdateProductType() {
        return "redirect:/admin/product-type-info";
    }

    @RequestMapping(value = "/product-type-delete/{id}")
    public String deleteProductType() {
        return "redirect:/admin/product-type-info";
    }
}
