package com.example.hello.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseOrderController {

    @RequestMapping(value = "/order")
    public String getAll() {
        return "order-info";
    }

    @RequestMapping(value = "/order/details/{i}")
    public String detailOrder() {
        return "order-details";
    }

    @RequestMapping(value = "/order/create")
    public String createOrder() {
        return "order-create";
    }

    @RequestMapping(value = "/order/do-create")
    public String doCreateOrder() {
        return "redirect:/order";
    }

    @RequestMapping(value = "/order/update/{id}")
    public String updateOrder() {
        return "order-update";
    }

    @RequestMapping(value = "/order/do-update/{id}")
    public String doUpdateOrder() {
        return "redirect:/order";
    }

    @RequestMapping(value = "/order/delete/{id}")
    public String deleteOrder() {
        return "redirect:/order";
    }
}
