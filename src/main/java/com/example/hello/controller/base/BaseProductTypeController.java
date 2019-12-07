package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseProductTypeController {

    @RequestMapping(value = "/product-type")
    public String getAll() {
        return "product-type-info";
    }

    @RequestMapping(value = "/product-type/details/{i}")
    public String detailProductType() {
        return "product-type-details";
    }

    @RequestMapping(value = "/product-type/create")
    public String createProductType() {
        return "product-type-create";
    }

    @RequestMapping(value = "/product-type/do-create")
    public String doCreateProduct() {
        return "redirect:/product-type";
    }

    @RequestMapping(value = "/product-type/update/{id}")
    public String updateProductType() {
        return "product-type-update";
    }

    @RequestMapping(value = "/product-type/do-update/{id}")
    public String doUpdateProductType() {
        return "redirect:/product-type";
    }

    @RequestMapping(value = "/product-type/delete/{id}")
    public String deleteProductType() {
        return "redirect:/product-type";
    }
}
