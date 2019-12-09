package com.example.hello.controller.base;

import com.example.hello.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class BaseOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order-info")
    public String getAll(Model model) {
        model.addAttribute("orderList", this.orderService.getAllOrder());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Order");
        return "order-info";
    }

    @RequestMapping(value = "/order-details/{i}")
    public String detailOrder() {
        return "order-details";
    }

    @RequestMapping(value = "/order-create")
    public String createOrder() {
        return "order-create";
    }

    @RequestMapping(value = "/order-do-create")
    public String doCreateOrder() {
        return "redirect:/admin/order-info";
    }

    @RequestMapping(value = "/order-update/{id}")
    public String updateOrder() {
        return "order-update";
    }

    @RequestMapping(value = "/order-do-update/{id}")
    public String doUpdateOrder() {
        return "redirect:/admin/order-info";
    }

    @RequestMapping(value = "/order-delete/{id}")
    public String deleteOrder() {
        return "redirect:/admin/order-info";
    }
}
