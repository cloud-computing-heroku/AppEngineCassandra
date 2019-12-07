package com.example.hello.controller.base;

import com.example.hello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseProductController {

    @Autowired
    protected ProductService productService;

    @RequestMapping(value = "/product")
    public String getAll(Model model) {
        model.addAttribute("productList", this.productService.getAllProduct());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Product");
        return "product-info";
    }

    @RequestMapping(value = "/product/details/{i}")
    public String detailProduct() {
        return "product-details";
    }

    @RequestMapping(value = "/product/create")
    public String createProduct() {
        return "product-create";
    }

    @RequestMapping(value = "/product/do-create")
    public String doCreateProduct() {
        return "redirect:/product";
    }

    @RequestMapping(value = "/product/update/{id}")
    public String updateProduct() {
        return "producer-update";
    }

    @RequestMapping(value = "/product/do-update/{id}")
    public String doUpdateProduct() {
        return "redirect:/product";
    }

    @RequestMapping(value = "/product/delete/{id}")
    public String deleteProduct() {
        return "redirect:/product";
    }
}
